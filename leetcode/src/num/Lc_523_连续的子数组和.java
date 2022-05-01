/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

import java.util.HashMap;
import java.util.Map;

/**
 * 连续子数组的最大和
 * 给定一个包含 非负数 的数组和一个目标 整数 k，编写一个函数来判断该数组是否含有连续的子数组，
 * 其大小至少为 2，且总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。
 * 示例 1：
 * 输入：[23,2,4,6,7], k = 6 输出：True
 * 解释：[2,4] 是一个大小为 2 的子数组，并且和为 6。
 * 示例 2：
 * 输入：[23,2,6,4,7], k = 6 输出：True
 * 解释：[23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
 *
 * https://leetcode-cn.com/problems/continuous-subarray-sum/solution/lian-xu-de-zi-shu-zu-he-by-leetcode/
 *
 * 时间复杂度：O(N)
 * 空间复杂度：O(min(n,k))
 *
 * @author luweiliang
 * @created 2020/6/15
 */
public class Lc_523_连续的子数组和 {
    public static boolean checkSubarraySum2(int[] nums, int k){
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // 键为 preSum % k, 值为索引，当然要特殊处理k == 0的情况
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int temp = k == 0 ? sum : sum % k;
            if(map.containsKey(temp)){ // 出现相同的键，如果子数组长度少于2， 不需要更新值。
                if(i - map.get(temp) > 1) { // 子数组要求长度至少为2。
                    return true;
                }
                continue;
            }
            map.put(temp, i);
        }
        return false;
    }

    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {   //出现相同的键，如果子数组长度少于2， 不需要更新值。
                if (i - map.get(sum) > 1) //子数组要求长度至少为2。
                    return true;
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main (String[] args){
        int[] sums = {23, 2, 4, 6, 7};
        System.out.println(checkSubarraySum2(sums, 6));
    }
}
