package com.xjn.algorithm.sort;

import com.xjn.algorithm.utils.ALog;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class BucketSortTest {
    private static final String TAG = BucketSortTest.class.getSimpleName();

    @Test
    public void sort() {
        for (double[] a : SortData.getDoubleDataList()) {
            ALog.d(TAG, "sort, is sorted:" + BucketSort.isSorted(a));
            BucketSort.sort(a);
            ALog.d(TAG, "sort, a:" + Arrays.toString(a));
            assertTrue(BucketSort.isSorted(a));
        }
    }

}