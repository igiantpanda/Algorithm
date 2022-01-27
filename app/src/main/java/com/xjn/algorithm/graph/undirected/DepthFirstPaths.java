package com.xjn.algorithm.graph.undirected;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 查找从起点到指定顶点的路径
 */
public class DepthFirstPaths {
    private static final String TAG = DepthFirstPaths.class.getSimpleName();
    private final boolean[] mMarked;
    private final int mStart;
    private final int[] mLastVertex; // mLastVertex[v]是从起点到顶点v的路径中最后一个顶点，即路径中v的上一个顶点

    public DepthFirstPaths(Graph graph, int start) {
        mStart = start;
        mMarked = new boolean[graph.getVertexCount()];
        mLastVertex = new int[graph.getVertexCount()];
        for (int v = 0; v < mLastVertex.length; v++) {
            mLastVertex[v] = v;
        }
        dfs(graph, start);
    }

    /**
     * 是否存在从起点到v的路径
     */
    public boolean hasPath(int v) {
        return mMarked[v];
    }

    /**
     * 返回从起点到v的路径
     */
    public List<Integer> path(int v) {
        List<Integer> path = new ArrayList<>();
        if (mStart == v) {
            path.add(v);
            return path;
        }

        if (!hasPath(v)) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();
        int last = mLastVertex[v];

        stack.push(v);
        while (mStart != last) {
            stack.push(last);
            last = mLastVertex[last];
        }
        stack.push(mStart);

        while (!stack.empty()) {
            path.add(stack.pop());
        }

        return path;
    }

    private void dfs(Graph graph, int v) {
        mMarked[v] = true;
        for (Integer w : graph.getAdjacency(v)) {
            if (!mMarked[w]) {
                mLastVertex[w] = v;
                dfs(graph, w);
            }
        }
    }
}
