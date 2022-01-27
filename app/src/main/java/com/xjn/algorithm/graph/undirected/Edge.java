package com.xjn.algorithm.graph.undirected;

import androidx.annotation.NonNull;

public class Edge implements Comparable<Edge> {
    private int mV; // 顶点1
    private int mW; // 顶点2
    private double mWeight; // 权重

    public Edge(int v, int w, double weight) {
        mV = v;
        mW = w;
        mWeight = weight;
    }

    public double getWeight() {
        return mWeight;
    }

    public int getVertex() {
        return mV;
    }

    public int getOtherVertex(int v) {
        if (mV == v) {
            return mW;
        } else if (mW == v) {
            return mV;
        } else {
            throw new RuntimeException("Unsupported vertex:" + v);
        }
    }

    @Override
    public int compareTo(Edge o) {
        double compare = mWeight - o.mWeight;
        if (compare > 0) {
            return 1;
        } else if (compare == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    @NonNull
    @Override
    public String toString() {
        return "Edge[v:" + mV + ", w:" + mW + ", weight:" + mWeight + "]";
    }
}
