/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package binarySearch;

import java.util.PriorityQueue;

/**
 * 查找一个无序数组的中位数
 * https://blog.csdn.net/qq_35024198/article/details/90814869
 * @author luweiliang
 * @created 2020/4/8
 */
public class 查找一个无序数组的中位数 {

    public static double search(int[] array){
        quickSort(array,0, array.length - 1);
        int mid = array.length / 2;
        //奇数个元素，获取最中间
        if (array.length % 2 == 1){
            return array[mid];
        } else { //偶数个元素，获取中间两个数相加 ／ 2
            return (array[mid - 1] + array[mid]) / 2;
        }
    }

    public static void quickSort(int[] array, int left, int right){
        if(left > right) return;

        int i = left, j = right, key = array[left];
        while (i < j) {
            while (key <= array[j] && i < j) j --;
            while (key >= array[i] && i < j) i ++;
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[left] = array[i];
        array[i] = key;
        quickSort(array, left, j - 1);
        quickSort(array, i + 1, right);
    }

    public static double search1(int[] array){
        int heapSize = (array.length + 1) / 2;  //奇数个元素
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < heapSize; i ++){
            queue.offer(array[i]);
        }

        for (int i = heapSize; i < array.length; i++) {
            if (queue.peek() < array[i]) {
                queue.poll();
                queue.offer(array[i]);
            }
        }

        if (array.length % 2 == 1) {
            return queue.peek();
        } else {
            return (queue.poll() + queue.peek()) / 2;
        }

    }

    public static void main (String[] args){
        int[] array = {2 , 6, 1, 7, 10, 5};
        System.out.println(search(array));
        System.out.println(search1(array));
    }
}
