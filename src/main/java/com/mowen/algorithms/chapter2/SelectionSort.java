package com.mowen.algorithms.chapter2;

/**
 * Created by mowen on 4/14/16.
 * 排序方法二：选择排序
 * 定义：依次比较未排序的序列中的元素找出最小元素，然后将最小元素与未完成排序序列第一个交换，然后依次找下一个
 * 普通sort方法的时间复杂度为O(n^2),不论最优最差，但交换次数是n，这个比冒泡排序有明显优势
 * 使用于:较少元素，且要求交换较少的情况
 *
 * 明显缺点：无论输入情况，都将循环两次并且一次不少的进行比较， 插入排序将优化这方面
 */
public class SelectionSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            int min = i;
            for(int j = i + 1; j < a.length; j++) {
                if(less(a[j], a[min])) {
                    min = j;
                }
            }
            if(min != i) {
                exch(a, i, min);
            }
        }
    }
}
