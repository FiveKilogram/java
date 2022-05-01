/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 * 题目数据保证答案符合 32 位带符号整数范围。
 * 示例 1：
 * 输入：s = "rabbbit", t = "rabbit"
 * 输出：3
 * 解释：
 * 如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * rabbbit
 * ^^^^ ^^
 * rabbbit
 * ^^ ^^^^
 * rabbbit
 * ^^^ ^^^
 *
 * 示例 2：
 * 输入：s = "babgbag", t = "bag"
 * 输出：5
 * 解释：
 * 如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。
 * (上箭头符号 ^ 表示选取的字母)
 * babgbag
 * ^^ ^
 * babgbag
 * ^^    ^
 * babgbag
 ^    ^^
 * babgbag
 * ^  ^^
 * babgbag
 * ^^^
 * https://leetcode-cn.com/problems/distinct-subsequences/
 * https://leetcode-cn.com/problems/distinct-subsequences/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-27/
 * https://blog.csdn.net/zy854816286/article/details/104991660
 * @author luweiliang
 * @created 2020/5/19
 */
public class Lc_115_不同的子序列_计算在S的子序列中T出现的次数 {

    public static int numDistinct(String s, String t){
        if ((s == null && t == null) || s.equals("") && t.equals("")) return 1;
        //T 是空串，选法就是 1 种
        if (s != null && t == null) return 1;
        //S 是空串，选法是 0 种
        if (s == null && t != null) return 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= s.length(); i ++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i<= t.length(); i ++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= s.length(); i ++) {
            for (int j = 1; j <= t.length(); j ++) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    /**
     * https://leetcode-cn.com/problems/distinct-subsequences/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-27/
     * @param s
     * @param t
     * @return
     */
    public static  int numDistinct1(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();
        int[][] dp = new int[s_len + 1][t_len + 1];
        //当 T 为空串时，所有的 s 对应于 1
        for (int i = 0; i <= s_len; i++) {
            dp[i][t_len] = 1;
        }

        //倒着进行，T 每次增加一个字母
        for (int t_i = t_len - 1; t_i >= 0; t_i--) {
            dp[s_len][t_i] = 0; // 这句可以省去，因为默认值是 0
            //倒着进行，S 每次增加一个字母
            for (int s_i = s_len - 1; s_i >= 0; s_i--) {
                //如果当前字母相等
                if (t.charAt(t_i) == s.charAt(s_i)) {
                    //对应于两种情况，选择当前字母和不选择当前字母
                    dp[s_i][t_i] = dp[s_i + 1][t_i + 1] + dp[s_i + 1][t_i];
                    //如果当前字母不相等
                } else {
                    dp[s_i][t_i] = dp[s_i + 1][t_i];
                }
            }
        }
        return dp[0][0];
    }

    public static int numDistinct2(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();
        int[]dp = new int[s_len + 1];
        for (int i = 0; i <= s_len; i++) {
            dp[i] = 1;
        }
        //倒着进行，T 每次增加一个字母
        for (int t_i = t_len - 1; t_i >= 0; t_i--) {
            int pre = dp[s_len];
            dp[s_len] = 0;
            //倒着进行，S 每次增加一个字母
            for (int s_i = s_len - 1; s_i >= 0; s_i--) {
                int temp = dp[s_i];
                if (t.charAt(t_i) == s.charAt(s_i)) {
                    dp[s_i] = dp[s_i + 1] + pre;
                } else {
                    dp[s_i] = dp[s_i + 1];
                }
                pre = temp;
            }
        }
        return dp[0];
    }

    public static int numDistinct3(String s, String t) {
        int s_len = s.length();
        int t_len = t.length();
        int[] dp = new int[s_len + 1];
        for (int i = 0; i <= s_len; i++) {
            dp[i] = 1;
        }
        for (int t_i = 1; t_i <= t_len; t_i++) {
            int pre = dp[0];
            dp[0] = 0;
            for (int s_i = 1; s_i <= s_len; s_i++) {
                int temp = dp[s_i];
                if (t.charAt(t_i - 1) == s.charAt(s_i - 1)) {
                    dp[s_i] = dp[s_i - 1] + pre;
                } else {
                    dp[s_i] = dp[s_i - 1];
                }
                pre = temp;
            }
        }
        return dp[s_len];
    }

    public static void main(String[] args){
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(numDistinct(s, t));
        System.out.println(numDistinct1(s, t));
        System.out.println(numDistinct2(s, t));
        System.out.println(numDistinct3(s, t));
    }
}
