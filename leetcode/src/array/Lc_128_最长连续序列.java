/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2] 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 复杂度为 O(n)
 * 空间复杂度：O(n)
 * @author luweiliang
 * @created 2020/5/23
 */
public class Lc_128_最长连续序列 {


    /**
     * 优先用这个方法
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;

        //排序处理
        Arrays.sort(nums);

        //对排好序的结果集进行一个个 +1 的操作判断
        int maxLen = 1, startIdx = 0, repeatCnt = 0;
        for (int i = 1; i < nums.length; i ++) {
            //如果丹铅元素和前一个元素是连续的话，则继续循环
            if (nums[i] == (nums[i - 1] + 1)) {
                continue;
            }
            //如果当前元素和前一个元素相等，退出当前循环，继续下一轮循环
            if (nums[i] == nums[i - 1]) {
                repeatCnt ++;
                continue;
            }

            //能来到这里，说明当前元素和前一个元素是不连续的，并且不相等，说明连续断层了，就可以开始计算长度了
            maxLen = Math.max(maxLen, i - startIdx - repeatCnt);

            //指针移动到当前位置，并且重复数清零
            startIdx = i;
            repeatCnt = 0;

        }
        return  Math.max(maxLen, nums.length - startIdx - repeatCnt);
    }

    /**
     * 当考虑 n 的时候，我们先看一看 n - 1 是否存在，如果不存在，
     * 那么从 n 开始就是我们需要考虑的序列了。否则的话，直接跳过
     *
     * 这个时间复杂度的话就是 O(n) 了。虽然 for 循环里套了 while 循环，但每个元素其实最多也就是被访问两次。
     * 比如极端情况 987654 ，98765 循环的时候都不会进入 while 循环，只有到 4 的时候才进入了 while 循环。
     * 所以总共的话， 98765 也只会被访问两次，所以时间复杂度就是 O(n) 了
     * https://leetcode-cn.com/problems/longest-consecutive-sequence/solution/java-pai-xu-ji-he-ha-xi-biao-bing-cha-ji-by-lzhlyl/
     * @param nums
     * @return
     */
    public static int longestConsecutive1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        //定义一个set集合，把数据加入到set集合中
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        //最长的变量
        int longest = 0;
        for (int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            //n - 1 是否存在，如果num - 1在set里面的话，说明这个num并没有和前面的数字断层，则不是这个子窜的第一个元素
            if (set.contains(num - 1)){
                continue;
            }
            //能到下面来的，说明num 和 num -1断层，也就是说明num是子窜的第一个元素，那就一直累加看看有多长；
            int count = 0;
            while (set.contains(num)){
                count ++;
                num += 1;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }


    public static int longestConsecutive2(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (Integer num : nums) {
            numsSet.add(num);
        }
        int longest = 0;
        for (Integer num : nums) {
            if (numsSet.remove(num)) {
                // 向当前元素的左边搜索,eg: 当前为100, 搜索：99，98，97,...
                int currentLongest = 1;
                int current = num;
                while (numsSet.remove(current - 1)) current--;
                currentLongest += (num - current);
                // 向当前元素的右边搜索,eg: 当前为100, 搜索：101，102，103,...
                current = num;
                while(numsSet.remove(current + 1)) current++;
                currentLongest += (current - num);
                // 搜索完后更新longest.
                longest = Math.max(longest, currentLongest);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
//        int[] sums = {100, 4, 200, 1, 3, 2};
        int[] sums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};

        System.out.println(longestConsecutive(sums));
        System.out.println(longestConsecutive1(sums));
    }
}
