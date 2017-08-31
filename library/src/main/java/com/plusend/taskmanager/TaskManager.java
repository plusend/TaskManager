package com.plusend.taskmanager;


public enum TaskManager {
    INSTANCE;

    private final String TAG = "TaskManager";

    private SyncTaskManager syncTaskManager;
    private AsyncTaskManager asyncTaskManager;

    TaskManager() {
        syncTaskManager = SyncTaskManager.INSTANCE;
        asyncTaskManager = AsyncTaskManager.INSTANCE;
    }

    public static TaskManager getInstance() {
        return INSTANCE;
    }

    public void postSync(Runnable runnable) {
        syncTaskManager.post(runnable);
    }

    public void postSyncAtFrontOfQueue(Runnable runnable) {
        syncTaskManager.postAtFrontOfQueue(runnable);
    }

    public void postSyncDelayed(Runnable runnable, long delay) {
        syncTaskManager.postDelayed(runnable, delay);
    }

    public void postSyncAtTime(Runnable runnable, long time) {
        syncTaskManager.postAtTime(runnable, time);
    }

    public void removeSync(Runnable runnable) {
        syncTaskManager.remove(runnable);
    }

    public void postAsync(Runnable runnable) {
        asyncTaskManager.post(runnable);
    }

    public void removeAsync(Runnable runnable) {
        asyncTaskManager.remove(runnable);
    }

}
