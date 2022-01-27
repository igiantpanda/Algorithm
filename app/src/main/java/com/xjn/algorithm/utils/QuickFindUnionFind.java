package com.xjn.algorithm.utils;

import com.xjn.algorithm.sort.CountSort;

import java.util.Arrays;

/**
 * 注重快速判断是否连通的Union Find算法。
 * 此算法判断2个点是否连通非常快，但将2个点连通的过程却非常慢，每次操作都需要遍历所有的点。
 */
public class QuickFindUnionFind {
    private static final String TAG = QuickFindUnionFind.class.getSimpleName();
    private int[] mId; // 未进行连通时，每个顶点的id为其下标

    public QuickFindUnionFind(int count) {
        mId = new int[count];
        for (int i = 0; i < count; i++) {
            mId[i] = i;
        }
    }

    // 将2个顶点连通。
    // 即将所有id值与顶点v相同的顶点的id设置为顶点w的id。
    public void union(int v, int w) {
        if (mId[v] == mId[w]) {
            return;
        }

        int vId = mId[v];
        for (int i = 0; i < mId.length; i++) {
            if (mId[i] == vId) {
                mId[i] = mId[w];
            }
        }
        ALog.d(TAG, "union [" + v + ", " + w + "], ids:" + Arrays.toString(mId));
    }

    public boolean isConnected(int v, int w) {
        ALog.d(TAG, "isConnected id[" + v + "]=" + mId[v] + ", id[" + w + "]=" + mId[w]);
        return mId[v] == mId[w];
    }
}
