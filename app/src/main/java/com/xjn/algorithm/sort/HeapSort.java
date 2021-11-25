package com.xjn.algorithm.sort;

/*
堆排序是一种利用堆的特性来进行排序的算法。
堆：通常是可以被看做一颗完全二叉树的数组对象。
大顶堆：每个节点都不小于其子节点。
小顶堆：每个节点都不大于其子节点。
堆排序过程：
1.构造堆，也就是将待排序数组构造成一个堆。
  构造堆有2种方式，一种是从堆顶元素开始，从前往后依次将各个元素进行下沉，这种方式时间复杂度为O(NlogN);
  另一种方式则是从最后一个非叶子节点开始，从后往前依次将各个元素进行下沉，这种方式最多需要2N次比较和N次交换，时间复杂度为O(N)。
2.取出堆顶元素，并调整堆。
  调整堆有2种方式：下沉、先下沉后上浮。本例仅实现下沉方式。
3.重复步骤2，直至堆大小为1。
 */
public class HeapSort extends BaseSort {
    private static final String TAG = HeapSort.class.getSimpleName();

    public static void sort(Comparable[] a) {
        if (null == a) {
            return;
        }

        for (int i = (a.length - 2) / 2; i >= 0; i--) {
            sink(a, i, a.length - 1);
        }

        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            sink(a, 0, i - 1);
        }
    }

    public static void sort2(Comparable[] a) {
        if (null == a) {
            return;
        }

        for (int i = 1; i < a.length; i++) {
            swim(a, i);
        }

        for (int i = a.length - 1; i > 0; i--) {
            swap(a, 0, i);
            sink(a, 0, i - 1);
        }
    }


    private static void swim(Comparable[] a, int pos) {
        int parent = (pos - 1) / 2;
        Comparable max = a[pos];

        while (parent >= 0 && pos > 0 && max.compareTo(a[parent]) > 0) {
            a[pos] = a[parent]; // 比父节点大，则和父节点交换，当前节点的值不需要写入父节点，因为后面可能还要和父节点交换，因此待上浮完成后再设置
            pos = parent;
            parent = (pos - 1) / 2;
        }
        a[pos] = max;
    }

    private static void sink(Comparable[] a, int pos, int end) {
        Comparable min = a[pos];
        int child = pos * 2 + 1;

        while (child <= end) {
            if (child < end) { // 有右子节点
                if (a[child].compareTo(a[child + 1]) < 0) {
                    child++; // 右子节点较大，因此和右子节点比较
                }
            }

            if (min.compareTo(a[child]) > 0) {
                break; // 当比子节点大时，说明不需要在下沉了
            }
            a[pos] = a[child]; // 比子节点小，则和子节点交换，当前节点的值不需要写入子节点，因为后面可能还要和子节点交换，因此待下沉完成后再设置
            pos = child;
            child = pos * 2 + 1;
        }
        a[pos] = min;
    }
}
