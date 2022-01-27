package com.xjn.algorithm.graph.directed;

import androidx.annotation.NonNull;

import com.xjn.algorithm.graph.undirected.Graph;

/**
 * 有向图
 */
public class DirectedGraph extends Graph {

    public DirectedGraph(int[] in) {
        super(in);
    }

    public DirectedGraph(int vertexCount) {
        super(vertexCount);
    }

    @Override
    public void addEdge(int v, int w) {
        mAdjacencies[v].add(w);
        mEdgeCount++;
    }

    public DirectedGraph reverse() {
        DirectedGraph graph = new DirectedGraph(getVertexCount());

        for (int v = 0; v < getVertexCount(); v++) {
            for (Integer w : getAdjacency(v)) {
                graph.addEdge(w, v);
            }
        }

        return graph;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("DirectedGraph")
                .append("\n  vertex count:").append(getVertexCount())
                .append("\n  edge count:").append(getEdgeCount());
        for (int v = 0; v < mAdjacencies.length; v++) {
            sb.append("\n  ").append(v).append(":").append(mAdjacencies[v]);
        }

        return sb.toString();
    }
}
