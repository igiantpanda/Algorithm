package com.xjn.algorithm.graph.directed;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Dijkstra算法可处理加权边非负的加权有向图的单起点最短路径问题。
 * 基本思路：
 * 1.将起点作为待松弛的顶点
 * 2.对待松弛的顶点进行松弛
 * 3.将松弛顶点的所有的下一个顶点及到达顶点所需距离添加到队列
 * 4.从队列中选取到达距离最短的顶点作为待松弛顶点
 * 5.执行步骤2，直到队列为空
 *
 * 问：步骤3中为什么要取到达距离最短的？
 * 答：假设A到B的距离为10，A到D的距离为2，B到C的距离为5，D到C的距离为5，C到E为5.
 *            A-->B---->C-->E
 *             \       ^
 *              \-->D--|
 *     对A进行松弛后，distance[D]为2，distance[B]为10，如若过下一个松弛顶点不选择最小的D，
 *     而是选择B，那么对B松弛后，distance[C]为15，然后再对C进行松弛，则distance[E]为20，
 *     接着在对D进行松弛，这时会将distance[C]从15更新为7，但distance[E]的值却得不到更新，
 *     这就导致从A到E的距离不正确。
 */
public class DijkstraSP implements IDirectedShortestPath {
    private static final String TAG = DijkstraSP.class.getSimpleName();
    private int mStart;
    private double[] mDistanceTo;
    private int[] mEdgeTo; // mEdgeTo[v]表示到达顶点v的最短路径中的上一个顶点
    private Queue<Node> mQueue;
    private boolean[] mMarked;

    private static class Node implements Comparable<Node> {
        private final int mVertex;
        private double mDistance;

        public Node(int v, double distance) {
            mVertex = v;
            mDistance = distance;
        }

        public int getVertex() {
            return mVertex;
        }

        public double getDistance() {
            return mDistance;
        }

        public void setDistance(double distance) {
            this.mDistance = distance;
        }

        @Override
        public int compareTo(Node o) {
            double diff = mDistance - o.mDistance;

            if (diff > 0) {
                return 1;
            } else if (diff < 0) {
                return -1;
            }

            return 0;
        }
    }

    public DijkstraSP(WeightedDirectedGraph graph, int start) {
        int vCnt = graph.getVertexCount();

        mDistanceTo = new double[vCnt];
        for (int i = 0; i < vCnt; i++) {
            mDistanceTo[i] = Double.POSITIVE_INFINITY;
        }
        mDistanceTo[start] = 0;

        mEdgeTo = new int[vCnt];
        for (int i = 0; i < vCnt; i++) {
            mEdgeTo[i] = i;
        }
        mEdgeTo[start] = start;

        mQueue = new PriorityQueue<>(graph.getEdgeCount());
        mMarked = new boolean[vCnt];
        mStart = start;

        sp(graph, start);
    }

    @Override
    public boolean hasPath(int v) {
        return mDistanceTo[v] < Double.POSITIVE_INFINITY;
    }

    @Override
    public List<DirectedEdge> path(int v) {
        return null;
    }

    @Override
    public double distance(int v) {
        return 0;
    }

    private void sp(WeightedDirectedGraph graph, int start) {
        mQueue.add(new Node(start, 0));
        mMarked[start] = true;
        while (!mQueue.isEmpty()) {
            Node node = mQueue.poll();
            relax(graph, node.getVertex());
        }
    }

    private void relax(WeightedDirectedGraph graph, int v) {
        for (DirectedEdge edge : graph.getAdjacency(v)) {
            int w = edge.getTo();
            double distance = mDistanceTo[v] + edge.getWeight();
            if (mDistanceTo[w] > distance) {
                mDistanceTo[w] = distance;
                mEdgeTo[w] = v;
            }

//            mQueue.
        }
    }
}
