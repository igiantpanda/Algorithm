package com.xjn.algorithm.graph.undirected;

import com.xjn.algorithm.utils.ALog;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Prim算法计算最小生成树(Minimum Spanning Tree)。
 * 本例为Prim算法的延迟实现，即不实时删除失效的边，而是等到处理它时才进行判断。
 * 还有一种及时实现，会将失效的边从队列中移除，这种方式代码相对复杂一些，这里不做实现。
 */
public class PrimMST {
    private static final String TAG = PrimMST.class.getSimpleName();

    private final Queue<Edge> mEdgeQueue = new PriorityQueue<>();
    private final List<Edge> mMst = new ArrayList<>();
    private final boolean[] mMarked;
    private double mWeight;

    public PrimMST(WeightedGraph graph) {
        mMarked = new boolean[graph.getVertexCount()];

        int mstSize = graph.getVertexCount() - 1;
        add(graph, 0);
        while (!mEdgeQueue.isEmpty() && mMst.size() < mstSize) {
            Edge edge = mEdgeQueue.poll();
            int v = edge.getVertex();
            int w = edge.getOtherVertex(v);

            // 失效的边
            if (mMarked[v] && mMarked[w]) {
                ALog.d(TAG, "ignore edge:" + edge);
                continue;
            }

            // 添加边，v和w必然是一个已标记、一个未标记
            ALog.d(TAG, "add edge:" + edge + ", v:" + mMarked[v] + ", w:" + mMarked[w]);
            mMst.add(edge);
            mWeight += edge.getWeight();
            if (!mMarked[v]) {
                add(graph, v);
            } else { // !mMarked[w]
                add(graph, w);
            }
            ALog.d(TAG, "queue:" + mEdgeQueue);
        }

        if (mMst.size() != mstSize) {
            ALog.e(TAG, "PrimMST no mst, mst size:" + mMst.size() + ", excepted size:" + mstSize);
            throw new RuntimeException("No MST");
        }
    }

    /**
     * 获取最小生成树所有的边
     */
    public List<Edge> getEdges() {
        return mMst;
    }

    /**
     * 获取最小生成树的总权重
     */
    public double getWeight() {
        return mWeight;
    }

    private void add(WeightedGraph graph, int v) {
        ALog.d(TAG, "add:" + v);
        mMarked[v] = true;
        for (Edge edge : graph.getAdjacency(v)) {
            if (!mMarked[edge.getOtherVertex(v)]) {
                mEdgeQueue.add(edge);
            }
        }
    }
}
