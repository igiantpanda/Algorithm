package com.xjn.algorithm.graph.undirected;

import com.xjn.algorithm.graph.GraphData;
import com.xjn.algorithm.utils.ALog;

import org.junit.Test;

import static org.junit.Assert.*;

public class KruskalMSTTest {
    private static final String TAG = KruskalMSTTest.class.getSimpleName();

    @Test
    public void test() {
        WeightedGraph graph = new WeightedGraph(GraphData.getWeightedGraphData(), GraphData.getWeightedGraphWeightData());
        ALog.d(TAG, "test grap:" + graph);
        KruskalMST mst = new KruskalMST(graph);
        ALog.d(TAG, "test, mst:" + mst.getEdges());
        ALog.d(TAG, "test, weight:" + mst.getWeight());
    }
}