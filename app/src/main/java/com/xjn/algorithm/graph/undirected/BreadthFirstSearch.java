package com.xjn.algorithm.graph.undirected;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 通过广度优先搜索找出与起点连通的所有顶点（包含自身）。
 * 与深度优先搜索通过递归进行查找不同，广度优先搜索是通过遍历待搜索队列完成的。
 * 基本思路：每处理一个顶点，我们就将其所有未处理过的下一顶点添加到队列中。
 */
public class BreadthFirstSearch {
    private int mCount;
    private final boolean[] mMarked;

    public BreadthFirstSearch(Graph graph, int start) {
        mMarked = new boolean[graph.getVertexCount()];
        bfs(graph, start);
    }

    /**
     * 判断顶点v是否与起点连通
     */
    public boolean marked(int v) {
        return mMarked[v];
    }

    /**
     * 获取与起点连通的所有顶点
     */
    public int count() {
        return mCount;
    }

    private void bfs(Graph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()){
            int v = queue.poll();
            if (mMarked[v]) {
                continue; // 第n层的不同顶点可能同时与后续的相同顶点连通
            }
            mCount++;
            mMarked[v] = true;
            for (Integer w : graph.getAdjacency(v)) {
                if (!mMarked[w]) {
                    queue.add(w);
                }
            }
        }
    }
}
