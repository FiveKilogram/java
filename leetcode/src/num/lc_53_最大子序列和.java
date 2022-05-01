/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

/**
 * 最大子序列和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例: 输入: [-2, 1, -3, 4, -1, 2, 1, -5, 4],
 * 输出: 6
 * 解释: 连续子数组 [4, -1, 2, 1] 的和最大，为 6。
 * 进阶:如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * https://leetcode-cn.com/problems/maximum-subarray/solution/zhen-zheng-li-jie-on-jie-fa-ben-zhi-shi-dong-tai-g/
 * 时间复杂度 O(n)
 * 时间复杂度 O(1)
 * @author luweiliang
 * @created 2020/3/29
 */
public class lc_53_最大子序列和 {

    /**
     * 我们要记住动态规划的解题四步骤：
     * 定义子问题
     * 写出子问题的递推关系
     * 确定 DP 数组的计算顺序
     * dp[i]:以nums[i]结尾的最大子序列和
     * 转移方程：dp[i]=max((dp[i-1]+nums[i]),nums[i]).
     * 用sum替换dp[i],去掉辅助数组。
     * 空间优化（可选）
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums){
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int dp = nums[0];
        int res = dp;
        for (int i = 1; i < len; i ++) {
            dp = Math.max(nums[i], dp + nums[i]);
            res = Math.max(res, dp);
        }
        return res;
    }

    public static int maxSubArray2(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int max = nums[0];    // 全局最大值
        int subMax = nums[0];  // 前一个子组合的最大值,状态压缩
        for (int i = 1; i < nums.length; i++) {
            if (subMax > 0) {
                // 前一个子组合最大值大于0，正增益
                subMax = subMax + nums[i];
            } else {
                // 前一个子组合最大值小于0，抛弃前面的结果
                subMax = nums[i];
            }
            // 计算全局最大值
            max = Math.max(max, subMax);
        }
        return max;
    }

    /**
     * 动态规划：
     * dp[i]:以nums[i]结尾的最大子序列和
     * 转移方程：dp[i]=max((dp[i-1]+nums[i]),nums[i]).
     * 用sum替换dp[i],去掉辅助数组。
     * @param nums
     * @return
     */
    public static int maxSubArray4(int[] nums) {
        //sum:以nums[i]结尾的最大子序列和
        //动态规划：dp[i]=max(num[i],dp[i-1])
        int sum = nums[0], max = nums[0];
        for (int i=1 ;i<nums.length;i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }




    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static int maxSubArray1(int[] nums) {
        int sum = 0; // 记录当前的和
        int res = Integer.MIN_VALUE;
        for (int n : nums) {
            // 如果累加到小于0了，就清零重新累加
            if (sum < 0) {
                sum = 0;
            }
            sum += n; // 累加
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args){
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(array));
        System.out.println(maxSubArray1(array));
        System.out.println(maxSubArray2(array));
    }
}
