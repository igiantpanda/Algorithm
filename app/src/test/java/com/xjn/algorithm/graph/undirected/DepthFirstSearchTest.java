package com.xjn.algorithm.graph.undirected;

import com.xjn.algorithm.graph.GraphData;
import com.xjn.algorithm.graph.undirected.DepthFirstSearch;
import com.xjn.algorithm.graph.undirected.Graph;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepthFirstSearchTest {
    private static Graph sGraph;

    @BeforeClass
    public static void init() {
        sGraph = new Graph(GraphData.getGraphData());
    }

    @Test
    public void marked() {
        DepthFirstSearch dfs = new DepthFirstSearch(sGraph, 4);
        for (int v = 0; v < sGraph.getVertexCount(); v++) {
            if (8 == v) {
                assertFalse(dfs.marked(v));
            } else {
                assertTrue(dfs.marked(v));
            }
        }

        dfs = new DepthFirstSearch(sGraph, 8);
        for (int v = 0; v < sGraph.getVertexCount(); v++) {
            if (8 == v) {
                assertTrue(dfs.marked(v));
            } else {
                assertFalse(dfs.marked(v));
            }
        }

    }

    @Test
    public void count() {
        DepthFirstSearch dfs = new DepthFirstSearch(sGraph, 0);
        assertEquals(10, dfs.count());


        dfs = new DepthFirstSearch(sGraph, 8);
        assertEquals(1, dfs.count());
    }


}