/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

/**
 * 连续子数组的最大和
 * 一个整数数组中的元素有正有负，在该数组中找出一 个连续子数组，要求该连续子数组中各元素的和最大，这个连续子数组便被称作最大连续子数组。
 * 比如数组{2,4,-7,5,2,-1,2,-4,3}的最大连续子数组为{5,2,-1,2}，最大连续子数组的和为5+2-1+2=8。
 * 问题输入就是一个数组，输出该数组的“连续子数组的最大和”。
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4] 输出: 6
 * 解释: 连续子数组 [4, -1, 2, 1] 的和最大，为 6。
 *
 * @author luweiliang
 * @created 2020/6/15
 */
public class ms_42_连续子数组的最大和 {
    public static int maxSubArray(int[] array){
        if(null == array || array.length == 0){
            return 0;
        }
        int sum = array[0];
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(sum < 0){
                sum = 0;
            }
            sum += array[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 动态规划
     * 状态定义： 设动态规划列表 dp ，dp[i] 代表以元素 nums[i]为结尾的连续子数组最大和。
     * 为何定义最大和 dp[i] 中必须包含元素 nums[i] ：保证 dp[i] 递推到 dp[i+1] 的正确性；如果不包含 nums[i] ，递推时则不满足题目的 连续子数组 要求。
     * 转移方程： 若 dp[i-1] ≤ 0 ，说明 dp[i - 1] 对 dp[i] 产生负贡献，即 dp[i-1] + nums[i] 还不如 nums[i] 本身大。
     * 当 dp[i - 1] > 0 时：执行 dp[i] = dp[i-1] + nums[i]；
     * 当 dp[i - 1] ≤ 0 时：执行 dp[i] = nums[i]；
     * 初始状态： dp[0]=nums[0]，即以 nums[0] 结尾的连续子数组最大和为 nums[0] 。
     * 返回值： 返回 dpdp 列表中的最大值，代表全局最大值
     *
     * 时间复杂度 O(N)： 线性遍历数组 numsnums 即可获得结果，使用 O(N)O(N) 时间。
     * 空间复杂度 O(1)： 使用常数大小的额外空间。
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }

    public static void main (String[] args){
        int[] sums = {-2, 1, -3, 4, -1, 2, 1, -5,};
        System.out.println(maxSubArray(sums));
    }
}
