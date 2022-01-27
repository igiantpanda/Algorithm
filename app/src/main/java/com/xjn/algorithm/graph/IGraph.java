package com.xjn.algorithm.graph;

import java.util.ArrayList;
import java.util.List;

public interface IGraph {
    /**
     * 添加一条边
     */
//    void addEdge(int v, int w);

    /**
     * 获取顶点的数量
     */
    int getVertexCount();

    /**
     * 获取边的数量
     */
    int getEdgeCount();

    /**
     * 获取此顶点所有的边。
     * 如果是有向图，则是获取以v为起点的所有的边。
     */
    List<Integer> getAdjacency(int v);
}
