package com.xjn.algorithm.sort;

import com.xjn.algorithm.utils.ALog;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class QuickSortTest {
    private static final String TAG = QuickSortTest.class.getSimpleName();

    @Test
    public void sort() {
        for (Integer[] a : SortData.getDataList()) {
            ALog.d(TAG, "sort, is sorted:" + BaseSort.isSorted(a));
            QuickSort.sort(a);
            ALog.d(TAG, "sort, a:" + Arrays.toString(a));
            assertTrue(BaseSort.isSorted(a));
        }

    }

}