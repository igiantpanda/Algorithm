package com.xjn.algorithm.graph.undirected;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 查找从起点到指定顶点的路径
 */
public class BreadthFirstPaths {
    private static final String TAG = BreadthFirstPaths.class.getSimpleName();
    private final boolean[] mMarked;
    private final int mStart;
    private final int[] mLastVertex; // mLastVertex[v]是从起点到顶点v的路径中最后一个顶点，即路径中v的上一个顶点

    public BreadthFirstPaths(Graph graph, int start) {
        mStart = start;
        mMarked = new boolean[graph.getVertexCount()];
        mLastVertex = new int[graph.getVertexCount()];
        for (int v = 0; v < mLastVertex.length; v++) {
            mLastVertex[v] = v;
        }
        bfs(graph, start);
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

    private void bfs(Graph graph, int start) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (mMarked[v]) {
                continue;
            }
            mMarked[v] = true;
            for (Integer w : graph.getAdjacency(v)) {
                if (mMarked[w]) {
                    continue;
                }
                mLastVertex[w] = v;
                queue.add(w);
            }
        }


    }
}
