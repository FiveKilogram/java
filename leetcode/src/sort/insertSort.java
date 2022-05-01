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
 * @created 2020/4/1
 */
public class insertSort {

    public static int[] insertSort(int[] array) {
        if (array == null || array.length < 2) return array;

        for (int i = 0; i < array.length; i ++) {
            for (int j = i; j > 0; j --) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int array[] = {6, 2, 4, 8, 150, 1, 10, 5, 9, 7, 1, 3};
        insertSort(array);
        for (int i = 0; i < array.length; i ++) {
            System.out.println(array[i]);
        }
    }
}
