package com.mowen.algorithms.chapter2;

/**
 * Created by mowen on 4/15/16.
 * 排序方法七：堆排序
 * 定义：使用完全二叉树理论，先构造出堆有序，然后将最大值与最后元素交换，然后对第一个元素执行下沉排序
 * 时间复杂度在O(NlgN),平均比快速排序和归并稍微慢点，但是原地排序，空间利用高，特别在嵌入式等方面
 *
 * 算法改进：
 * 由于无法使用缓存[因为不是相邻比较关系]，所以没有其他排序[快排，归并等]用的广泛
 */
public class HeapSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        //第一个元素不参与排序
        int N = a.length - 1;
        for(int k = N/2; k > 0; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private void sink(Comparable[] a, int k, int N) {
        while (k*2 <= N) {
            int j = k * 2;
            if(j < N && less(a[j], a[j + 1])) j++;
            if(!less(a[k], a[j])) break;
            exch(a, k, j);
            k = j;
        }
    }
}
