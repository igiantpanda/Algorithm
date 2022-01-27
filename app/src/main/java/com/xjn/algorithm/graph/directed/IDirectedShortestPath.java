package com.xjn.algorithm.graph.directed;

import java.util.List;

public interface IDirectedShortestPath {

    /**
     * 从起点到v是否有路径
     */
    boolean hasPath(int v);

    /**
     * 从起点到v的路径。
     * 如果不可达，则返回null，
     * 如果是到起点，则返回空List。
     */
    List<DirectedEdge> path(int v);

    /**
     * 从起点到v的距离（路径中所有边权重之和）
     */
    double distance(int v);

}
