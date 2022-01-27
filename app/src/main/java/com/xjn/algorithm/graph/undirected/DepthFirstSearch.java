package com.xjn.algorithm.graph.undirected;

/**
 * 通过深度优先搜索找出与起点连通的所有顶点（包含自身）。
 * 深度优先搜索，通俗的讲，就是沿着一条路一直往下走，遇到没有路或下一个顶点之前已经走过时，再原路回退一步，寻找下一个未走过的顶点，
 * 如果没有，则继续回退，直到找到未走过的顶点，然后继续往下走。
 */
public class DepthFirstSearch {
    private int mCount;
    private final boolean[] mMarked;

    public DepthFirstSearch(Graph graph, int start) {
        mMarked = new boolean[graph.getVertexCount()];
        dfs(graph, start);
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

    private void dfs(Graph graph, int v) {
        mCount++;
        mMarked[v] = true;
        for (Integer w : graph.getAdjacency(v)) {
            if (!mMarked[w]) {
                dfs(graph, w);
            }
        }
    }
}
