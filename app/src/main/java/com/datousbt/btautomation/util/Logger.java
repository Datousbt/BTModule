package com.datousbt.btautomation.util;

import android.util.Log;

public class Logger {

    private static final String TAG = "DiPlus";

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void e(Throwable t) {
        Log.e(TAG, "error", t);
    }
}