package com.cloud.util.key;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/**
 * @author summer
 */
public class ScheduledThreadPoolExectuorWithDynamicSize extends ScheduledThreadPoolExecutor {

    private final Thread shutdownThread;

    public ScheduledThreadPoolExectuorWithDynamicSize(final int corePoolSize, ThreadFactory threadFactory) {
        super(corePoolSize, threadFactory);
        setCorePoolSize(corePoolSize);
        shutdownThread = new Thread(new Runnable() {
            public void run() {
                shutdown();
                if (shutdownThread != null) {
                    try {
                        Runtime.getRuntime().removeShutdownHook(shutdownThread);
                    } catch (IllegalStateException ise) {
                        // NOPMD
                    }
                }
            }
        });
        Runtime.getRuntime().addShutdownHook(shutdownThread);
    }
}
