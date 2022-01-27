package com.xjn.algorithm.graph;

import java.util.Arrays;

public class GraphData {
    /**
     * 参考：undirected_graph.png
     */
    private static final int[] GRAPH_DATA = new int[]{  11, 12,
                                                        0, 1,
                                                        1, 2,
                                                        1, 3,
                                                        2, 6,
                                                        3, 4,
                                                        3, 6,
                                                        4, 5,
                                                        5, 7,
                                                        6, 7,
                                                        6, 9,
                                                        7, 9,
                                                        9, 10};

    /**
     * 参考：directed_cycle_graph.png
     */
    private static final int[] DIRECTED_CYCLE_GRAPH_DATA = new int[]{  13, 16,
                                                        0, 1,
                                                        1, 2,
                                                        1, 3,
                                                        2, 6,
                                                        3, 6,
                                                        4, 3,
                                                        5, 4,
                                                        6, 7,
                                                        6, 9,
                                                        7, 5,
                                                        9, 7,
                                                        9, 10,
                                                        9, 12,
                                                        10, 7,
                                                        11, 10,
                                                        12, 11};

    /**
     * 参考：directed_acyclic_graph.png
     */
    private static final int[] DIRECTED_ACYCLIC_GRAPH_DATA = new int[]{  13, 15,
                                                        0, 1,
                                                        1, 2,
                                                        1, 3,
                                                        2, 6,
                                                        3, 6,
                                                        4, 3,
                                                        5, 4,
                                                        5, 7,
                                                        6, 7,
                                                        6, 9,
                                                        9, 10,
                                                        9, 12,
                                                        10, 7,
                                                        11, 10,
                                                        12, 11};

    /**
     * 参考：weighted_undirected_graph.png
     */
    private static final int[] WEIGHTED_GRAPH_DATA = new int[]{  11, 13,
                                                                            0, 1,
                                                                            1, 2,
                                                                            1, 3,
                                                                            2, 6,
                                                                            3, 4,
                                                                            3, 6,
                                                                            4, 5,
                                                                            5, 7,
                                                                            6, 7,
                                                                            6, 8,
                                                                            6, 9,
                                                                            7, 9,
                                                                            9, 10};
    private static final double[] WEIGHTED_GRAPH_WEIGHT_DATA = new double[]{
            0.12, // 0, 1,
            0.11, // 1, 2,
            0.37, // 1, 3,
            1.23, // 2, 6,
            0.8, // 3, 4,
            0.39, // 3, 6,
            0.01, // 4, 5,
            0.03, // 5, 7,
            0.28, // 6, 7,
            0.22, // 6, 8,
            0.36, // 6, 9,
            0.09, // 7, 9,
            0.77  // 9, 10
            };

    /**
     * 参考：weighted_directed_cycle_graph.png
     */
    private static final int[] WEIGHTED_DIRECTED_CYCLE_GRAPH_DATA = new int[]{  13, 16,
            0, 1,
            1, 2,
            1, 3,
            2, 6,
            3, 6,
            4, 3,
            5, 4,
            6, 7,
            6, 9,
            7, 5,
            9, 7,
            9, 10,
            9, 12,
            10, 7,
            11, 10,
            12, 11};
    private static final double[] WEIGHTED_DIRECTED_CYCLE_GRAPH_WEIGHT_DATA = new double[]{
            0.12, // 0, 1,
            0.11, // 1, 2,
            0.37, // 1, 3,
            1.23, // 2, 6,
            0.39, // 3, 6,
            0.8,  // 4, 3,
            0.01, // 5, 4
            2.8,  // 6, 7,
            0.36, // 6, 9,
            0.03, // 7, 5,
            0.09, // 9, 7
            0.77, // 9, 10
            0.95, // 9, 12,
            0.16, // 10, 7,
            0.73, // 11, 10,
            0.36, // 12, 11
    };

    public static int[] getGraphData() {
        return Arrays.copyOf(GRAPH_DATA, GRAPH_DATA.length);
    }

    public static int[] getDirectedCycleGraphData() {
        return Arrays.copyOf(DIRECTED_CYCLE_GRAPH_DATA, DIRECTED_CYCLE_GRAPH_DATA.length);
    }

    public static int[] getDirectedAcyclicGraphData() {
        return Arrays.copyOf(DIRECTED_ACYCLIC_GRAPH_DATA, DIRECTED_ACYCLIC_GRAPH_DATA.length);
    }

    public static int[] getWeightedGraphData() {
        return Arrays.copyOf(WEIGHTED_GRAPH_DATA, WEIGHTED_GRAPH_DATA.length);
    }

    public static double[] getWeightedGraphWeightData() {
        return Arrays.copyOf(WEIGHTED_GRAPH_WEIGHT_DATA, WEIGHTED_GRAPH_WEIGHT_DATA.length);
    }

    public static int[] getWeightedDirectedCycleGraphData() {
        return Arrays.copyOf(WEIGHTED_DIRECTED_CYCLE_GRAPH_DATA, WEIGHTED_DIRECTED_CYCLE_GRAPH_DATA.length);
    }

    public static double[] getWeightedDirectedCycleGraphWeightData() {
        return Arrays.copyOf(WEIGHTED_DIRECTED_CYCLE_GRAPH_WEIGHT_DATA, WEIGHTED_DIRECTED_CYCLE_GRAPH_WEIGHT_DATA.length);
    }
}
