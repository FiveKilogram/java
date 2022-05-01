/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

import java.util.Arrays;

/**
 * 给定一个字符串 S，计算 S 的不同非空子序列的个数。
 * 示例 1：
 * 输入："abc"
 * 输出：7
 * 解释：7 个不同的子序列分别是 "a", "b", "c", "ab", "ac", "bc", 以及 "abc"。
 *
 * 示例 2：
 * 输入："aba"
 * 输出：6
 * 解释：6 个不同的子序列分别是 "a", "b", "ab", "ba", "aa" 以及 "aba"。
 *
 * 示例 3：
 * 输入："aaa"
 * 输出：3
 * 解释：3 个不同的子序列分别是 "a", "aa" 以及 "aaa"。
 * 链接：https://leetcode-cn.com/problems/distinct-subsequences-ii/solution/bu-tong-de-zi-xu-lie-ii-by-leetcode/
 *
 * @author luweiliang
 * @created 2021/3/12
 */
public class Lc_940_不同的子序列_II {
    /**
     * 时间复杂度：O(N)，其中, where NN 是字符串 S 的长度。
     * 空间复杂度：O(N)，也可以将空间复杂度优化到 O(1)O(1)。
     * @param S
     * @return
     */
    public static int distinctSubseqII(String S) {
        int MOD = 1_000_000_007;
        int N = S.length();
        int[] dp = new int[N+1];
        dp[0] = 1;

        int[] last = new int[26];
        Arrays.fill(last, -1);

        for (int i = 0; i < N; ++i) {
            int x = S.charAt(i) - 'a';
            dp[i+1] = dp[i] * 2 % MOD;
            if (last[x] >= 0)
                dp[i+1] -= dp[last[x]];
            dp[i+1] %= MOD;
            last[x] = i;
        }

        dp[N]--;
        if (dp[N] < 0) dp[N] += MOD;
        return dp[N];
    }

    public static void main(String[] args){
        String s = "abc";
        System.out.println(distinctSubseqII(s));
    }
}
