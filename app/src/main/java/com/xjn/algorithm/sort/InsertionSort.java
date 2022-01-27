package com.xjn.algorithm.sort;

/*
插入排序的过程跟整理扑克牌一摸一样。时间复杂度为O(n^2)。
当前索引从头到尾依次移动，当前索引之前的都是已排好的序列，之后的都是尚未排序的序列。
每次移动索引，就将其与上一个位置的值比较，若当前值更小，则和上一个值交换位置，然后再和更上一个值比较，如此往复，当前索引值最终就会插入到正确的位置。

改进：
插入一个元素时，需要不停的和上一个位置的元素比较、交换，这就比较耗时了，
既然前面的元素已经排好序，那么可以通过二分查找直接找到插入的位置，然后插入，
而插入位置之后的元素则通过复制数组的方式往后移动一位，这比一个一个的比较、交换快得多。
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
