package com.xjn.algorithm.graph.directed;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 基于深度优先搜索的排序，传入的图必须是有向无环图。
 * 后逆序排列为有向无环图的拓扑序列。
 */
public class DepthFirstSort {
    private final boolean[] mMarked;
    private final Queue<Integer> mPreOrder = new LinkedList<>(); // 前序排列
    private final Queue<Integer> mPostOrder = new LinkedList<>(); // 后序排列
    private final Stack<Integer> mRevertPostOrder = new Stack<>(); // 后逆序排列

    public DepthFirstSort(DirectedGraph graph) {
        mMarked = new boolean[graph.getVertexCount()];
        for (int v = 0; v < graph.getVertexCount(); v++) {
            if (!mMarked[v]) {
                dfs(graph, v);
            }
        }
    }

    public Queue<Integer> getPreOrder() {
        return mPreOrder;
    }

    public Queue<Integer> getPostOrder() {
        return mPostOrder;
    }

    public Stack<Integer> getRevertPostOrder() {
        return mRevertPostOrder;
    }

    private void dfs(DirectedGraph graph, int v) {
        mMarked[v] = true;
        mPreOrder.add(v);
        for (Integer w : graph.getAdjacency(v)) {
            if (!mMarked[w]) {
                dfs(graph, w);
            }
        }
        mPostOrder.add(v);
        mRevertPostOrder.push(v);
    }
}
