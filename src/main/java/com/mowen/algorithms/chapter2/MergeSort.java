package com.mowen.algorithms.chapter2;

/**
 * Created by mowen on 4/14/16.
 * 排序方法五：归并排序
 * 定义：使用“分治”的思想，要排序一个数组，可以先（地柜地）将它分成两半分别排序.
 * 时间复杂度在1/2NlgN - NlgN
 * 还可以证明出：没有任何基于比较的算法能够保证使用少于lg(N!) - NlgN次比较将长度为N的数组排序.
 * 进而证明：归并排序是一种渐进最优的基于比较排序的算法.
 * 自下而上的归并排序适用于链表组织的数据
 *
 * 明显缺点：需要额外空间和N成正比，即空间复杂度上不是最优解
 * 有些不是基于可比较而进行的排序归并就不是最优解
 */
public class MergeSort extends Sort {

    private static Comparable[] aux;
    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];

        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if(lo >= hi) {
            return;
        }
        int mid = lo + (hi-lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public void sortUp(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for(int sz = 1; sz < N; sz = sz + sz) {
            for(int lo = 0; lo < N - sz; lo +=sz+sz) {
                merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }
    }

    private void merge(Comparable[] a, int lo, int mid, int hi) {
        //a[lo, mid] a[mid+1, hi]
        int i = lo;
        int j = mid + 1;
        for(int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for(int k = lo; k <= hi; k++) {
            if(i > mid)                 a[k] = aux[j++];
            else if(j > hi)                  a[k] = aux[i++];
            else if(less(aux[i], aux[j]))    a[k] = aux[i++];
            else                        a[k] = aux[j++];
        }
    }
}
