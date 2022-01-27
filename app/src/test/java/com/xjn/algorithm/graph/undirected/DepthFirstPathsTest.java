package com.xjn.algorithm.graph.undirected;

import com.xjn.algorithm.graph.GraphData;
import com.xjn.algorithm.utils.ALog;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstPathsTest {
    private static final String TAG = DepthFirstPathsTest.class.getSimpleName();
    private static Graph sGraph;

    @BeforeClass
    public static void init() {
        sGraph = new Graph(GraphData.getGraphData());
    }

    @Test
    public void hasPath() {
        DepthFirstPaths dfp = new DepthFirstPaths(sGraph, 3);
        for (int v = 0; v < sGraph.getVertexCount(); v++) {
            if (8 == v) {
                assertFalse(dfp.hasPath(v));
            } else {
                assertTrue(dfp.hasPath(v));
            }
        }

        dfp = new DepthFirstPaths(sGraph, 8);
        for (int v = 0; v < sGraph.getVertexCount(); v++) {
            if (8 == v) {
                assertTrue(dfp.hasPath(v));
            } else {
                assertFalse(dfp.hasPath(v));
            }
        }
    }

    @Test
    public void path() {
        DepthFirstPaths dfp = new DepthFirstPaths(sGraph, 3);
        ALog.d(TAG, "path 3->10:" + dfp.path(10));
        ALog.d(TAG, "path 3->4:" + dfp.path(4));
        ALog.d(TAG, "path 3->3:" + dfp.path(3));
        ALog.d(TAG, "path 3->8:" + dfp.path(8));
    }
}