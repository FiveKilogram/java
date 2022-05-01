/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package sort;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/3/31
 */
public class SelectSort {

    public static int[] seletctSort(int[] array){
        if (array == null || array.length < 2) return array;

        int len = array.length;
        int minIndex = 0;
        for (int i = 0; i < len -1; i ++) {
            minIndex = i;
            for (int j = i + 1; j < len; j ++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int array[] = {6, 2, 4, 8, 10, 5, 9, 7, 1, 3};
        seletctSort(array);
        for (int i = 0; i < array.length; i ++) {
            System.out.println(array[i]);
        }
    }
}
