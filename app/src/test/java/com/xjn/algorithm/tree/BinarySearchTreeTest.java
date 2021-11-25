package com.xjn.algorithm.tree;

import com.xjn.algorithm.sort.BaseSort;
import com.xjn.algorithm.sort.QuickSort;
import com.xjn.algorithm.utils.ALog;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.SplittableRandom;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private static final String TAG = BinarySearchTreeTest.class.getSimpleName();
    private static Map<Integer, Integer> sKeyValues = new HashMap<>();

    @BeforeClass
    public static void init() {
        for (int i = 1; i < 30; i++) {
            sKeyValues.put(i * 10, i * 10);
        }
        //        D/BinarySearchTreeTest: put:{0=0, 160=160, 130=130, 100=100, 70=70, 40=40, 10=10, 170=170, 140=140, 110=110, 80=80, 50=50, 20=20, 180=180, 150=150, 120=120, 90=90, 60=60, 30=30, 190=190}
        ALog.d(TAG, "init:" + sKeyValues);
    }

    @Test
    public void put() {
        BinarySearchTree tree = new BinarySearchTree();
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            tree.put(entry.getKey(), entry.getValue());
//            ALog.d(TAG, "put:" + tree);
            assertTrue(BaseSort.isSorted(tree.sortedKeys()));
        }
    }

    @Test
    public void get() {
        BinarySearchTree tree = new BinarySearchTree();
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            tree.put(entry.getKey(), entry.getValue());
        }
        ALog.d(TAG, "get:" + tree);
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            assertEquals(entry.getValue(), tree.get(entry.getKey()));
        }
    }

    @Test
    public void getMin() {
        BinarySearchTree tree = new BinarySearchTree();
        Integer min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            if (entry.getKey() < min) {
                min = entry.getKey();
            }
            tree.put(entry.getKey(), entry.getValue());
//            ALog.d(TAG, "getMin, min:" + min);
            assertEquals(min, tree.getMin());
        }
    }

    @Test
    public void getMax() {
        BinarySearchTree tree = new BinarySearchTree();
        Integer max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            if (entry.getKey() > max) {
                max = entry.getKey();
            }
            tree.put(entry.getKey(), entry.getValue());
//            ALog.d(TAG, "getMax, max:" + max);
            assertEquals(max, tree.getMax());
        }
    }

    @Test
    public void delete() {
        BinarySearchTree tree = new BinarySearchTree();
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            tree.put(entry.getKey(), entry.getValue());
        }
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            tree.delete(entry.getKey());
            ALog.d(TAG, "deleted:" + entry.getKey() + ", tree:" + tree);
            assertNull(tree.get(entry.getKey()));
        }

    }

    @Test
    public void deleteMin() {
        BinarySearchTree tree = new BinarySearchTree();
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            tree.put(entry.getKey(), entry.getValue());
        }
        while (tree.size() > 0) {
            Comparable min = tree.getMin();
            tree.deleteMin();
            ALog.d(TAG, "deleteMin deleted:" + min + ", tree:" + tree);
            assertNull(tree.get(min));
        }

    }

    @Test
    public void deleteMax() {
        BinarySearchTree tree = new BinarySearchTree();
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            tree.put(entry.getKey(), entry.getValue());
        }
        while (tree.size() > 0) {
            Comparable max = tree.getMax();
            tree.deleteMax();
            ALog.d(TAG, "deleteMax deleted:" + max + ", tree:" + tree);
            assertNull(tree.get(max));
        }
    }

    @Test
    public void rank() {
        BinarySearchTree tree = new BinarySearchTree();
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            tree.put(entry.getKey(), entry.getValue());
        }
        Comparable[] sortedKeys = tree.sortedKeys();
        if (null == sortedKeys) {
            return;
        }
        ALog.d(TAG, "rank tree:" + tree);
        for (int i = 0; i < sortedKeys.length; i++) {
            ALog.d(TAG, "rank:" + i + ", key:" + sortedKeys[i]);
            assertEquals(i, tree.rank(sortedKeys[i]));
        }
        assertEquals(-1, tree.rank(123));
    }

    @Test
    public void select() {
        BinarySearchTree tree = new BinarySearchTree();
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            tree.put(entry.getKey(), entry.getValue());
        }
        Comparable[] sortedKeys = tree.sortedKeys();
        if (null == sortedKeys) {
            return;
        }
        ALog.d(TAG, "select tree:" + tree);
        for (int i = 0; i < sortedKeys.length; i++) {
            ALog.d(TAG, "rank:" + i + ", key:" + sortedKeys[i]);
            assertEquals(sortedKeys[i], tree.select(i));
        }
        assertNull(tree.select(-1));
        assertNull(tree.select(tree.size()));
    }

    @Test
    public void floor() {
        BinarySearchTree tree = new BinarySearchTree();
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            tree.put(entry.getKey(), entry.getValue());
        }
        Comparable[] sortedKeys = tree.sortedKeys();
        if (null == sortedKeys) {
            return;
        }
        ALog.d(TAG, "floor tree:" + tree);
        for (int i = 0; i < sortedKeys.length; i++) {
            ALog.d(TAG, "rank:" + i + ", key:" + sortedKeys[i]);
            assertEquals(sortedKeys[i], tree.floor(sortedKeys[i]));
            assertEquals(sortedKeys[i], tree.floor((Integer)sortedKeys[i] + 1));
        }
        assertNull(tree.floor(-1));
        assertEquals(tree.getMax(), tree.floor(Integer.MAX_VALUE));
    }

    @Test
    public void ceiling() {
        BinarySearchTree tree = new BinarySearchTree();
        for (Map.Entry<Integer, Integer> entry : sKeyValues.entrySet()) {
            tree.put(entry.getKey(), entry.getValue());
        }
        Comparable[] sortedKeys = tree.sortedKeys();
        if (null == sortedKeys) {
            return;
        }
        ALog.d(TAG, "ceiling tree:" + tree);
        for (int i = 0; i < sortedKeys.length; i++) {
            ALog.d(TAG, "rank:" + i + ", key:" + sortedKeys[i]);
            assertEquals(sortedKeys[i], tree.ceiling(sortedKeys[i]));
            assertEquals(sortedKeys[i], tree.ceiling((Integer)sortedKeys[i] - 1));
        }
        assertNull(tree.ceiling((Integer)tree.getMax() + 1));
        assertEquals(tree.getMin(), tree.ceiling(Integer.MIN_VALUE));
    }
}