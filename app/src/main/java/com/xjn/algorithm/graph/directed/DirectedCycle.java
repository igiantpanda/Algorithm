package com.xjn.algorithm.graph.directed;

import java.util.ArrayList;
import java.util.List;

/**
 * 有向环。
 * 利用深度优先搜索可以很容易判断一个有向图是否有环，以及得到环的路径(找到一个就不再找了)。
 * 1.遍历所有顶点，每个顶点下依次执行步骤2
 * 2.遍历当前顶点的下个顶点
 *   已存在环：退出
 *   未被搜索：在下个顶点执行步骤1
 *   已被搜索：说明出现了环，则构造环
 */
public class DirectedCycle {
    private boolean[] mMarked;
    private List<Integer> mCycle;
    private boolean[] mStack;
    private int[] mLastVertex; // mLastVertex[v]是从起点到顶点v的路径中最后一个顶点，即路径中v的上一个顶点

    public DirectedCycle(DirectedGraph graph) {
        mMarked = new boolean[graph.getVertexCount()];
        mStack = new boolean[graph.getVertexCount()];
        mLastVertex = new int[graph.getVertexCount()];
        for (int v = 0; v < graph.getVertexCount(); v++) {
            if (hasCycle()) {
                break;
            }
            dfs(graph, v);
        }
    }

    /**
     * 是否有环
     */
    public boolean hasCycle() {
        return null != mCycle;
    }

    /**
     * 返回有向图中的一个环，若无环则返回null
     */
    public List<Integer> getCycle() {
        return mCycle;
    }

    private void dfs(DirectedGraph graph, int v) {
        mStack[v] = true;
        mMarked[v] = true;
        for (Integer w : graph.getAdjacency(v)) {
            if (hasCycle()) {
                break;
            } else if (!mMarked[w]) {
                mLastVertex[w] = v;
                dfs(graph, w);
            } else if (mStack[w]) {
                List<Integer> list = new ArrayList<>();
                int last = v;

                // 获取反向的环
                list.add(v);
                while (w != mLastVertex[last]) {
                    last = mLastVertex[last];
                    list.add(last);
                }
                list.add(w);

                // 转换为正向的环
                mCycle = new ArrayList<>();
                for (int i = list.size() - 1; i >= 0; i--) {
                    mCycle.add(list.get(i));
                }
            }
        }
        mStack[v] = false;
    }
}
