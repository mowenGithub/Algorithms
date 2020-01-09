package com.mowen.algorithms.chapter2;

import com.mowen.algorithms.util.StdRandom;

/**
 * Created by mowen on 4/14/16.
 * 排序方法六：快速排序
 * 定义：使用“分治”的思想，与归并排序是互补的，先将一个数组以切分元素的为中间值分成两组，进而递归对每个分组进行如上操作.
 * 时间复杂度在NlgN - N^2/2,但最糟糕的情况可以通过随机打乱数组来预防
 * 快速排序所用时间比插入排序和选择排序一样多的概率非常非常小，可以忽略不计，几乎时原地排序，这比归并排序好
 *
 * 算法改进：
 * 小数组应该用插入排序
 * 三取样切分，每次找到中位数
 * 当重复元素过多，可以使用三分法，例如三向切分法，可以将复杂度变成（2ln2）HN，即从线性对数变成线性
 */
public class QuickSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int j = portition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private int portition(Comparable[] a, int lo, int hi) {
        //将数组切分为a[lo...i-1], a[i], a[i+1,hi]
        int i = lo;
        int j = hi +1;
        Comparable v = a[lo];
        while (true) {
            while(less(a[++i], v)) if(i == hi) break;
            while(less(v, a[--j])) if(j == lo) break;
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
}
