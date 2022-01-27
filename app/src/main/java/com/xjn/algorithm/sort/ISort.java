package com.xjn.algorithm.sort;

/*
十大经典排序算法：https://www.runoob.com/w3cnote/ten-sorting-algorithm.html
排序算法            时间复杂度               空间复杂度   稳定性
            平均      最好      最坏
冒泡排序     O(n^2)    O(n)     O(n^2)      O(1)        Y
选择排序     O(n^2)    O(n^2)   O(n^2)      O(1)        N
插入排序     O(n^2)    O(n)     O(n^2)      O(1)        Y
希尔排序     O(nlogn)  O(nlogn) O(n^2)      O(1)        N   (时间复杂度参考ShellSort.java)
归并排序     O(nlogn)  O(nlogn) O(nlogn)    O(n)        Y
快速排序     O(nlogn)  O(nlogn) O(n^2)      O(logn)     Y   (空间复杂度最坏为n)
堆排序       O(nlogn)  O(nlogn) O(nlogn)    O(1)        N
计数排序     O(n+k)    O(n+k)   O(n+k)      O(k)        Y   (k为待排序元素最大值与最小值只差)
桶排序       O(n+k)    O(n+k)   O(nlogn)    O(n+k)      Y   (k为桶个数；最坏时间复杂度和稳定性取决于桶内排序算法)
基数排序     O(kn)     O(kn)    O(kn)       O(n+k)      Y   (k为常数)
Tim排序     O(nlogn)  O(n)     O(nlogn)    O(n)        Y

备注：示例代码中的排序都是针对数字型元素，因此排序算法中并未考虑待排序元素为null的情况。
 */
public interface ISort {
    void sort(Comparable[] a);
    int compare(Comparable a, Comparable b);
    void swap(Comparable[] a, int i, int j);
    boolean isSorted(Comparable[] a);
}
