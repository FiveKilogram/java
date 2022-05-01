/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

import java.util.ArrayList;
import java.util.List;

/**
 * 在这里编写类的功能描述
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 例如，给定三角形：
 * [
 *       [2],
 *      [3,4],
 *     [6,5,7],
 *    [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 说明：如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * @author luweiliang
 * @created 2020/5/19
 */
public class Lc_120_三角形最小路径和 {

    /**
     * 自顶向下
     * 1、状态定义：dp[i][j]表示包含第i行第j列元素的最小路径和
     * 2、状态分析
     *    a.初始化：
     *      dp[0][0]=triangle[0][0]
     *    b.常规：
     *      triangle[i][j]一定会经过triangle[i-1][j]或者triangle[i-1][j-1],
     *      所以状态dp[i][j]一定等于dp[i-1][j]或者dp[i-1][j-1]的最小值+triangle[i][j]
     *    c.特殊：
     *      triangle[i][0]没有左上角 只能从triangle[i-1][j]经过
     *      triangle[i][row[0].length]没有上面 只能从triangle[i-1][j-1]经过
     * 3、转换方程：dp[i][j]=min(dp[i-1][j],dp[i-1][j-1])+triangle[i][j]
     *
     * 时间复杂度：O(n^2) （n 为三角形的总行数）
     * 空间复杂度：O(n) （n 为三角形的总行数）
     * @param triangle
     * @return
     */
    public static int minimumTotal(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // dp最大长度==triangle底边长度
        // 题意：只使用 O(n) 的额外空间（n 为三角形的总行数）
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);

        // prev暂存dp[i-1][j-1],cur暂存dp[i-1][j]
        int prev = 0, cur;
        for (int i = 1; i < triangle.size(); i++) {
            //对每一行的元素进行推导
            List<Integer> rows = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                cur = dp[j];
                if (j == 0) {
                    // 最左端特殊处理
                    dp[j] = cur + rows.get(j);
                } else if (j == i) {
                    // 最右端特殊处理
                    dp[j] = prev + rows.get(j);
                } else {
                    dp[j] = Math.min(cur, prev) + rows.get(j);
                }
                prev = cur;
            }
        }

        int res = Integer.MAX_VALUE;
        // dp最后一行记录了最小路径
        for (int i = 0; i < triangle.size(); i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> sums = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(3);
        list4.add(8);
        sums.add(list1);
        sums.add(list2);
        sums.add(list3);
        sums.add(list4);
        System.out.println(sums.toString());
        System.out.println(minimumTotal(sums));
    }
}
