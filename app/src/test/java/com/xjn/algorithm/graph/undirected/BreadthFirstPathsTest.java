package com.xjn.algorithm.graph.undirected;

import com.xjn.algorithm.graph.GraphData;
import com.xjn.algorithm.utils.ALog;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BreadthFirstPathsTest {
    private static final String TAG = BreadthFirstPathsTest.class.getSimpleName();
    private static Graph sGraph;

    @BeforeClass
    public static void init() {
        sGraph = new Graph(GraphData.getGraphData());
    }

    @Test
    public void hasPath() {
        BreadthFirstPaths bfp = new BreadthFirstPaths(sGraph, 3);
        for (int v = 0; v < sGraph.getVertexCount(); v++) {
            if (8 == v) {
                assertFalse(bfp.hasPath(v));
            } else {
                assertTrue(bfp.hasPath(v));
            }
        }

        bfp = new BreadthFirstPaths(sGraph, 8);
        for (int v = 0; v < sGraph.getVertexCount(); v++) {
            if (8 == v) {
                assertTrue(bfp.hasPath(v));
            } else {
                assertFalse(bfp.hasPath(v));
            }
        }
    }

    @Test
    public void path() {
        BreadthFirstPaths bfp = new BreadthFirstPaths(sGraph, 3);
        ALog.d(TAG, "path 3->10:" + bfp.path(10));
        ALog.d(TAG, "path 3->4:" + bfp.path(4));
        ALog.d(TAG, "path 3->3:" + bfp.path(3));
        ALog.d(TAG, "path 3->8:" + bfp.path(8));
    }
}