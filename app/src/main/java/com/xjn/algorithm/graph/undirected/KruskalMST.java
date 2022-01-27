package com.xjn.algorithm.graph.undirected;

import com.xjn.algorithm.utils.ALog;
import com.xjn.algorithm.utils.QuickFindUnionFind;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Kruskal算法计算最小生成树。
 * 与Prim算法不同，Kruskal算法是按照边的权重大小从小到大遍历边，直到找到所有顶点。
 */
public class KruskalMST {
    private static final String TAG = KruskalMST.class.getSimpleName();

    private final Queue<Edge> mEdgeQueue = new PriorityQueue<>();
    private final List<Edge> mMst = new ArrayList<>();
    private QuickFindUnionFind mUnionFind;
    private double mWeight;

    public KruskalMST(WeightedGraph graph) {
        // 先将所有的边添加到优先级队列中
        for (Edge edge : graph.getEdges()) {
            mEdgeQueue.add(edge);
        }

        // 初始化Union Find，此时所有的点彼此间都不连通
        mUnionFind = new QuickFindUnionFind(graph.getVertexCount());

        // 按权重从小到大遍历各边，如果边的两个顶点未连通，则将边添加到mst中
        int mstSize = graph.getVertexCount() - 1;
        while (!mEdgeQueue.isEmpty() && mMst.size() < mstSize) {
            Edge edge = mEdgeQueue.poll();
            int v = edge.getVertex();
            int w = edge.getOtherVertex(v);
            if (!mUnionFind.isConnected(v, w)) {
                mUnionFind.union(v, w);
                mMst.add(edge);
                mWeight += edge.getWeight();
            }
        }

        if (mMst.size() != graph.getVertexCount() - 1) {
            ALog.e(TAG, "KruskalMST no mst, mst size:" + mMst.size() + ", excepted size:" + mstSize);
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

}
