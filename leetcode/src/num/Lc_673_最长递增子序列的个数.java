/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

import java.util.Arrays;

/**
 * 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 链接：https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence
 * @author luweiliang
 * @created 2020/5/21
 */
public class Lc_673_最长递增子序列的个数 {

    /**
     * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/qiu-zui-chang-di-zeng-zi-xu-lie-de-ge-shu-by-qiyue/
     * i=0时，比它小的没有，dp[0]=1,count[0]=1
     * i=1时，nums[0]比它小，dp[1]=2,count[1]=1
     * i=2时，nums[0]和nums[1]都比它小，最终dp[2]=dp[1]+1=3,count[2]=1
     * i=3时，nums[0]和nums[1]都比它小，最终dp[3]=dp[1]+1=3,count[3]=1
     * i=4时，前面的数都比它小，j=2时，dp[4]=dp[2]+1=4,count[4]=1；重点来了: j=3时，因为dp[3]+1=4==dp[4] 说明之前已经存在一种递增序列长度为4的情况了（1,2,4,5），
     * 而这个时候又有另一种组合跟nums[4]组合，可以形成长度为4的递增序列（1,2,3,5），因此count[4]就要更新了count[4]=count[4]+count[3]=2
     * 后面依次类推。
     *
     * @param nums
     * @return
     */
    public static int findNumberOfLIS(int[] nums) {

        int len = nums.length;
        if (len == 0)
            return 0;
        int dp[] = new int[len];
        int count[] = new int[len];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i])
                        count[i] += count[j];
                }
            }
            max = Math.max(max, dp[i]);//找出最长递增子序列的长度是多少
        }
        int ans = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] == max) {
                ans += count[i];
            }
        }
        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/solution/dong-tai-gui-hua-javachao-xiang-xi-ban-b-rdpu/
     *
     * 一、确定状态
     * 沿用子问题最长递增子序列中的状态，dp[i]=以nums[i]结尾的递增子序列长度。
     * 但本次问题还需要记录个数，故我们可以维护一个count数组，用来记录以nums[i]结尾的递增子序列的个数。
     *
     * 二、状态转移方程
     * 在子问题最长递增子序列中的状态转移方程，对于每一个nums[i]，从头开始遍历，当nums[j]<nums[i]时，更新dp[i]，维护最长上升子序列。
     * 而本题主要考虑的是count数组的状态转移方程
     * 首先，我们的考虑前提是在nums[j]<nums[i]，成立下而当前提条件成立时，我们有：
     * 第一种情况，当前nums[j]结尾的子数组加上nums[i]后，长度大于原先以nums[i]结尾的数组，即dp[j]+1>dp[i]，这可以说明当前是第一次找到以nums[i]为结尾的最长子序列（数组），故此时dp[i]=dp[j]+1。
     * --
     * 而此时以nums[j]为结尾的最长子序列个数已经维护在count[j]中，我们由分析可以知道，不论count[j]有多少个，
     * 加上一个nums[i]并不会改变其数量，故可以分析知：count[i]=count[j]
     * 第二种情况，当前nums[j]结尾的子数组加上nums[i]后，长度等于原先以nums[i]结尾的数组，即dp[j]+1==dp[i]，这说明同样长度的、以nums[i]为结尾的子数组已经遇到过了，说明此时dp[i]并不会改变，和之前遇到的情况一样，同样是以nms[i]为结尾的子数组长度。
     * --
     * 但count会改变，因为此时以nums[i]为结尾、长度同样的子序列已经有过了，这次是第二次遇到。那么按照第一种情况分析，子序列是以nums[j]为结尾的子序列加上nums[i]，而此时我们必须考虑nums[j]为结尾的同长子序列有多少个。故我们将以nums[j]为结尾的同长上升子序列加到以nums[i]为结尾的上升子序列个数中，即count[i]+=count[j]
     * --
     * 假设这里的意思是,假设序列为[1,2,4,3,5]
     * 而当i=4时，dp[i]<dp[j]+1的情况出现在j=2
     * dp[j]+1==dp[i]的情况出现在j=3，而当前count[i]=count[j]
     * 所以此时我们必须要在count[i]=count[j]（j=3)的基础上加上j=4时的count[j]
     * 故子序列[1,2,4,3,5]有2个最长子序列，分别是[1,2,4,5]和[1,2,3,5]
     * 分解开两步即count[4]=count[3]+count[2]
     *
     * 三、初始值
     * 当数组长度=1时，也是一个子序列，而每个字符都必有一个子序列，即dp[i]=1，count[i]=1
     *
     * 四、优化
     * 可以了解一下线段树，可将时间复杂度优化至O(N*log(N))
     *
     * @param nums
     * @return
     */
    public static int findNumberOfLIS1(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        int[] dp = new int[len];
        // count[]是用于记录第i位为结尾时数组的递增子序列的个数
        int[] count = new int[len];
        // max 用于记录最大长度
        int max = 0;
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            count[i] = 1;
            // 这里沿用了最长递增子序列的思路
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 这里的判断条件是,当dp[i]<dp[j]+1时,意味着找到了以nums[i]结尾的目前最长的子序列,那么此时dp[i]=dp[j]+1
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        // 这里的意思是,假设序列为[1,2,4,3,5,7]
                        // 而当i=5,j=4时,此时子序列[1,2,4,3,5]有2个最长子序列
                        // 分别是[1,2,4,5]和[1,2,3,5]
                        // 那么只是加上一个7,不影响最长子序列的个数
                        count[i] = count[j];
                        // 这里的意思是:子序列加上nums[i]之后与之前记录的最长序列dp[i]相等
                        // 就说明除了当前的dp[j]之外还有其他长度的子序列
                        // 此时需要记录数量和
                    } else if (dp[i] == dp[j] + 1) {
                        // 这里的意思是,当前以nums[i]为结尾的序列是由以nums[j]结尾的子序列加上nums[i]
                        // 而我们必须考虑,以nums[j]为结尾、且同样长度的序列有多少种
                        // 所以我们将以nums[j]为结尾的同长上升子序列的个数加到当前以nums[i]为结尾的个数中
                        // 即可得到以nums[i]为结尾的同长子序列个数
                        count[i] += count[j];
                    }
                }
            }
            max = Math.max(dp[i], max);
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (dp[i] == max) {
                res += count[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 4, 7};
        int[] nums = {2, 2, 2, 2, 2};
       int res =  findNumberOfLIS(nums);
//       int res =  findNumberOfLIS1(nums);
        System.out.println(res);
    }
}
