/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 示例 1:
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *    从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
 * 示例 2:
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * https://leetcode-cn.com/problems/jump-game-ii/
 * @author luweiliang
 * @created 2020/5/22
 */
public class Lc_45_跳跃游戏_II {


    /**
     * 动态规划
     * https://leetcode-cn.com/problems/jump-game-ii/solution/dong-tai-gui-hua-jie-fa-by-alchemist-5r/
     * 时间复杂度：O(n)，其中 nn 是数组长度。
     * 空间复杂度：O(1)。
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {

        //初始化一个数组
        int[] dp = new int[nums.length];

        //第一个值为0
        dp[0] = 0;
        //以后的值为一个特别大的值
        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums.length + 1;
        }

        //从第一个元素开始，给它以后每个能跳到的位置的值做优化，
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i]; j++ ) {
                if (i + j >= nums.length) {
                    //到达最后一个元素的时候直接退出
                    return dp[dp.length - 1];
                }
                //被优化的值，就是当前后面的值的value + 它当前的value+1，在这两个值中取最小值来更新给dp[i + j]
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        //最后的结果就是要求出来的结果
        return dp[dp.length - 1];
    }

    /**
     * 贪心算法
     * https://leetcode-cn.com/problems/jump-game-ii/solution/dai-ma-sui-xiang-lu-dai-ni-xue-tou-tan-x-yh58/
     * @param nums
     * @return
     */
    public static int jump1(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        //记录跳跃的次数
        int count=0;
        //当前的覆盖最大区域
        int curDistance = 0;
        //最大的覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            maxDistance = Math.max(maxDistance,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if (maxDistance>=nums.length-1){
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if (i == curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }

    /**
     * 贪心算法
     * 在当前可到达的最远位置范围内查找下一次可到达的最远位置
     * 直到到达或超过数组最后位置
     * https://leetcode-cn.com/problems/jump-game-ii/solution/45-tiao-yue-you-xi-ii-by-huyii-r8jw/
     * @param nums
     * @return
     */
    public static int jump2(int[] nums) {
        //记录跳跃的次数
        int count = 0;
        // 下一次可到达的最远位置
        int nextMax = 0;
        // 当前可到达的最远位置
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 在当前可到达的最远位置范围内查找下一次可到达的最远位置
            nextMax = Math.max(nextMax, i + nums[i]);

//            //优化点： 下一次跳跃可以到达终点了，就提前结束。这里有问题
//            if (nextMax >= nums.length - 1) {
//                return count ++;
//            }

            // 如果在当前可到达最远范围内查找完毕，去下一个可到达的最远位置继续跳
            if (i == max) {
                count ++;
                max = nextMax;
            }
        }
        return count;
    }

    /**
     * 解题思路
     * 此题目标是使用最少的跳跃次数到达最后一个位置，也就是求出达到最后一个位置的最短路径。
     * 先标记到数组的最后一个位置，我们需要从前往后遍历找到能抵达该位置的所有位置，找到的所有位置里，能第一个抵达指定位置的（也就是下标最小的元素）便是能抵达指定位置的最短路径。
     * 接下来，将我们找到的最小位置标记为目标位置，再次重复上述步骤，直到更新到数组的第一个元素蛮久的得到了最短的路径。
     *
     * https://leetcode-cn.com/problems/jump-game-ii/solution/by-admiring-williamsebb-6t3i/
     * @param nums
     * @return
     */
    public static int jump3(int[] nums) {
        int position=nums.length-1;//需要到达的位置的下标
        int step=0;//需要的最小跳跃次数
        while(position!=0){
            //遍历能到达指定位置的最小下标，也就是第一个能到达指定位置的数的下标
            for(int i=0;i<position;i++){
                if(nums[i]>=position-i){
                    position=i;//更新需要到达位置的下标
                    step++;//更新步数
                    break;
                }
            }
        }
        return step;
    }

    public static void main(String[] args) {

        int[] nums = {2,3,0,1,4};
        System.out.println(jump(nums));
        System.out.println(jump1(nums));
        System.out.println(jump2(nums));
        System.out.println(jump3(nums));
    }
}
