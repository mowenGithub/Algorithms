package com.mowen.algorithms.chapter2;

/**
 * Created by mowen on 4/14/16.
 * 排序方法四：希尔排序
 * 定义：使数组中任意间隔为h的元素都用插入排序变得有序，然后逐渐递减h直至1.
 * 难点：怎么选择递增序列是一个难点
 * 要想确切知道希尔排序的时间复杂度是很困难的，O(2nlogn) ~ O(n^2)  之所以写O(2nlogn)中的2是想表达比nlogn是慢的
 * 使用于:希尔排序比插入排序和选择排序乱序下快的多，并且数组越大优势越明显
 *
 * 明显缺点：虽然希尔排序在乱序方面改进了插入排序，但当序列越有序的时候，对插入排序越有利
 */
public class ShellSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N/3) {
            h = 3*h +1;
        }

        while (h >= 1) {
            for(int i = h; i < a.length; i++) {
                for(int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h/3;
        }

    }
}
