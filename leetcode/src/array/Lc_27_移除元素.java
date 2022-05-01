/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 在这里编写类的功能描述
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。
 * 示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。
 *
 *
 *
 * @author luweiliang
 * @created 2020/5/23
 */
public class Lc_27_移除元素 {

    /**
     * 思路
     * 既然问题要求我们就地删除给定值的所有元素，我们就必须用 O(1) 的额外空间来处理它。
     * 如何解决？我们可以保留两个指针 i 和 j，其中 i 是慢指针，j 是快指针。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0) return 0;

        int j = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
//                System.out.println(nums[j]);
                j ++;
            }
        }
        return j;
    }

    public static void main(String[] args){
        int[] sums = {4, 5, 5, 6, 7, 1, 1, 2};
        System.out.println("index:" + removeElement(sums, 1));
    }

}
