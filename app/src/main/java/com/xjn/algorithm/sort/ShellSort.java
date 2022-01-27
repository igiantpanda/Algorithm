package com.xjn.algorithm.sort;

/*
希尔排序是插入排序的改进版本。
插入排序每次只能移动一个位置，若最小值在数组末尾，则需要移动N-1次才能移动到首位。
希尔排序则是可以将2个较远的元素进行交换，它先将原数组分为h个子数组，每个子数组都是由原数组中间隔h的元素组成。
例如，原数组为：
  0 9 8 7 6 5 4 3 2 1
当h为3时，分割后的子数组为：
  0     7     4     1
    9     6     3
      8     5     2
这时，分别对3个子数组排序：
  0     1     4     7
    3     6     9
      2     5     8
完成一轮排序后，再减小h的大小继续排序，直到h为1时，各子数组排序后，原数组也完成了排序。
下例中，h的取值会从数组长度的一半开始，每完成一轮排序，h的长度就减半。

希尔排序的时间复杂度跟增量序列（h取值的集合）有关，这个问题目前还是一个数学难题，尚无定论。
有时为nlogn，有时为O(n^m)，m介于1和2之间，也有一说m为1.3。
 */
public class ShellSort extends BaseSort {

    public static void sort(Comparable[] a) {
        if (null == a) {
            return;
        }

        for (int step = a.length / 2; step > 0; step /= 2) {
            for (int i = step; i < a.length; i++) {
                for (int j = i; j >= step && (compare(a[j], a[j - step]) < 0); j -= step) {
                    swap(a, j, j - step);
                }
            }
        }
    }

}
