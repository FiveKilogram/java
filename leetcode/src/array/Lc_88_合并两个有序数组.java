/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 说明: 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  示例:
 *  输入: nums1 = [1,2,3,0,0,0], m = 3
 *  nums2 = [2,5,6],       n = 3
 *  输出: [1,2,2,3,5,6]
 *  时间复杂度 O(m + n)
 *  空间复杂度 O(1)
 *  https://leetcode-cn.com/problems/merge-sorted-array/
 * @author luweiliang
 * @created 2020/7/19
 */
public class Lc_88_合并两个有序数组 {

    /**
     * 方法、双指针
     * p1指向nums1有效尾部即 m - 1，p2指向nums2尾部即 n - 1，p3指向nums1尾部（nums1和nums2合并后尾部）即 m + n - 1
     * 由于num1空间足够大，同时从有效尾部遍历num1和num2，比较大小，然后放在num1最后面
     * 注意循环条件，nums2全部合并到nums1中，也就是p2 >= 0
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n){
        // 三指针 指针一p1、nums1有效元素尾部；指针二p2、nums2尾部；指针三p3、最终数组尾部
        // 1.当，p1>=0时，nums[p1],nums[p2]对比
        // 1.1 nums[p1]大，将nums[p1]放入p3位置。p1--,p3--
        // 1.2 nums[p2]大于等于nums[p1]，将nums[p2]放入p3位置。p2--,p3--
        // 2.当，p1<0时，将nums[p2]放入p3位置。p2--,p3--
        // 循环结束条件：p2<0

        int p1 = m - 1, p2 = n - 1, p3 = m + n -1;
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p3 --] = nums1[p1 --];
            } else {
                nums1[p3 --] = nums2[p2 --];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        merge(nums1, m, nums2, n);
        for (int i = 0; i < nums1.length; i ++) {
            System.out.println(nums1[i]);
        }
    }
}
