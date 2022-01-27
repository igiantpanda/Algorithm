package com.xjn.algorithm.graph.directed;

import com.xjn.algorithm.graph.GraphData;
import com.xjn.algorithm.utils.ALog;

import org.junit.Test;

import static org.junit.Assert.*;

public class DirectedCycleTest {
    private static final String TAG = DirectedCycleTest.class.getSimpleName();
    @Test
    public void cycle() {
        DirectedGraph graph = new DirectedGraph(GraphData.getDirectedCycleGraphData());
        DirectedCycle cycle = new DirectedCycle(graph);
        assertTrue(cycle.hasCycle());
        assertNotNull(cycle.getCycle());
        ALog.d(TAG, "cycle:" + cycle.getCycle());
    }

    @Test
    public void noCycle() {
        DirectedGraph graph = new DirectedGraph(GraphData.getDirectedAcyclicGraphData());
        DirectedCycle cycle = new DirectedCycle(graph);
        assertFalse(cycle.hasCycle());
        assertNull(cycle.getCycle());
    }
}