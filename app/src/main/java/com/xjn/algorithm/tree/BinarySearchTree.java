package com.xjn.algorithm.tree;

import androidx.annotation.NonNull;

import com.xjn.algorithm.utils.ALog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
二叉查找树每个节点最多有2个子节点，且任意节点都大于左子树的最大节点、小于右子树的最小节点。
 */
public class BinarySearchTree implements ITree {
    private static final String TAG = BinarySearchTree.class.getSimpleName();
    private Node mRoot;

    @Override
    public void put(Comparable key, Object value) {
        mRoot = put(mRoot, key, value);
    }

    @Override
    public Object get(Comparable key) {
        Node node = get(mRoot, key);
        return (null == node) ? null : node.value;
    }

    @Override
    public Comparable getMin() {
        Node node = getMin(mRoot);
        return (null == node) ? null : node.key;
    }

    @Override
    public Comparable getMax() {
        Node node = getMax(mRoot);
        return (null == node) ? null : node.key;
    }

    @Override
    public void delete(Comparable key) {
        mRoot = delete(mRoot, key);
    }

    @Override
    public void deleteMin() {
        mRoot = deleteMin(mRoot);
    }

    @Override
    public void deleteMax() {
        mRoot = deleteMax(mRoot);
    }

    @Override
    public int rank(Comparable key) {
        int rank = rank(mRoot, key);
        return (rank < 0) ? -1 : rank;
    }

    @Override
    public Comparable select(int rank) {
        // rank start from 0
        if (null == mRoot || rank < 0 || rank >= mRoot.count) {
            return null;
        }

//        rank++; // change the start position from 0 to 1
        return select(mRoot, rank).key;
    }

    @Override
    public Comparable floor(Comparable key) {
        Node node = floor(mRoot, key);
        return (null == node) ? null : node.key;
    }

    @Override
    public Comparable ceiling(Comparable key) {
        Node node = ceiling(mRoot, key);
        return (null == node) ? null : node.key;
    }

    @Override
    public Comparable[] sortedKeys() {
        if (null == mRoot) {
            return null;
        }

        List<Comparable> keys = new ArrayList<>();
        sortedKeys(mRoot, keys);
        return keys.toArray(new Comparable[0]);
    }

    @Override
    public int size() {
        return size(mRoot);
    }

    @NonNull
    @Override
    public String toString() {
        return Arrays.toString(sortedKeys());
    }

    private int size(Node node) {
        return (null == node) ? 0 : node.count;
    }

    private Node put(Node root, Comparable key, Object value) {
        if (null == root) {
            return new Node(key, value);
        }

        int compare = key.compareTo(root.key);
        if (compare > 0) {
            root.right = put(root.right, key, value);
        } else if (compare < 0) {
            root.left = put(root.left, key, value);
        } else {
            root.value = value;
        }
        root.count = size(root.left) + size(root.right) + 1;

        return root;
    }

    private Node get(Node root, Comparable key) {
        if (null == root) {
            return null;
        }

        int compare = key.compareTo(root.key);
        if (compare > 0) {
            return get(root.right, key);
        } else if (compare < 0) {
            return get(root.left, key);
        } else {
            return root;
        }
    }

    private Node getMin(Node root) {
        if (null == root) {
            return null;
        } else if (null == root.left) {
            return root;
        } else {
            return getMin(root.left);
        }
    }

    private Node getMax(Node root) {
        if (null == root) {
            return null;
        } else if (null == root.right) {
            return root;
        } else {
            return getMax(root.right);
        }
    }

    private Node delete(Node root, Comparable key) {
        if (null == root) {
            return null;
        }

        int compare = key.compareTo(root.key);
        if (compare > 0) {
            root.right = delete(root.right, key);
        } else if (compare < 0) {
            root.left = delete(root.left, key);
        } else {
            ALog.d(TAG, "delete:" + key);
            if (null == root.right) {
                root = root.left;
                return root;
            }
            Node node = root;
            root = getMin(node.right);
//            ALog.d(TAG, "delete root:" + root + ", node:" + node);
            root.right = deleteMin(node.right);
//            root.right = node.right;
            root.left = node.left;
//            ALog.d(TAG, "delete, tree:" + this);
        }
        root.count = size(root.left) + size(root.right) + 1;

        return root;
    }

    private Node deleteMin(Node root) {
        if (null == root) {
            return null;
        } else if (null == root.left) {
            root = root.right;
            return root;
        } else {
            root.left = deleteMin(root.left);
            root.count = size(root.left) + size(root.right) + 1;
            return root;
        }
    }

    private Node deleteMax(Node root) {
        if (null == root) {
            return null;
        } else if (null == root.right) {
            root = root.left;
            return root;
        } else {
            root.right = deleteMax(root.right);
            root.count = size(root.left) + size(root.right) + 1;
            return root;
        }
    }

    private int rank(Node root, Comparable key) {
        if (null == root) {
            return -Integer.MIN_VALUE;
        }
        int compare = key.compareTo(root.key);
        if (compare > 0) {
            return 1 + size(root.left) + rank(root.right, key);
        } else if (compare < 0) {
            return rank(root.left, key);
        } else {
            return size(root.left);
        }
    }

    private Node select(Node root, final int rank) {
        // root will not be null
        int rootRank = (null == root.left) ? 0 : root.left.count;
        if (rank == rootRank) {
            return root;
        } else if (rank > rootRank) {
            return select(root.right, rank - rootRank - 1);
        } else {
            return select(root.left, rank);
        }
    }

    private Node floor(Node root, Comparable key) {
        if (null == root) {
            return null;
        }

        int compare = key.compareTo(root.key);
        if (0 == compare) {
            return root;
        } else if (compare < 0) {
            return floor(root.left, key);
        } else {
            Node node = floor(root.right, key);
            return (null == node) ? root : node;
        }
    }

    private Node ceiling(Node root, Comparable key) {
        if (null == root) {
            return null;
        }

        int compare = key.compareTo(root.key);
        if (0 == compare) {
            return root;
        } else if (compare > 0) {
            return ceiling(root.right, key);
        } else {
            Node node = ceiling(root.left, key);
            return (null == node) ? root : node;
        }
    }

    public void sortedKeys(Node root, List<Comparable> keys) {
        if (null != root) {
            sortedKeys(root.left, keys);
            keys.add(root.key);
            sortedKeys(root.right, keys);
        }
    }
}