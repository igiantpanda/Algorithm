package com.xjn.algorithm.sort;

import com.xjn.algorithm.utils.ALog;

import java.util.Arrays;

/*
归并排序采用了分而治之的思想，先将一个大的数组分割为2个小数组，并分别对2个小数组进行（归并）排序，最后再将2个排好序的小数组进行归并。
归并排序有2中基本实现，一种是自顶向下的方式（递归），另一种是自底向上的方式（迭代）。
 */
public class MergeSort extends BaseSort {
    public static class UpToBottom extends BaseSort {

        public static void sort(Comparable[] a) {
            if (null == a) {
                return;
            }

            Comparable[] bak = new Comparable[a.length];
            sort(a, bak, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, Comparable[] bak, int low, int high) {
            if (high - low > 1) {
                int mid = (high + low) / 2;
                sort(a, bak, low, mid);
                sort(a, bak, mid + 1, high);
                merge(a, bak, low, mid, high);
            } else if (high - low == 1) {
                if (compare(a[high], a[low]) < 0) {
                    MergeSort.swap(a, high, low);
                }
            }
            // else if (high == low), do nothing
        }

    }

    public static class BottomToUp extends BaseSort {

        public static void sort(Comparable[] a) {
            if (null == a) {
                return;
            }

            Comparable[] bak = new Comparable[a.length];
            int max = a.length - 1;
            for (int i = 2; i < a.length * 2; i *= 2) {
//                int range = i * 2;
                for (int low = 0; low < a.length; low += i) {
                    int high = i + low - 1;
                    int mid = (low + high) / 2;
                    if (mid >= max) {
                        continue;
                    }
                    if (high > max) {
                        high = max;
                    }
                    merge(a, bak, low, mid, high);
                }
            }
        }


    }

    private static void merge(Comparable[] a, Comparable[] bak, int low, int mid, int high) {
        int pos = 0;
        int i = low;
        int j = mid + 1;

//        ALog.d("MergeSort", "merge before:" + Arrays.toString(a) + ", [" + low + " " + mid + "], [" + (mid + 1) + " " + high + "]");
        while (i <= mid && j <= high) {
            if (compare(a[i], a[j]) > 0) {
                bak[pos++] = a[j++];
            } else {
                bak[pos++] = a[i++];
            }
        }

        if (i <= mid) {
            System.arraycopy(a, i, bak, pos, mid - i + 1);
        } else if (j <= high) {
            System.arraycopy(a, j, bak, pos, high -j + 1);
        }

        System.arraycopy(bak, 0, a, low, high - low + 1);
//        ALog.d("MergeSort", "merge after:" + Arrays.toString(a));
    }
}
