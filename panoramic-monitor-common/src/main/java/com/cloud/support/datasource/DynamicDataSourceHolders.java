package com.cloud.support.datasource;

/**
 * @author summer
 */
public class DynamicDataSourceHolders {

    public static final ThreadLocal<String> HOLDER = new ThreadLocal<>();

    /** 设置
     * @param name
     */
    public static void putDataSource(String name) {
        HOLDER.set(name);
    }

    /**获取
     * @return
     */
    public static String getDataSource() {
        return HOLDER.get();
    }

    /**
     * 移除
     */
    public static void removeDataSource() {
        HOLDER.remove();
    }
}
