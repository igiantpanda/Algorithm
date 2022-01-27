package com.xjn.algorithm.utils;

import android.util.Log;

public class ALog {

//    public static void d(String tag, String msg) {
//        System.out.println("D/" + tag + ": " + msg);
//    }
//
//    public static void e(String tag, String msg) {
//        System.out.println("E/" + tag + ": " + msg);
//    }
    public static void d(String tag, String msg) {
        Log.d(getTag(tag), msg);
    }

    public static void e(String tag, String msg) {
        Log.e(getTag(tag), msg);
    }

    private static String getTag(String tag) {
        return "xjn-" + tag;
    }
}
