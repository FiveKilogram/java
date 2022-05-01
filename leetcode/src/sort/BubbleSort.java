/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package sort;

/**
 * 冒泡排序
 * https://blog.csdn.net/qq_39741605/article/details/80821595
 * @author luweiliang
 * @created 2019/10/22
 */
public class BubbleSort {
   public static void bubbleSort (int array[]) {
       for (int i = 0; i < array.length; i ++) {
           for (int j = 0; j < array.length - i -1; j ++) {
               if (array[j] > array[j + 1]){
                   int temp = array[j];
                   array[j] = array[j + 1];
                   array[j + 1] = temp;
               }
           }
       }
   }

    public static void main(String[] args) {
        int array[] = {6, 2, 4, 8, 10, 5, 9, 7, 1, 3};
        bubbleSort(array);
        for (int i = 0; i < array.length; i ++) {
            System.out.println(array[i]);
        }
    }

    public static void bubleSort(int[] array){
       for (int i = 0; i < array.length; i ++) {
           for (int j = 0; j < array.length - 1 - i; j ++) {
               if(array[j] > array[j + 1]){
                   int temp = array[j];
                   array[j] = array[j + 1];
                   array[j + 1] = temp;
               }
           }
       }
    }

    public static void sort(int[] array){
        for(int i = 0; i < array.length; i ++){
            for(int j = 0; j < array.length -1 -  i; j ++ ){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    public static void sort1(int[] array){
        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array.length -1 - j; j ++) {
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
