package com.mowen.algorithms.chapter3;

/**
 * Created by mowen on 4/16/16.
 * 第二种 有序数组的二分查找
 * 查找时间复杂度lgN,插入时间复杂度最差2N，平均N，能保持有序性
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[])new Object[capacity];
    }
    public int size() {
        return N;
    }
    public Value get(Key key) {
        if(isEmpty()) return null;
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    /**
     * 非递归插入位置
     * @param key
     * @return
     */
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp > 0) lo = mid + 1;
            else if(cmp <0) hi = mid - 1;
            else return mid;
        }
        return lo;
    }

    /**
     * 递归的插入位置
     * @param key
     * @param lo
     * @param hi
     * @return
     */
    public int rank(Key key, int lo, int hi) {
        if(lo >= hi) return lo;
        int mid = lo + (hi - lo)/2;
        int cmp = key.compareTo(keys[mid]);
        if(cmp > 0) return rank(key, mid + 1, hi);
        else if(cmp < 0) return rank(key, lo, mid - 1);
        else return mid;
    }
    public void put(Key key, Value val) {
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for(int j = N; j > i; j--) {
            keys[j] = keys[j - 1]; vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public void print() {
        for(int i = 0; i < N; i++) {
            System.out.print(keys[i] + ":" + vals[i] + " ");
        }
        System.out.println();
    }
}
