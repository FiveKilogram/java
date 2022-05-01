/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 爬楼梯,假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？注意：给定 n 是一个正整数。
 * 青蛙跳台阶问题, 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/solution/dong-tai-gui-hua-by-ml-zimingmeng/
 * @author luweiliang
 * @created 2020/3/27
 */
public class lc_70_爬楼梯 {

    /**
     * 动态规划
     * 动态转移方程：dp[i] = dp[i -1] + dp[i - 2];
     * 最优子结构：[i - 1]，[i - 2]
     * 边界：dp[1] = 1; dp[2] = 2;
     *
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        if (n < 1) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 斐波那契数
     * @param n
     * @return
     */
    public static int climbStairs1(int n){
        if (n == 1) return 1;
        int a = 1;
        int b = 2;
        for (int i = 3; i <= n; i ++) {
            int c = a + b ;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args){
        System.out.println(climbStairs(7));
        System.out.println(climbStairs1(7));
    }
}
