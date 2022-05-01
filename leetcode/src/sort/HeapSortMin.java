/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package sort;

import java.util.Arrays;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/5/8
 */
public class HeapSortMin {

    /**
     * 需要将最小的顶部与最后一个交换
     *
     * @param array
     */
    public static void heapSort(int[] array) {
        // 构建小顶堆
        for (int i = array.length / 2 - 1; i >= 0; i --) {
            minHeap(array, i, array.length);    //开始位置最后一个非叶子节点，最后一个叶子节点的父节点
        }

        // 最后一个跟第一个进行调整
        for (int i = array.length - 1; i > 0; i --) {
            swap(array, 0, i);          //将堆顶元素与末尾元素进行交换
            minHeap(array, 0, i);    //重新对小顶堆进行调整
        }
    }

    /**
     * 构造小顶堆
     * 
     * @param array
     *            待调整数组
     * @param index
     *            调整哪一个 最后一个叶子节点的父节点开始调整
     * @param size
     *            调整多少
     */
    public static void minHeap(int[] array, int index, int size) {

        // 左子节点
        int leftNode = 2 * index + 1;
        // 右子节点
        int rightNode = 2 * index + 2;
        //假设自己最小
        int min = index;

        //分别比较左右叶子节点找出最小节点
        //如果是大顶堆，就把array[]leftNode > array[min]即可
        if (leftNode < size && array[leftNode] < array[min]) {     //如果左侧叶子节点小于min则将最小位置换成leftNode
            min = leftNode;         // 将最小位置改为左子节点
        }
        if (rightNode < size && array[rightNode] < array[min]) {    //如果右侧叶子节点小于min则将最小位置换成rightNode
            min = rightNode;        // 将最小位置改为右子节点
        }
        //如果不相等就需要交换位置
        if (min != index) {
            int tem = array[index];
            array[index] = array[min];
            array[min] = tem;
            //交换位置以后，可能会破坏之前排好的堆，需要重新调整
            minHeap(array, min, size); // 位置为刚才改动的位置；
        }
    }

    /**
     * 交换元素
     * 
     * @param arr
     * @param a 最前面的一个
     * @param b 最后一个
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];  // 最前面的一个
        arr[a] = arr[b];    //最后一个
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 7, 6, 7, 11, 5, 12, 3, 0, 1 };
        System.out.println("排序前：" + Arrays.toString(array));
        heapSort(array);// 小顶堆
        System.out.println("排序前：" + Arrays.toString(array));
    }
}
