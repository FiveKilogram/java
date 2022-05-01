/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */

/**
 * Lc_64_最短路径和
 * 给定一个矩阵m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有路径中最小的路径和
 * 例子：给定m如下：
 * 1 3 5 9
 * 8 1 3 4
 * 5 0 6 1
 * 8 8 4 0
 * 路径1,3,1,0,6,1,0是所有路径中路径和最小的，所以返回12。
 * 
 * @author luweiliang
 * @created 2020/6/10
 */
public class Lc_64_最短路径和 {

    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * 说明：每次只能向下或者向右移动一步。
     *
     * 思路：
     * 使用动态规划，定义 dp[M][N] , M ,N 分别代表矩阵的行和列数 dp[i][j] 表示从左上角到矩阵（i，j）位置是的最短路径和。
     * 则可知 到（i，j）位置有两种情况：1）由（i-1，j）向下走，2）由（i，j-1）向右走，
     * 所以dp[i][j]=Math.min（dp[i-1][j],dp[i][j-1]）+m[i][j];对于dp[0][j] 只能由 dp[0][j-1] 向右走，
     * dp[i][0] 只能由 dp[i-1][0] 向下走。所以 dp[0][j]=dp[0][j-1]+m[0][j], dp[i][0]=dp[i-1][0]+m[i][0].
     *
     * 时间复杂度：O(mn)
     * 空间复杂度：O(mn)
     *
     * @param arr
     * @return
     */
    public static int shortestRoad(int arr[][]) {
        int dp[][] = new int[arr.length][arr[0].length];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < arr.length; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0];
            // 第一列只能由上向下
        }
        for (int j = 1; j < arr[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + arr[0][j];
            // 第一行只能由左向右
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + arr[i][j];
            }
        }
        return dp[arr.length - 1][arr[0].length - 1];
    }

    /**
     * 思路：
     * 解法1中使用dp数组的空间大小为M*N，其实可以对dp数组的空间压缩至N，定义大小为N的dp数组，
     * 对于第一行，dp[i]=dp[i-1]+m[0][i],在求第二行中的 dp[i] 时可以覆盖第一行 dp[i] ,
     * 第二行dp[i]=Math.min（dp[i],dp[i-1]）+m[i][j]。
     * 
     * @param arr
     * @return
     */
    public static int shortestRoad1(int arr[][]) {
        int dp[] = new int[arr[0].length];
        dp[0] = arr[0][0];
        for (int j = 1; j < arr[0].length; j++) {
            dp[j] = dp[j - 1] + arr[0][j];
            // 求出第一行的dp
        }
        for (int i = 1; i < arr.length; i++) {
            dp[0] = arr[i][0] + dp[0];
            // dp[0]代表每一行最左边的dp，
            // 后一行的dp覆盖前一行的dp
            for (int j = 1; j < arr[0].length; j++) {
                dp[j] = Math.min(dp[j - 1] + arr[i][j], dp[j] + arr[i][j]);
            }
        }
        return dp[arr[0].length - 1];
    }

    public static void main(String[] args) {
//        int[][] matrix = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        int[][] matrix = { { 1,3,1 }, { 1,5,1 }, { 4,2,1 }};
        System.out.println(shortestRoad(matrix));
        System.out.println(shortestRoad1(matrix));
    }
}
