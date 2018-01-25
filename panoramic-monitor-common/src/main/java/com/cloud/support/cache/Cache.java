package com.cloud.support.cache;

import com.cloud.util.LoggerUtils;
import com.cloud.util.TLogger;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author summer
 * 具有过期时间的缓存设计
 */
public class Cache<K, V> {
    private static final transient TLogger DB_LOGGER = LoggerUtils.getLogger(Cache.class);
    private  ConcurrentHashMap<K, V> map = new ConcurrentHashMap<K, V>(16);
    private  DelayQueue<DelayedItem<K>> queue = new DelayQueue<DelayedItem<K>>();


    private Cache() {
        Thread t = new Thread() {
            @Override
            public void run() {
                dameonCheckOverdueKey();
            }
        };
        t.setDaemon(true);
        t.start();
    }

    /**
     * 利用工厂方法防止this在构造方法中溢出
     * @return
     */
    public static Cache newInstance() {
        Cache cache = new Cache();
        return cache;

    }

    /**
     * @throws InterruptedException
     * @author:summer
     */
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        int cacheNumber = 10;
        int liveTime = 0;
        Cache<String, Integer> cache = new Cache<String, Integer>();

        for (int i = 0; i < cacheNumber; i++) {
            liveTime = random.nextInt(3000);
            System.out.println(i + "  " + liveTime);
            cache.put(i + "", i, random.nextInt(liveTime));
            if (random.nextInt(cacheNumber) > 7) {
                liveTime = random.nextInt(3000);
                System.out.println(i + "  " + liveTime);
                cache.put(i + "", i, random.nextInt(liveTime));
            }
        }

        Thread.sleep(300);
        System.out.println();
    }

    public void put(K k, V v, long liveTime) {
        V v2 = map.putIfAbsent(k, v);
        DelayedItem<K> tmpItem = new DelayedItem<K>(k, liveTime);
        if (v2 != null) {
            queue.remove(tmpItem);
        }
        queue.put(tmpItem);
    }

    public void dameonCheckOverdueKey() {
        while (true) {
            DelayedItem<K> delayedItem = queue.poll();
            if (delayedItem != null) {
                map.remove(delayedItem.getT());
                DB_LOGGER.warn(System.nanoTime() + " remove " + delayedItem.getT() + " from cache");
            }
            try {
                Thread.sleep(300);
            } catch (Exception e) {
                DB_LOGGER.error(System.nanoTime() + " remove 失败 " + delayedItem.getT() + " from cache");
            }
        }
    }

}

class DelayedItem<T> implements Delayed {

    private T t;
    private long liveTime;
    private long removeTime;

    public DelayedItem(T t, long liveTime) {
        this.setT(t);
        this.liveTime = liveTime;
        this.removeTime = TimeUnit.NANOSECONDS.convert(liveTime, TimeUnit.NANOSECONDS) + System.nanoTime();
    }

    @Override
    public int compareTo(Delayed o) {
        if (o == null) {
            return 1;
        }
        if (o == this) {
            return 0;
        }
        if (o instanceof DelayedItem) {
            DelayedItem<T> tmpDelayedItem = (DelayedItem<T>) o;
            if (liveTime > tmpDelayedItem.liveTime) {
                return 1;
            } else if (liveTime == tmpDelayedItem.liveTime) {
                return 0;
            } else {
                return -1;
            }
        }
        long diff = getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return diff > 0 ? 1 : diff == 0 ? 0 : -1;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(removeTime - System.nanoTime(), unit);
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public int hashCode() {
        return t.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof DelayedItem) {
            return object.hashCode() == hashCode() ? true : false;
        }
        return false;
    }

}
