package com.mowen.algorithms.chapter2;

/**
 * Created by mowen on 4/14/16.
 * 排序方法三：插入排序
 * 定义：假设左边已经排好，然后将第i位向左依次插入，直至左边比自己还小
 * 普通sort方法的时间复杂度为最差是O(n^2),平均也是O(n^2),最好是(O(n))和0次交换
 * 使用于:数组已经基本有序
 *
 * 明显缺点：对大数据的乱序序列排序依旧很慢，因为元素只能一点一点地从数组的一端移动到另一端  而基于插入排序的希尔排序将优化这方面
 */
public class InsertionSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        for(int i = 1; i < a.length; i++) {
            for(int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
}
