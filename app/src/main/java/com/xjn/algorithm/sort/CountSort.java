package com.xjn.algorithm.sort;

import com.xjn.algorithm.utils.ALog;

import java.util.Arrays;

/*
计数排序主要是针对待排序数组为元素为整数、且值比较集中的情况，其是时间复杂度为O(N + K)。
对于有n个元素的待排序数组N，假设其取值范围为[0, k]。
基础方案：
1）新建一个长度为k+1的数组K，K各元素值为0。
2）遍历待排序数组，并将K[N[i]]的值加1。
3）遍历K，将K中各元素复制K[i]遍到N。
增强方案：
上述的排序方式中，相等的元素在排序后并不一定是按照原有的顺序排列，因此，就有了下面的改进算法。
1）新建一个长度为k+1的数组K，K各元素值为0，以及一个存放排好序元素的数组S，长度为n。
2）遍历待排序数组，并将K[N[i]]的值加1。
3）将K[i]的值增加K[0]+K[1]+...+K[i-1]，于是，K[i]的值就表示i在待排序数组中排在第K[i]位。
4）从后往前遍历待排序数据（基础方案是遍历数组K），将其值i放入S[K[i]-1]中。
5）将S复制到N中。
前两步跟基础方案一样，第三步是为第四步做准备的，因为第四步要遍历的是待排序数组，这就需要知道每个元素排在第几位，
才能够将其复制到对应的位置，再加上第四步的遍历是从后往前，这就保证了元素能够按原有顺序排列。
 */
public class CountSort extends BaseSort {
    private static final String TAG = CountSort.class.getSimpleName();

    // 基础方案
    public static void sort(Integer[] a) {
        if (null == a || a.length < 2) {
            return;
        }

        int min = getMin(a);
        int max = getMax(a);
        int[] k = new int[max - min + 1];
        for (Integer i : a) {
            k[i - min]++; // k中个元素的值表示其下标值在a中的个数
        }

//        ALog.d(TAG, "sort k:" + Arrays.toString(k));
        int index = 0;
        for (int i = 0; i < k.length; i++) {
            while (k[i]-- > 0) {
//                ALog.d(TAG, "sort a[" + index + "]=" + i + " - " + min + " = " + (i - min));
                a[index++] = i + min;
            }
        }
    }

    // 增强方案
    public static void sort2(Integer[] a) {
        if (null == a || a.length < 2) {
            return;
        }

        int min = getMin(a);
        int max = getMax(a);

        // 1)
        int[] k = new int[max - min + 1];
        for (Integer i : a) {
            k[i - min]++;
        }

        // 2)
        for (int i = 1; i < k.length; i++) {
            k[i] += k[i - 1];
        }

        // 3)
        int[] sort = new int[a.length];
        for (int i = a.length - 1; i >= 0; i--) {
            sort[(k[a[i] - min]--) - 1] = a[i];
        }

        for (int i = 0; i < sort.length; i++) {
            a[i] = sort[i];
        }
    }

    private static int getMin(Integer[] a) {
        int min = Integer.MAX_VALUE;
        for (Integer value : a) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    private static int getMax(Integer[] a) {
        int max = -Integer.MAX_VALUE;
        for (Integer value : a) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }
}
