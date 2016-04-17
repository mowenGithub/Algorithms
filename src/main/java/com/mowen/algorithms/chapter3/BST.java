package com.mowen.algorithms.chapter3;

/**
 * Created by mowen on 4/17/16.
 * 第三种 二叉查找树
 * 二叉查找树(BST)：是一颗二叉树,其中每个结点都含有一个Comparable的建(以及相关联的值)且每个结点的键都大于其左子树中的任意结点的键，而小于右子树的任意结点.
 * 二叉查找树的查找和插入的最坏情况是N，平均2lnN(~1.39lgN). 与树高成正比
 *
 * 删除结点的思想，是先找到右子树最小值，再替换其位置，然后递归更新结点的N值
 */
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        private Key key;
        private Value val;
        private Node left,right;
        private int N;  //以此结点为根的结点总数

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if(x == null) return 0;
        return x.N;
    }
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0) return get(x.right, key);
        else if(cmp < 0) return get(x.left, key);
        else return x.val;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val); //递归修改每个有影响的值
    }

    private Node put(Node x, Key key, Value val) {
        if(x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if(cmp > 0) x.right = put(x.right, key, val);
        else if(cmp < 0) x.left = put(x.left, key, val);
        else x.val = val;

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void print() {
        print(root);
        System.out.println();
    }

    private void print(Node x) {
        if(x == null) return;
        print(x.left);
        System.out.print(x.key + ":" + x.val + " ");
        print(x.right);
    }
}
