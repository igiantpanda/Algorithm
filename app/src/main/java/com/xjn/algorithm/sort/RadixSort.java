package com.xjn.algorithm.sort;

import com.xjn.algorithm.utils.ALog;

import java.util.ArrayList;
import java.util.Comparator;

/*
基数排序是一种针对整数的非比较型排序，
1）创建10个桶
2）遍历待排序数组，将各元素放入桶中，桶的下标为待排序元素最低位的值
3）遍历桶，将各桶元素按先进先出的方式移动到待排序数组中
4）重复2）和3），每次重复时，步骤2）中桶的下标变为待排序元素第i低位的值，i为重复次数
以上是针对待排序元素为非负数的情况，如果待排序元素有负数，那么还得增加9个桶用于存放负数，但由于桶的下标不可能为负数，
因此，我们将待排序元素计算出来的下标值都加上9，这样就变成了一个非负数。
 */
public class RadixSort extends BaseSort {
    private static final String TAG = RadixSort.class.getSimpleName();

    public static void sort(Integer[] a) {
        if (null == a) {
            return;
        }

        int len = getMaxLen(a);
        int div = 1;
        int offset = 9;
        int bucketCount = 19;
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i = 1; i <= len; i++, div *= 10) {
            for (Integer v : a) {
                buckets[v / div % 10 + offset].add(v);
            }
            int index = 0;
//            ALog.d(TAG, "sort, i:" + i);
            for (ArrayList<Integer> bucket : buckets) {
//                ALog.d(TAG, "sort, bucket:" + bucket);
                for (Integer v : bucket) {
                    a[index++] = v;
                }
                bucket.clear();
            }
        }

    }

    private static int getMaxLen(Integer[] a) {
        int max = -Integer.MAX_VALUE;
        for (Integer value : a) {
            if (value > max) {
                max = value;
            }
        }

        int len = 1;
        while ((max = max / 10) > 0) {
            len++;
        }

        return len;
    }

}
