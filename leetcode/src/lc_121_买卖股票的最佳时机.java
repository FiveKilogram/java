/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 * 注意：你不能在买入股票前卖出股票。
 * 示例 1: 输入: [7,1,5,3,6,4] 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2: 输入: [7,6,4,3,1] 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * 时间复杂度 O(N)
 * 空间复杂度 O(1)
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/solution/hen-jing-dian-de-tan-xin-suan-fa-by-pendygg/
 * @author luweiliang
 * @created 2020/3/27
 */
public class lc_121_买卖股票的最佳时机 {

    /**
     * 贪心算法，
     * 从左向右，维护一个最小值low，与每一天的股票价格做差，差最大的为答案
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices){
        if (prices.length == 0) return 0;

        int maxPrece = 0;
        int low = Integer.MAX_VALUE;

        for (int p : prices) {
            if (p < low){
                low = p;
            }
            maxPrece = Math.max(maxPrece, p - low);
        }
        return maxPrece;
    }

    /**
     * 动态规划
     * 动态规划的5 个步骤：
     * 1、设定状态
     * 这道题其实是一个典型的二维 dp 问题。“动态规划”用于多阶段最优化问题的求解。这里天数代表每个阶段，即一天一天看，设置为第一维。为了消除后效性（前面的状态确定下来以后不会因为后面状态而更改），将当天是否持股设置为第二维的状态。于是：
     * 状态 dp[i][j] 表示：在索引为 i 的这一天，用户手上持股状态为 j 所获得的最大利润。
     * 说明：
     * j 只有 2 个值：0 表示不持股（特指卖出股票以后的不持股状态），1 表示持股。
     * “用户手上不持股”不代表用户一定在索引为 i 的这一天把股票抛售了；
     * 2、思考状态转移方程
     * dp[i][0] 怎样转移？
     * dp[i - 1][0] ：当然可以从昨天不持股转移过来，表示从昨天到今天什么都不操作，这一点是显然的；
     * dp[i - 1][1] + prices[i]：昨天持股，就在索引为 i 的这一天，我卖出了股票，状态由 1 变成了 0，此时卖出股票，因此加上这一天的股价。
     * 综上：dp[i][0] = max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
     * dp[i][1] 怎样转移？
     * dp[i - 1][1] ：昨天持股，今天什么都不操作，当然可以从昨天持股转移过来，这一点是显然的；
     * -prices[i]：注意：状态 1 不能由状态 0 来，因为事实上，状态 0 特指：“卖出股票以后不持有股票的状态”，请注意这个状态和“没有进行过任何一次交易的不持有股票的状态”的区别。
     * 因此，-prices[i] 就表示，在索引为 i 的这一天，执行买入操作得到的收益。注意：因为题目只允许一次交易，因此不能加上 dp[i - 1][0]。
     * 综上：dp[i][1] = max(dp[i - 1][1], -prices[i]);
     * 3、考虑初始值
     * 第 0 天不持股，显然 dp[0][0] = 0；
     * 第 0 天持股，显然dp[0][1] = -prices[0]。
     * 4、考虑输出
     * 从状态转移方程可以看出，每一天的状态都考虑了之前的状态。在只发生一次交易的情况下，持有这支股票一定不能使我们获得最大利润。
     * 因此输出是 dp[len - 1][0]，不可能是持股的状态 dp[len - 1][1]，
     *
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：不进行任何操作
        // 1：用户执行了一次买入操作
        // 2：用户执行了一次卖出操作

        // 状态转移方程：
        // dp[i][0] 永远等于 0
        // dp[i][1] = max(dp[i - 1][1], dp[i - 1][0] - prices[i])
        // dp[i][2] = max(dp[i - 1][2], dp[i - 1][1] + prices[i])


        // 注意：如果是 `[7, 6, 5, 4, 3]` 这种波动，应该不交易，
        // 因此输出是：max(dp[len - 1][0], dp[len - 1][2])

        int[][] dp = new int[len][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        // 这里状态 2 不应该有值，设置为 0 不影响正确性
        dp[0][2] = 0;
        for (int i = 1; i < len; i++) {
            // 可以不显式赋值，因为 int 的初值就是 0
            dp[i][0] = 0;
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][2]);
    }

    /**
     * 时间复杂度：O(N)
     * 空间复杂度：O(1)状态压缩以后相当于只用了 2 个变量。
     * 很有意思的是，可以将此时的数组 dp 语义化，dp[1] = Math.max(dp[1], -prices[i]);
     * 等价于 dp[1] = Math.min(dp[1], prices[i]); 其实就是“参考代码 2” 中的 minVal，dp[0] 等价于 “参考代码 2” 中的 res。
     * @param prices
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int[] dp = new int[2];
        dp[0] = 0;
        dp[1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[0] = Math.max(dp[0], dp[1] + prices[i]);
            dp[1] = Math.max(dp[1], -prices[i]);
        }
        return dp[0];
    }


    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        int[] array1 = {7,6,4,3,1};
        System.out.println(maxProfit(array1));
    }
}
