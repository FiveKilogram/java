/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package binarySearch;

/**
 * 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 * @author luweiliang
 * @created 2020/4/8
 */
public class Lc_704_二分查找 {
    public static int search(int[] array, int target){
        if (array == null || array.length == 0) return -1;
        int left = 0;
        int rigth = array.length - 1;
        while (left <= rigth) {
            int mid = left + (rigth - left) / 2;
            if (array[mid] == target) {
                return mid;
            } else if(array[mid] > target){
                rigth = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main (String[] args){
        int[] array = {-1,0,3,5,9,12, 15};
        System.out.println(search(array, 9));
    }
}
