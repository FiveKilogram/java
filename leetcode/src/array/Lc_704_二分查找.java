/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 二分查找
 * 给定一个n个元素有序的（升序）整型数组nums和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * @author luweiliang
 * @created 2020/5/22
 */
public class Lc_704_二分查找 {
    public static int binarySearch(int array[], int value){
        int left = 0;
        int right = array.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (array[mid] == value) {
                return mid;
            }
            if (array[mid] > value) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index = binarySearch(array, 5);
        System.out.println(index);
    }
}
