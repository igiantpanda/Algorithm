package com.xjn.algorithm.graph.undirected;

import com.xjn.algorithm.graph.GraphData;
import com.xjn.algorithm.graph.undirected.BreadthFirstSearch;
import com.xjn.algorithm.graph.undirected.Graph;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class BreadthFirstSearchTest {
    private static Graph sGraph;

    @BeforeClass
    public static void init() {
        sGraph = new Graph(GraphData.getGraphData());
    }

    @Test
    public void marked() {
        BreadthFirstSearch bfs = new BreadthFirstSearch(sGraph, 4);
        for (int v = 0; v < sGraph.getVertexCount(); v++) {
            if (8 == v) {
                assertFalse(bfs.marked(v));
            } else {
                assertTrue(bfs.marked(v));
            }
        }

        bfs = new BreadthFirstSearch(sGraph, 8);
        for (int v = 0; v < sGraph.getVertexCount(); v++) {
            if (8 == v) {
                assertTrue(bfs.marked(v));
            } else {
                assertFalse(bfs.marked(v));
            }
        }

    }

    @Test
    public void count() {
        BreadthFirstSearch bfs = new BreadthFirstSearch(sGraph, 0);
        assertEquals(10, bfs.count());


        bfs = new BreadthFirstSearch(sGraph, 8);
        assertEquals(1, bfs.count());
    }

}