package com.mowen.algorithms.chapter2;

/**
 * Created by mowen on 4/15/16.
 * 以堆实现的优先级队列
 * 插入元素，删除元素的时间复杂度为O(lgN)
 */
public class HeapPriorityQueue extends PriorityQueue {
    private Comparable[] pg;
    private int N = 0;

    public HeapPriorityQueue(int maxN) {
        pg = new Comparable[maxN];
    }
    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public void insert(Comparable v) {
        if(N >= pg.length - 1) {
            return; //TODO should throw Exception
        }
        pg[++N] = v;
        swim(N);
    }

    @Override
    public Comparable delMax() {
        Comparable max = pg[1];
        exch(pg ,1, N--);
        pg[N + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(pg[k/2], pg[k])) {
            exch(pg, k/2, k);
            k = k/2;
        }
    }

    private void sink(int k) {
        while (k*2 <= N) {
            int j = k * 2;
            if(j < N && less(pg[j], pg[j + 1])) j++;
            if(!less(pg[k], pg[j])) break;
            exch(pg, k, j);
            k = j;
        }
    }
}
