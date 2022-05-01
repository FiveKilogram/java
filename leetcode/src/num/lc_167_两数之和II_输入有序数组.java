/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

/**
 * 两数之和II_输入有序数组
 * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/solution/shuang-zhi-zhen-on-shi-jian-fu-za-du-by-cyc2018/
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * @author luweiliang
 * @created 2020/3/30
 */
public class lc_167_两数之和II_输入有序数组 {

    /**
     * 输入有序数组，数组有序第一考虑就是二分法，性能最优
     * @param sums
     * @param target
     * @return
     */
    public static int[] twoSum (int[] sums, int target){
        if (sums == null || sums.length < 2) return new int[]{-1, -1};

        int l = 0, r = sums.length - 1;
        while(l < r) {
            int sum = sums[l] + sums[r];
            if (sum == target) {
                return new int[] {l + 1, r + 1};
            } else if (sum < target) {
                l ++;
            } else {
                r --;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        for (int i = 0 ; i < result.length; i ++){
            System.out.println(result[i]);
        }
    }
}
