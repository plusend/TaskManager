package com.plusend.taskmanager;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

enum AsyncTaskManager {
    INSTANCE;

    private final String TAG = "AsyncTaskManager";
    private ThreadPoolExecutor threadPoolExecutor;

    AsyncTaskManager() {
        final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
        final int KEEP_ALIVE_TIME = 1;
        final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
        final BlockingQueue<Runnable> blockingQueue = new LinkedBlockingQueue<>();
        threadPoolExecutor = new ThreadPoolExecutor(NUMBER_OF_CORES, NUMBER_OF_CORES,
                KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, blockingQueue);
    }

    public void post(Runnable runnable) {
        threadPoolExecutor.execute(runnable);
    }

    public void remove(Runnable runnable) {
        threadPoolExecutor.remove(runnable);
    }
}
