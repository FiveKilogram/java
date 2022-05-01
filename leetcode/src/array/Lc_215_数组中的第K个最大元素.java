/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * Lc_215_数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 思路：利用快排的思想，从数组arr中随机找出一个元素X，把数组分成两部分arr_a和arr_b。
 * arr_a中的元素比x大，arr_b中的元素比x小。
 * 这个时候分为两种情况：
 * 1.arr_a中的元素小于K，则arr_b中第k-arr_a.length个元素即为第K大数。
 * 2.arr_a中的元素大于等于K，则返回arr_a中第K大数
 * 时间复杂度：O（n）
 * @author luweiliang
 * @created 2020/5/8
 */
public class Lc_215_数组中的第K个最大元素 {
    public static int quick(int[] arrat, int left, int right){
        int key = arrat[left];
        while(left < right){
            while(key >= arrat[right] && left < right) {
                right --;
            }
            arrat[left] = arrat[right];
            while(key <= arrat[left] && left < right){
                left ++;
            }
            arrat[right] = arrat[left];
        }
        arrat[right] = key;
        return right;
    }

    public static void find_k(int k, int[] arrat, int left, int right){
        int temp = quick(arrat, left, right);
        if( temp == k - 1){
            System.out.print("第" + k + "大的数是：" + arrat[temp]);
        }else if(temp > k - 1){
            find_k(k, arrat, left,temp - 1);
        }else{
            find_k(k - temp, arrat,temp + 1, right);
        }
    }

    public static void quickSort(int[] array, int left, int right){
        if (left > right) {
            return;
        }
        int i = left, j = right, key;
        key = array[left];
        while(i < j) {
            while (key >= array[j] && i < j) {
                j --;
            }
            while (key <= array[i] && i < j) {
                i ++;
            }
            if (i < j) {
                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        array[left] = array[i];
        array[i] = key;
        quickSort(array, left, j - 1);
        quickSort(array, i + 1, right);
    }

    public static int find_k(int k, int[] array){
       return array[k - 1];
    }

    public static void main(String[] args) {
        int array[] = {6, 2, 4, 8, 150, 1, 10, 5, 9, 7, 1, 3};
//        find_k(2, array, 0, array.length - 1);
        quickSort(array, 0, array.length - 1);
        int k = 3;
        System.out.println(find_k(k, array));

    }
}
