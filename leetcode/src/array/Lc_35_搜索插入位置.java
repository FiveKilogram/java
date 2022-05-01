/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 搜索插入位置,二分查找
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 时间复杂度：O(logN)
 * 空间复杂度: O(1)
 * @author luweiliang
 * @created 2020/5/22
 */
public class Lc_35_搜索插入位置 {

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        // 特判,nums的长度小于target时，返回nums的长度，nums的长度和索引相同，也就是长度的下一个值；
        if (nums[len - 1] < target) return len;

        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        //返回比target大一个元素的位置，就是当前要插入的位置的索引，返回left即可
        return left;
    }

    public static void main(String[] args) {
        int array[] = {1, 2, 3, 5, 6, 7, 8, 9};
        int index = searchInsert(array, 5);
        System.out.println(index);
    }

}
