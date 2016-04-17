package com.mowen.algorithms.chapter3;

/**
 * Created by mowen on 4/17/16.
 * 第四种 平衡查找树 -> 2-3树 -> 红黑二叉查找树
 * 平衡查找树是指含有N各结点的树的树高时lgN.
 *
 * 2-3树插入和查找比较复杂，代码太多，用红黑树这种简单的数据结构表达实现它更好，特别时get方法直接就可复用二叉查找树的.
 * 红黑二叉查找树:
 * 红链接均为左链接
 * 没有任何一个结点同时和两条红链接相连
 * 该树时完美黑色平衡的，即任意空链接到根结点的路径上黑链接的数量相同
 *
 * 由于一颗大小为N的红黑树的高度不会超过2lgN,根结点到任意结点的平均路径长度为～1.00lgN
 * 所以红黑树的最差查找和插入的时间复杂度时2lgN, 平均是1.00lgN
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private Node root;
    private class Node {
        Key key;
        Value val;
        Node left,right;
        int N;
        boolean color;

        Node(Key key, Value val, int N, boolean color) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }
    }
    private boolean isRed(Node x) {
        if(x == null) return false;
        return x.color == RED;
    }
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left= x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }
    private void flipColors(Node h) {
        h.color = BLACK;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
    private int size(Node x) {
        if(x == null) return 0;
        return x.N;
    }
    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if(h == null) return new Node(key, val, 1, RED);
        int cmp = key.compareTo(h.key);

        if(cmp < 0) h.left = put(h.left, key, val);
        else if(cmp > 0) h.right = put(h.right, key, val);
        else h.val = val;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;
        return h;
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

    public void print() {
        print(root);
        System.out.println();
    }

    private void print(Node x) {
        if(x == null) return;
        System.out.print(x.key + ":" + x.val + " ");
        print(x.left);
        print(x.right);
    }
}
