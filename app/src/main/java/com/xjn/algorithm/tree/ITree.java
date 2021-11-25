package com.xjn.algorithm.tree;

import androidx.annotation.NonNull;

public interface ITree {
    class Node {
        public Node left;
        public Node right;
        public Comparable key;
        public Object value;
        public int count = 1;

        public Node(Comparable key, Object value) {
            this.key = key;
            this.value = value;
        }

        @NonNull
        @Override
        public String toString() {
            return "[<" + key + "," + value + ">" + "left:" + left + ", right:" + right + "]";
        }
    }

    void put(Comparable key, Object value);
    Object get(Comparable key);
    Comparable getMin();
    Comparable getMax();
    void delete(Comparable key);
    void deleteMin();
    void deleteMax();
    int rank(Comparable key);
    Comparable select(int rank);
    Comparable floor(Comparable key);
    Comparable ceiling(Comparable key);
    Comparable[] sortedKeys();
    int size();
}
