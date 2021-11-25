package com.xjn.algorithm.sort;

/*
插入排序的过程跟整理扑克牌一摸一样。时间复杂度为O(n^2)。
当前索引从头到尾依次移动，当前索引之前的都是已排好的序列，之后的都是尚未排序的序列。
每次移动索引，就将其与上一个位置的值比较，若当前值更小，则和上一个值交换位置，然后再和更上一个值比较，如此往复，当前索引值最终就会插入到正确的位置。
 */
public class InsertionSort extends BaseSort {

    public static void sort(Comparable[] a) {
        if (null == a) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && (compare(a[j], a[j - 1]) < 0); j--) {
                swap(a, j, j - 1);
            }
        }
    }

}
