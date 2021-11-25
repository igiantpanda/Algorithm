package com.xjn.algorithm.sort;

/*
快速排序使用了分而治之的思想。
先选定一个元素作为基准值，例如a[m]，然后从前往后找到比基准值大的元素a[i]，再从后往前找到一个比基准值小的元素a[j]，交换a[i]和a[j]，
然后继续查找、交换，直到i大于等于j，再将a[m]与a[j]交换，这样，基准值（现在是a[j]）左边的元素都不比基准值大，右边的元素都不比基准值小，
接着就是递归将a[j]左边和右边的子数组分别进行排序，这样就完成了整个排序过程。
 */
public class QuickSort extends BaseSort {

    public static void sort(Comparable[] a) {
        if (null == a) {
            return;
        }

        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int base = low;
        int i = low;
        int j = high + 1;
        while (true) {
            while (a[--j].compareTo(a[base]) >= 0 && i < j) ;
            while (a[++i].compareTo(a[base]) <= 0 && i < j) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, base, j);

        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }
}
