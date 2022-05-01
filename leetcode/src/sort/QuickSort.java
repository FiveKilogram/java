/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package sort;

/**
 * 快速排序
 * https://blog.csdn.net/shujuelin/article/details/82423852
 * @author luweiliang
 * @created 2019/10/22
 */
public class QuickSort {

    public static void quickSort(int array[], int low, int high){
        if (low > high) {
            return;
        }
        int i = low, j = high, key = array[low];
        while (i < j){
            //先看右边，依次往左递减
            while (key <= array[j] && i < j){
                j --;
            }
            //在看左边，依次往右递增
            while (key >= array[i] && i < j) {
                i ++;
            }
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        array[low] = array[i];
        array[i] = key;
        //递归调用左半数组
        quickSort(array, low, j -1);
        //递归调用右半数组
        quickSort(array, i + 1, high);
    }

    public static void quickSort1(int[] array, int left, int right){
        if(left > right){
            return;
        }
        int i, j, key;
        i = left;
        j = right;
        key = array[left];
        while(i < j){
            while(key <= array[j] && i < j){
                j --;
            }
            while(key >= array[i] && i < j){
                i ++;
            }
            if(i < j){
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        array[left] = array[i];
        array[i] = key;
        quickSort1(array, left, j - 1);
        quickSort1(array, i + 1, right);
    }

   public static void quickSort3(int[] array, int left, int right){
        if (left > right) {
            return;
        }
        int i, j, key;
        i = left;
        j = right;
        key = array[left];
        while(i < j){
            while(key <= array[j] && i < j){
                j --;
            }
            while(key >= array[i] && i < j){
                i ++;
            }
            if (i < j){
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        array[left] = array[i];
        array[i] = key;
        quickSort3(array, left, i - 1);
        quickSort3(array, i + 1, right);
   }



   public static void quickSort(int[] array){
       quickSort4(array, 0, array.length -1);
   }
   public static void quickSort4(int[] array, int left, int right){
       if (left > right) {
           return;
       }
       int i = left, j = right, key = array[left];
       while(i < j) {
           //先看右边，依次往左递减
           while (key <= array[j] && i < j) {
               j --;
           }
           //再看左边，依次往右递增
           while (key >= array[i] && i < j) {
               i ++;
           }
           if (i < j) {
               int temp = array[j];
               array[j] = array[i];
               array[i] = temp;
           }
       }
       //最后将基准为与i和j相等位置的数字交换
       array[left] = array[i];
       array[i] = key;
       //递归调用左半数组
       quickSort4(array, left, j - 1);
       //递归调用右半数组
       quickSort4(array, i + 1, right);
   }

    public static void main(String[] args) {
        int array[] = {6, 2, 4, 8, 150, 1, 10, 5, 9, 7, 1, 3};
        quickSort4(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i ++) {
            System.out.println(array[i]);
        }
    }
}
