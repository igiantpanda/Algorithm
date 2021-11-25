package com.xjn.algorithm.sort;

/*
选择排序是一种最简单的排序算法。时间复杂度为O(n^2)。
首先，找到数组中最小的那个元素，其次，将它和数组的第 一个元素交换位置（如果第一个元素就是最小元素那么它就和自己交换）。
再次，在剩下的元素中 找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。
这种方法 叫做选择排序，因为它在不断地选择剩余元素之中的最小者。
*/
public class SelectionSort extends BaseSort {

    public static void sort(Comparable[] a) {
        if (null == a) {
            return;
        }

        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (compare(a[min], a[j]) > 0) {
                    min = j;
                }
            }

            if (min > i) {
                swap(a, min, i);
            }
        }
    }

}
