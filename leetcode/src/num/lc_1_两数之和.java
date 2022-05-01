/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * @author luweiliang
 * @created 2019/8/26
 */
public class lc_1_两数之和 {

    public static int[] twoSum (int [] nums, int target) {
        for (int i = 0; i < nums.length; i ++) {
            for (int j = i + 1; j < nums.length; j ++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i + 1, j + 1};
                }
            }
        }
        return new int[] {-1, -1};
    }

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1 (int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i ++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }

    public static int[] twoSum2(int [] array , int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i ++) {
            int item = target - array[i];
            if (map.containsKey(item)) {
                return new int [] {map.get(item) + 1, i + 1};
            }
            map.put(array[i], i);
        }
        return new int [] {-1, -1};
    }

    /**
     * 两数之和，要求找出两数之和的全部组合
     *
     * 我们随意选择一个特定值，比如13，要求找出两数之和等于13的全部组合；
     * 5, 12, 6, 3, 9, 2, 1, 7
     * 比如13， 12 + 1 = 13，6 + 7 = 13
     * 输出【1， 6】【2， 7】
     * @param array
     * @param target
     * @return
     */
    public static List<List<Integer>> twoSum3(int [] array , int target){
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < array.length; i ++) {
            int item = target - array[i];
            if (map.containsKey(item)) {
                list.add(Arrays.asList(map.get(item), i));
            }
            map.put(array[i], i);
        }
        return list;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 7, 11, 15};
        int[] nums = {5, 12, 6, 3, 9, 2, 1, 7};
        int target = 13;
        System.out.println("******************两数之和，要求找出两数之和的一个组合的索引******************");
        int[] result = twoSum2(nums, target);
        for (int i = 0 ; i < result.length; i ++){
            System.out.println(result[i]);
        }
        System.out.println("******************两数之和，要求找出两数之和的全部组合的索引******************");
        List<List<Integer>> list = twoSum3(nums, target);
        for (int i = 0 ; i < list.size(); i ++){
            System.out.println(list.get(i));
        }
    }
}
