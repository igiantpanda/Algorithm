package com.xjn.algorithm.graph.undirected;

import com.xjn.algorithm.graph.IGraph;

import java.util.ArrayList;
import java.util.List;

/**
 * 无向图
 */
public class Graph implements IGraph {
    private static final String TAG = Graph.class.getSimpleName();
    private final int mVertexCount;
    protected int mEdgeCount;
    protected List<Integer>[] mAdjacencies;

    public Graph(int vertexCount) {
        mVertexCount = vertexCount;
        mAdjacencies = new ArrayList[mVertexCount];
        for (int i = 0; i < mVertexCount; i++) {
            mAdjacencies[i] = new ArrayList<>();
        }
    }

    /**
     *
     * @param in VertexCount EdgeCount Edge1(V1 W1) Edge2(V2 W2) ...
     */
    public Graph(int[] in) {
        this(in[0]);

        int j = 1;
        int edgeCount = in[j++];
//        ALog.d(TAG, "Graph edge count:" + edgeCount + ", data size:" + in.length);
        for (int i = 0; i < edgeCount; i++) {
            addEdge(in[j++], in[j++]);
        }
    }

//    @Override
    public void addEdge(int v, int w) {
        mAdjacencies[v].add(w);
        mAdjacencies[w].add(v);
        mEdgeCount++;
    }

    @Override
    public int getVertexCount() {
        return mVertexCount;
    }

    @Override
    public int getEdgeCount() {
        return mEdgeCount;
    }

    @Override
    public List<Integer> getAdjacency(int v) {
        return mAdjacencies[v];
    }

}
