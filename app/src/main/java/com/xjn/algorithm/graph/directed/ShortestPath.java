package com.xjn.algorithm.graph.directed;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 加权有向图的最短路径，可处理有环的情况。
 */
public class ShortestPath implements IDirectedShortestPath {
    private final int mStart;
    private final double[] mDistanceTo;
    private final DirectedEdge[] mEdgeTo;
    private final Set<DirectedEdge> mMarked = new HashSet<>();

    public ShortestPath(WeightedDirectedGraph graph, int start) {
        int vertexCount = graph.getVertexCount();

        mStart = start;
        mDistanceTo = new double[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            mDistanceTo[i] = Double.POSITIVE_INFINITY;
        }
        mDistanceTo[start] = 0;

        mEdgeTo = new DirectedEdge[vertexCount];

        sp(graph, start);
    }

    @Override
    public boolean hasPath(int v) {
        return mDistanceTo[v] < Double.POSITIVE_INFINITY;
    }

    @Override
    public List<DirectedEdge> path(int v) {
        if (!hasPath(v)) {
            return null;
        }

        if (mStart == v) {
            return new ArrayList<>();
        }

        List<DirectedEdge> revertPath = new ArrayList<>();
        DirectedEdge last = mEdgeTo[v];
        while (mStart != last.getFrom()) {
            revertPath.add(last);
            last = mEdgeTo[last.getFrom()];
        }
        revertPath.add(last);

        List<DirectedEdge> path = new ArrayList<>();
        for (int i = revertPath.size() - 1; i >=0; i--) {
            path.add(revertPath.get(i));
        }

        return path;
    }

    @Override
    public double distance(int v) {
        return mDistanceTo[v];
    }

    private void sp(WeightedDirectedGraph graph, int v) {
        for (DirectedEdge edge : graph.getAdjacency(v)) {
            if (mMarked.contains(edge)) { // TODO：应该要重写一下DirectedEdge的hashcode和equals方法
                // 这条边已处理过，就不再处理了，避免有环时无限循环
                continue;
            }
            mMarked.add(edge);
            relax(edge);
            sp(graph, edge.getTo());
        }
    }

    private void relax(DirectedEdge edge) {
        int from = edge.getFrom();
        int to = edge.getTo();
        double distance = mDistanceTo[from] + edge.getWeight();

        if (distance < mDistanceTo[to]) {
            mDistanceTo[to] = distance;
            mEdgeTo[to] = edge;
        }
    }
}
