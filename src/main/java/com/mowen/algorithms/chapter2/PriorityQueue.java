package com.mowen.algorithms.chapter2;

/**
 * Created by mowen on 4/15/16.
 */
public abstract class PriorityQueue {
    public abstract boolean isEmpty();
    public abstract int size();
    public abstract void insert(Comparable v);
    public abstract Comparable delMax();
    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
