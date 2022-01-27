package com.xjn.algorithm.graph.directed;

import java.util.ArrayList;
import java.util.List;

public class WeightedDirectedGraph {
    private static final String TAG = WeightedDirectedGraph.class.getSimpleName();
    private int mVertexCount;
    private int mEdgeCount;
    private List<DirectedEdge>[] mAdjacencies;
    private List<DirectedEdge> mEdges = new ArrayList<>();

    public WeightedDirectedGraph(int[] in, double[] weights) {
        int j = 0;
        mVertexCount = in[j++];
        mAdjacencies = new ArrayList[mVertexCount];
        for (int i = 0; i < mVertexCount; i++) {
            mAdjacencies[i] = new ArrayList<>();
        }

        int edgeCount = in[j++];
        for (int i = 0; i < edgeCount; i++) {
            addEdge(new DirectedEdge(in[j++], in[j++], weights[i]));
        }
    }

    public void addEdge(DirectedEdge edge) {
        mEdgeCount++;
        mAdjacencies[edge.getFrom()].add(edge);
        mEdges.add(edge);
    }

    public int getVertexCount() {
        return mVertexCount;
    }

    public int getEdgeCount() {
        return mEdgeCount;
    }

    public List<DirectedEdge> getAdjacency(int v) {
        return mAdjacencies[v];
    }

    /**
     * 获取所有的边
     */
    public List<DirectedEdge> getEdges() {
        return mEdges;
    }
}
