package com.xjn.algorithm.graph.directed;

import com.xjn.algorithm.graph.GraphData;
import com.xjn.algorithm.utils.ALog;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathTest {
    private static final String TAG = ShortestPathTest.class.getSimpleName();

    @Test
    public void test() {
        WeightedDirectedGraph graph = new WeightedDirectedGraph(GraphData.getWeightedDirectedCycleGraphData(), GraphData.getWeightedDirectedCycleGraphWeightData());
        ShortestPath sp = new ShortestPath(graph, 5);

        assertTrue(sp.hasPath(5));
        assertTrue(sp.hasPath(7));
        assertTrue(sp.hasPath(9));
        assertTrue(sp.hasPath(11));
        assertFalse(sp.hasPath(1));
        assertFalse(sp.hasPath(2));
        assertFalse(sp.hasPath(8));

        ALog.d(TAG, "test sp[5-5] distance:" + sp.distance(5) + ", path:" + sp.path(5));
        ALog.d(TAG, "test sp[5-7] distance:" + sp.distance(7) + ", path:" + sp.path(7));
        ALog.d(TAG, "test sp[5-9] distance:" + sp.distance(9) + ", path:" + sp.path(9));
        ALog.d(TAG, "test sp[5-11] distance:" + sp.distance(11) + ", path:" + sp.path(11));
    }
}