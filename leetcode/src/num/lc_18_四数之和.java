/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 四数之和
 * https://blog.csdn.net/qq_36387730/article/details/81780987
 * https://leetcode-cn.com/problems/4sum/solution/javashuang-zhi-zhen-jie-fa-you-dai-ma-ji-bai-934-b/
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组
 * 例如, 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0，满足要求的三元组集合为：[[-1, 0, 0, 1],[-2, -1, 1, 2],[-2, 0, 0, 2]]
 */
public class lc_18_四数之和 {
    public static List<List<Integer>> fourNum(int[] nums, int target) {
        //数组是否满足条件判断
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        //数据排序
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i ++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length; j ++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        set.add(list);
                        //去重复数据
                        while (left < right && nums[left] == nums[left + 1]) {
                            left ++;
                        }
                        while (left < right && nums[right] == nums[right - 1]){
                            right --;
                        }
                        left ++;
                        right --;
                    } else if (sum < target) {
//                        while (left < right && nums[left] == nums[left + 1])
                        left ++;
                    } else {
//                        while (left < right && nums[right] == nums[right - 1])
                        right --;
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> fourNum1(int[] sums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        if (sums == null || sums.length < 4) {
            return list;
        }

        Arrays.sort(sums);

        for (int i = 0; i < sums.length - 3; i ++) {
            if (i > 0 && sums[i] == sums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < sums.length - 2; j ++) {
                if (j > i + 1 && sums[j] == sums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = sums.length - 1;
                while (l < r) {
                    int sum = sums[i] + sums[j] + sums[l] + sums[r];
                    if (sum == target) {
                        list.add(Arrays.asList(sums[i], sums[j], sums[l], sums[r]));
                        while (l < r && sums[l] == sums[l + 1]) l ++;    //去重复
                        while (l < r && sums[r] == sums[r - 1]) r --;    //去重复
                        l ++;
                        r --;
                    } else if (sum < target) {
                        l ++;
                    } else {
                        r --;
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int nums[] = {1, 0, -1, 0, -2, 2};
//        int nums[] = {0,0,0,0};
        List<List<Integer>> list = fourNum(nums, 1);
        List<List<Integer>> list1 = fourNum1(nums, 0);
        System.out.println(list);
        System.out.println(list1);
    }

}
