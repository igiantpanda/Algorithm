package com.xjn.algorithm.graph.directed;

import com.xjn.algorithm.graph.GraphData;
import com.xjn.algorithm.utils.ALog;

import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstSortTest {
    private static final String TAG = DepthFirstSortTest.class.getSimpleName();

    @Test
    public void test() {
        DirectedGraph graph = new DirectedGraph(GraphData.getDirectedAcyclicGraphData());
        DepthFirstSort sort = new DepthFirstSort(graph);
        ALog.d(TAG, "test pre:" + sort.getPreOrder());
        ALog.d(TAG, "test post:" + sort.getPostOrder());
        ALog.d(TAG, "test revert post:" + sort.getRevertPostOrder());
        assertNotNull(sort.getPreOrder());
        assertNotNull(sort.getPostOrder());
        assertNotNull(sort.getRevertPostOrder());
    }
}