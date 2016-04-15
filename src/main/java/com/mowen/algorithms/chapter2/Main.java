package com.mowen.algorithms.chapter2;

import com.mowen.algorithms.util.In;

/**
 * Created by mowen on 4/14/16.
 */
public class Main {

    public static void main(String[] args) {
//        Sort bubbleSort = new BubbleSort();
//        bubbleSort.test();

//        Sort selectionSort = new SelectionSort();
//        selectionSort.test();

//        Sort insertionSort = new InsertionSort();
//        insertionSort.test();

//        Sort shellSort = new ShellSort();
//        shellSort.test();

//        Sort mergeSort = new MergeSort();
//        mergeSort.test();

//        Sort quickSort = new QuickSort();
//        quickSort.test();

//        PriorityQueue priorityQueue = new HeapPriorityQueue(100);
//        String[] a = In.readStrings();
//        for(String item : a) {
//            priorityQueue.insert(item);
//        }
//        System.out.println(priorityQueue.delMax());
//        System.out.println(priorityQueue.delMax());

        Sort heapSort = new HeapSort();
        heapSort.test();
    }
}
