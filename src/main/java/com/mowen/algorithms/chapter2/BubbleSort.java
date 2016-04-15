package com.mowen.algorithms.chapter2;

/**
 * Created by mowen on 4/14/16.
 * 排序方法一：冒泡排序 [又叫：鸡尾酒排序]
 * 定义：依次比较两个元素，如果位置错乱则交换，知道最大[小]的元素交换到最右边，再依次交换找出第二大[小]
 * 普通sort方法的时间复杂度为O(n^2),不论最优最差
 * 改进betterSort方法的最差时间复杂度是O(n^2)，最优是O(n)
 * 使用于:较少元素，且对效率要求不高的情况
 *
 * 明显缺点是交换次数多，这个将有选择排序给优化这方面，
 * 还有无论输入都将循环两次并且一次不少的比较
 */
public class BubbleSort extends Sort{
    @Override
    public void sort(Comparable[] a) {
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j ++) {
                if(less(a[j], a[j -1])) {
                    exch(a, j, j - 1);
                }
            }
        }
    }

    public void butterSort(Comparable[] a) {
        boolean flag = false;
        for(int i = 0; i < a.length - 1; i++) {
            for(int j = 1; j < a.length - i; j++) {
                if(less(a[j], a[j -1])) {
                    exch(a, j, j -1);
                    flag = true;
                }
            }
            if(!flag) {
                return;
            }
            flag = false;
        }
    }
}
