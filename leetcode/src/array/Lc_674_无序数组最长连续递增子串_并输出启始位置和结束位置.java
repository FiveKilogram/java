/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
 * 那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * 链接：https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence
 * 示例 1：输入：nums = [1,3,5,4,7] 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：输入：nums = [2,2,2,2,2] 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 *
 * @author luweiliang
 * @created 2020/12/7
 */
public class Lc_674_无序数组最长连续递增子串_并输出启始位置和结束位置 {
    public static int findLengthOfLCIS(int[] nums){
        if(nums.length == 1 || nums.length == 0){
            return nums.length;
        }
        int max = 0;
        int sum = 1;
        int start = 0, end = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i + 1]){
                sum ++;
            } else {
                if(sum > max){
                    max = sum;
                    sum = 1;
                    start = i - max;
                }
            }
        }
        if(max < sum){
            max = sum;

        }
        end = start + Math.max(sum, max);
        System.out.println("子串的开始位置：" + start);
        System.out.println("子串的长度：" +  Math.max(sum, max));
        System.out.println("子串的结束位置：" + end);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {15, 3, 4, 5, 1, 6, 7, 8, 9, 10, 7, 4, 5};
        int[] nums1 = {2, 3, 5, 4, 7};
        findLengthOfLCIS(nums1);
    }
}
