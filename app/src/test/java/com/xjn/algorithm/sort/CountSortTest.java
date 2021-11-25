package com.xjn.algorithm.sort;

import com.xjn.algorithm.utils.ALog;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class CountSortTest {
    private static final String TAG = CountSortTest.class.getSimpleName();

    @Test
    public void sort() {
        for (Integer[] a : SortData.getBaseDataList()) {
            ALog.d(TAG, "sort, is sorted:" + BaseSort.isSorted(a));
            CountSort.sort(a);
            ALog.d(TAG, "sort, a:" + Arrays.toString(a));
            assertTrue(BaseSort.isSorted(a));
        }
    }

    @Test
    public void sort2() {
        for (Integer[] a : SortData.getBaseDataList()) {
            ALog.d(TAG, "sort2, is sorted:" + BaseSort.isSorted(a));
            CountSort.sort2(a);
            ALog.d(TAG, "sort2, a:" + Arrays.toString(a));
            assertTrue(BaseSort.isSorted(a));
        }
    }

}