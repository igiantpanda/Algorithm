package com.xjn.algorithm.sort;

public abstract class BaseSort {

    public static int compare(Comparable a, Comparable b) {
        if (null == a && null == b) {
            return 0;
        } else if (null == a) {
            return -1;
        } else if (null == b) {
            return 1;
        }

        return a.compareTo(b);
    }

    public static void swap(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static boolean isSorted(Comparable[] a) {
        if (null == a) {
            return true;
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (compare(a[i], a[i + 1]) > 0) {
                return false;
            }
        }

        return true;
    }

}
