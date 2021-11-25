package com.xjn.algorithm.sort;

/*
冒泡排序就是从第一个元素开始，依次和下一个元素进行比较，如果顺序错误就将其交换，这看起来就像各个元素依次浮到了顶端。
改进算法：某次遍历时若未发生交换，则说明剩余元素已经有序，则直接退出。但这种改进仅仅是减少了一些比较过程，对性能的提升并没有太大作用。
 */
public class BubbleSort extends BaseSort {

    public static void sort(Comparable[] a) {
        if (null == a) {
            return;
        }

        int count = a.length;
        while (count-- > 0) {
            boolean flag = true; // 改进算法的标记
            for (int j = 0; j < count; j++) {
                if (compare(a[j], a[j + 1]) > 0) {
                    swap(a, j, j + 1);
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }

}
