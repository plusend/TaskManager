package com.plusend.taskmanager.util;


import android.util.Log;

public class Logger {
    private static final String TAG = "TaskManager";
    public static boolean debug = true;

    private Logger() {
    }

    public static void v(String tag, String msg) {
        if (debug) {
            Log.v(tag, msg);
        }

    }

    public static void d(String tag, String msg) {
        if (debug) {
            Log.d(tag, msg);
        }

    }

    public static void i(String tag, String msg) {
        if (debug) {
            Log.i(tag, msg);
        }

    }

    public static void w(String tag, String msg) {
        if (debug) {
            Log.w(tag, msg);
        }

    }

    public static void e(String tag, String msg) {
        if (debug) {
            Log.e(tag, msg);
        }

    }
}
