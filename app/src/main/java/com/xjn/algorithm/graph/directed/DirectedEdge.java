package com.xjn.algorithm.graph.directed;

import androidx.annotation.NonNull;

import java.util.MissingFormatArgumentException;

public class DirectedEdge implements Comparable<DirectedEdge> {
    private static final String TAG = DirectedEdge.class.getSimpleName();
    private int mFrom;
    private int mTo;
    private double mWeight;

    public DirectedEdge(int from, int to, double weight) {
        mFrom = from;
        mTo = to;
        mWeight = weight;
    }

    public int getFrom() {
        return mFrom;
    }

    public int getTo() {
        return mTo;
    }

    public double getWeight() {
        return mWeight;
    }

    @Override
    public int compareTo(DirectedEdge o) {
        return 0;
    }

    @NonNull
    @Override
    public String toString() {
        return TAG + "[" + mFrom + "," + mTo + ":" + mWeight + "]";
    }
}
