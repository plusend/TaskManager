package com.plusend.taskmanager;


import android.os.Handler;
import android.os.HandlerThread;

enum SyncTaskManager {
    INSTANCE;

    private final String TAG = "SyncTaskManager";

    private Handler handler;

    SyncTaskManager() {
        HandlerThread handlerThread = new HandlerThread(TAG);
        handlerThread.start();
        handler = new Handler(handlerThread.getLooper());
    }

    public static SyncTaskManager getInstance() {
        return INSTANCE;
    }

    public boolean post(Runnable runnable) {
        return handler.post(runnable);
    }

    public boolean postAtFrontOfQueue(Runnable runnable) {
        return handler.postAtFrontOfQueue(runnable);
    }

    public boolean postDelayed(Runnable runnable, long delay) {
        return handler.postDelayed(runnable, delay);
    }

    public boolean postAtTime(Runnable runnable, long time) {
        return handler.postAtTime(runnable, time);
    }

    public void remove(Runnable runnable) {
        handler.removeCallbacks(runnable);
    }


}
