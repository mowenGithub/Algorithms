package com.mowen.algorithms.chapter2;

import com.mowen.algorithms.util.In;

/**
 * Created by mowen on 4/14/16.
 * 使用模板模式设计
 */
public abstract class Sort {
    public void test() {
        String[] a = In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

    public abstract void sort(Comparable[] a);

    public boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void show(Comparable[] a) {
        for(Comparable c : a) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public boolean isSorted(Comparable[] a) {
        for(int i = 1; i < a.length; i++) {
            if(less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
