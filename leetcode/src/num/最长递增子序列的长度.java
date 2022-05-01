/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;


/**
 * 给定一个长度为N的数组A，计算A的最长单调递增的子序列(不一定是连续的)的长度
 * 示例 1:
 * 输入: [5, 6, 7, 1, 2, 8] 输出: 4
 * 解释: 最长单调递增的子序列(不一定是连续的) [5, 6, 7,  8];
 *
 * @author luweiliang
 * @created 2020/5/21
 */
public class 最长递增子序列的长度 {

    public static int findNumberOfLIS(int[] nums) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i ++) {
            boolean big = false;
            if (nums[i] > max) {
                max = nums[i];
                big = true;
//                System.out.println(max);
            }
            if (big) {
                dp[i] = dp[i - 1] + 1;
//                System.out.println(dp[i]);
            } else {
                dp[i] = dp[i - 1];
//                System.out.println(dp[i]);
            }

        }
        return dp[nums.length - 1];
    }

    public static void main (String[] args){
        int[] sums = {2,1,5,3,6,4,8,9,7};
        System.out.println(findNumberOfLIS(sums));
    }
}
