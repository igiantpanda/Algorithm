package com.xjn.algorithm.graph.undirected;

import com.xjn.algorithm.graph.GraphData;
import com.xjn.algorithm.utils.ALog;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimMSTTest {
    private static final String TAG = PrimMSTTest.class.getSimpleName();

    @Test
    public void test() {
        WeightedGraph graph = new WeightedGraph(GraphData.getWeightedGraphData(), GraphData.getWeightedGraphWeightData());
        ALog.d(TAG, "test grap:" + graph);
        PrimMST mst = new PrimMST(graph);
        ALog.d(TAG, "test, mst:" + mst.getEdges());
        ALog.d(TAG, "test, weight:" + mst.getWeight());
    }
}