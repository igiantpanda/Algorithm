package com.xjn.algorithm.sort;

import com.xjn.algorithm.utils.ALog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
桶排序的原理与计数排序类似，但可以对非整数数组排序。平均时间复杂度为O(N)，最坏为O(NlogN)。
对于N个元素的数组，先建立M个桶，桶间距离为(N(max) - N(min)) / (M - 1),
然后将待排序数组的各元素依次放入各桶中，对含有超过1个元素的桶进行排序，最后依次将各桶中的元素取出并放回原数组。
 */
public class BucketSort extends BaseSort {
    private static final String TAG = BucketSort.class.getSimpleName();

    public static void sort(double[] a) {
        if (null == a) {
            return;
        }

        ArrayList<Double>[] buckets = new ArrayList[a.length];
        double min = getMin(a);
        double range = (getMax(a) - min) / (buckets.length - 1); // bucket range

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (double v : a) {
              buckets[(int) ((v - min) / range)].add(v);
        }

        int index = 0;
        for (ArrayList<Double> bucket : buckets) {
            if (bucket.size() == 1) {
                a[index++] = bucket.get(0);
            } else if (bucket.size() > 1) {
                bucket.sort((Comparator<Double>) Double::compareTo);
                for (int i = 0; i < bucket.size(); i++) {
                    a[index++] = bucket.get(i);
                }
            }
//            ALog.d(TAG, "sort bucket:" + bucket + ", index:" + (index - 1) + ", a:" + Arrays.toString(a));
        }

    }

    public static boolean isSorted(double[] a) {
        if (null == a) {
            return true;
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private static double getMin(double[] a) {
        double min = Integer.MAX_VALUE;
        for (double value : a) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    private static double getMax(double[] a) {
        double max = -Integer.MAX_VALUE;
        for (double value : a) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }
}
