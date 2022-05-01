/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package sort;

import java.util.Arrays;

/**
 * 堆排序
 * 构建初始堆，将待排序列构成一个大顶堆(或者小顶堆)，升序大顶堆，降序小顶堆；
 * 将堆顶元素与堆尾元素交换，并断开(从待排序列中移除)堆尾元素。
 * 重新构建堆。
 * 重复2~3，直到待排序列中只剩下一个元素(堆顶元素)。
 * 
 * @author luweiliang
 * @created 2020/4/22
 */
public class HeapSortMax {

    public static void heapSort(int[] array) {
        // 1.构建大顶堆
        for (int i = array.length / 2 - 1; i >= 0; i --) {
            // 从第一个非叶子结点从下至上，从右至左调整结构
            maxHeap(array, i, array.length);
        }
        // 2.调整堆结构+交换堆顶元素与末尾元素
        for (int i = array.length - 1; i > 0; i --) {
            swap(array, 0, i);       //将堆顶元素与末尾元素进行交换
            maxHeap(array, 0, i);  //重新对堆进行调整
        }
    }

    /**
     * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
     * 
     * @param array
     * @param i
     * @param length
     */
    public static void adjustHeap(int[] array, int i, int length) {
        int temp = array[i];// 先取出当前元素i
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {    // 从i结点的左子结点开始，也就是2i+1处开始
            if (k + 1 < length && array[k] < array[k + 1]) {        // 如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (array[k] > temp) {// 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        array[i] = temp;// 将temp值放到最终的位置
    }

    public static void maxHeap(int[] array, int index, int size){
        //左子节点
        int leftNode = 2 * index + 1;
        //右子节点
        int rightNode = 2 * index + 2;
        //假设自己最大
        int max = index;

        //分别比较左右叶子节点，找出最大的节点
        //如果是小顶堆，就把array[]leftNode < array[min]即可
        if (leftNode < size && array[leftNode] > array[max]){     //如果左侧叶子节点大于max则将最大位置换成leftNode
            max = leftNode;     // 将最大位置改为左子节点
        }
        if (rightNode < size && array[rightNode] > array[max]) {  //如果右侧叶子节点大于max则将最大位置换成rightNode
            max = rightNode;    // 将最大位置改为右子节点
        }
        //如果不相等就需要交换位置
        if (max != index) {
            int temp = array[index];
            array[index] = array[max];
            array[max] = temp;
            //交换位置以后，可能会破坏之前排好的堆，需要重新调整
            maxHeap(array, max, size);
        }
    }

    /**
     * 交换元素
     * 
     * @param arr
     * @param a
     * @param b
     */
    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] array = { 7, 6, 7, 11, 5, 12, 3, 0, 1 };
        System.out.println("排序前：" + Arrays.toString(array));
        heapSort(array);
        System.out.println("排序前：" + Arrays.toString(array));
    }
}
