package com.xjn.algorithm.graph.undirected;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * 无向加权图
 *
 */
public class WeightedGraph {
    private int mVertexCount;
    private int mEdgeCount;
    private List<Edge> mEdges = new ArrayList<>();
    private List<Edge>[] mAdjacencies;

    public WeightedGraph(int[] in, double[] weights) {
        int j = 0;
        mVertexCount = in[j++];
        mAdjacencies = new ArrayList[mVertexCount];
        for (int i = 0; i < mVertexCount; i++) {
            mAdjacencies[i] = new ArrayList<>();
        }

        int edgeCount = in[j++];
        for (int i = 0; i < edgeCount; i++) {
            addEdge(new Edge(in[j++], in[j++], weights[i]));
        }
    }

    /**
     * 假设添加的边在当前图中不存在
     */
    public void addEdge(Edge edge) {
        mEdgeCount++;
        mEdges.add(edge);
        mAdjacencies[edge.getVertex()].add(edge);
        mAdjacencies[edge.getOtherVertex(edge.getVertex())].add(edge);
    }

    public int getVertexCount() {
        return mVertexCount;
    }

    public int getEdgeCount() {
        return mEdgeCount;
    }

    public List<Edge> getAdjacency(int v) {
        return mAdjacencies[v];
    }

    public List<Edge> getEdges() {
        return mEdges;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("WeightedGraph v:").append(mVertexCount).append(", e:").append(mEdges);
        for (Edge edge : mEdges) {
            int v = edge.getVertex();
            sb.append("\n  ").append(v).append(" ").append(edge.getOtherVertex(v)).append(":").append(edge.getWeight());
        }

        return sb.toString();
    }
}
