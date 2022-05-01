/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/da-jia-bu-yao-kan-labuladong-de-jie-fa-fei-chang-2/
 * 输入: nums = [5,7,7,8,8,10], target = 8 输出: [3,4]
 * 输入: nums = [5,7,7,8,8,10], target = 6 输出: [-1,-1]
 * @author luweiliang
 * @created 2020/3/24
 */
public class lc_34_在排序数组中查找元素的第一个和最后一个位置 {

    /**
     * 核心思想
     * 二分查找到target的值；
     * 当nums[mid]等于 target的时候，则从mid向左向右继续检索等于target的索引
     * 然后向前向后的区间中找到不等于target的时候，就是我们要找的target(目标值)的第一个和最后一个元素的索引了
     * @param array
     * @param target
     * @return
     */
    public static int[] binarySearch(int[] array, int target) {
//        int start = searchFast(array, target);
//        int end = searchLast(array, target);
//        return new int[]{start, end};

        return binarySearchRange(array, 0, array.length - 1, array.length, target);
    }

    /**
     * 优先使用这个方法
     * @param nums
     * @param left
     * @param right
     * @param length
     * @param target
     * @return
     */
    private static int[]  binarySearchRange(int[] nums, int left, int right, int length, int target) {
        while (left <= right){
            int mid = (right - left) / 2 + left;
            // 当nums[mid]等于 target的时候，则从mid向左向右继续检索等于target的索引
            if (nums[mid] == target) {
                int l = mid - 1;
                int r = mid + 1;
                while (l >= 0 && nums[l] == target) l --;
                while (r < length && nums[r] == target) r ++;
                return new int[] { l + 1, r - 1};
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return new int[] {-1, -1};
    }

    public static int searchFast(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
//            int mid = left + (right - left) / 2;
            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                // ① 不可以直接返回，应该继续向左边找，即 [left, mid - 1] 区间里找
                right = mid - 1;
            } else if (nums[mid] < target) {
                // 应该继续向右边找，即 [mid + 1, right] 区间里找
                left = mid + 1;
            } else {
                // 此时 nums[mid] > target，应该继续向左边找，即 [left, mid - 1] 区间里找
                right = mid - 1;
            }
        }
        // 此时 left 和 right 的位置关系是 [right, left]，注意上面的 ①，此时 left 才是第 1 次元素出现的位置
        // 因此还需要特别做一次判断
        if (left != nums.length && nums[left] == target) {
            return left;
        }
        return -1;
    }

    public static int searchLast(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
//            int mid = left + (right - left) / 2;
            int mid = (right - left) / 2 + left;

            if (nums[mid] == target) {
                // 只有这里不一样：不可以直接返回，应该继续向右边找，即 [mid + 1, right] 区间里找
                left = mid + 1;
            } else if (nums[mid] < target) {
                // 应该继续向右边找，即 [mid + 1, right] 区间里找
                left = mid + 1;
            } else {
                // 此时 nums[mid] > target，应该继续向左边找，即 [left, mid - 1] 区间里找
                right = mid - 1;
            }
        }

        if (right != -1 && nums[right] == target) {
            return right;
        }
        return -1;
    }

    public static void main (String[] args){
        int[] array = {2, 5, 7, 8, 8, 8, 10};
        int[] res = binarySearch(array, 8);
        for (int r : res) {
            System.out.println(r);
        }

//        int i = searchFast(array, 8);
//        System.out.println(i);
//        int last = searchLast(array, 8);
//        System.out.println(last);
    }
}
