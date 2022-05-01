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
 * 三数之和（给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组）
 * https://blog.csdn.net/qq_39241239/article/details/82387016
 * https://leetcode-cn.com/problems/3sum/solution/hua-jie-suan-fa-15-san-shu-zhi-he-by-guanpengchn/
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，满足要求的三元组集合为：[[-1, 0, 1],[-1, -1, 2]]
 * 时间复杂度：O(N2)，N为数组长度
 * 空间复杂度：O(logN)
 */
public class lc_15_三数之和 {
    public static List<List<Integer>> threeSum(int[] sums){
        if (sums == null || sums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(sums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < sums.length; i ++) {
            int left = i + 1;
            int rigth = sums.length - 1;
            while (left < rigth){
                if (sums[i] + sums[left] + sums[rigth] == 0) {
                    List<Integer> list = new ArrayList();
                    list.add(sums[i]);
                    list.add(sums[left]);
                    list.add(sums[rigth]);
                    set.add(list);
                    while (left < rigth && sums[left] == sums[left + 1]){
                        left ++;
                    }
                    while (left < rigth && sums[rigth] == sums[rigth - 1]){
                        rigth --;
                    }
                    left ++;
                    rigth --;
                } else if (sums[i] + sums[left] + sums[rigth] < 0){
                    left ++;
                } else {
                    rigth --;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSum1(int[] sums){
        if (sums == null) {
            return null;
        }
        if (sums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(sums);  //先排序
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < sums.length; i ++) {
            //定义双指针，left从当前加1开始 ++，right从最后开始 --；
            int left = i + 1;
            int right = sums.length - 1;
            while (left < right) {
                int sum = sums[i] + sums[left] + sums[right];
                if (sum == 0) {
                   List<Integer> list = new ArrayList<>();
                   list.add(sums[i]);
                   list.add(sums[left]);
                   list.add(sums[right]);
                   set.add(list);
                   //去重复数据
                   while (left < right && sums[left] == sums[left + 1]) {
                      left ++;
                   }
                   while (left < right && sums[right] == sums[right - 1]){
                      right --;
                   }
                   left ++;
                   right --;
               } else if (sum < 0) {
                    left ++;
               } else {
                    right --;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSum2(int[] sums){
        List<List<Integer>> list = new ArrayList<>();
        if (sums == null || sums.length < 3) {
            return list;
        }
        Arrays.sort(sums);  //先排序
        for (int i = 0; i <sums.length -2; i ++) {
            if (sums[i] > 0) {  // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                break;
            }
            if (i > 0 && sums[i] == sums[i - 1]) {
                continue;
            }
            int l = i + 1, r = sums.length - 1;
            while (l < r){
                int sum = sums[i] + sums[l] + sums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(sums[i], sums[l], sums[r]));
                    while (l < r && sums[l] == sums[l + 1]) l++; //去重复
                    while (l < r && sums[r] == sums[r - 1]) r--; //去重复
                    l++;
                    r--;
                } else if (sum < 0) {
                    l ++;
                } else {
                    r --;
                }

            }
        }
        return list;
     }

    // 总时间复杂度：O(n^2)
    public static List<List<Integer>> threeSum3(int[] sums) {
        List<List<Integer>> list = new ArrayList<>();
         if (sums == null || sums.length < 3) {
             return list;
         }
         Arrays.sort(sums);          // O(nlogn)

         for (int i = 0; i < sums.length - 2; i ++){  // O(n^2)
             // 第一个数大于 0，后面的数都比它大，肯定不成立了
             if (sums[i] > 0) {
                 break;
             }
             // 去掉重复情况
             if (i > 0 && sums[i] == sums[i - 1]) {
                 continue;
             }
             //定义left 和 right两个指针，left增加操作，right减小操作，但是不能重复，
             int l = i + 1, r = sums.length - 1;
             while (l < r) {
                 int sum = sums[i] + sums[l] + sums[r];
                 if (sum == 0) {
                     list.add(Arrays.asList(sums[i], sums[l], sums[r]));
                     while (l < r && sums[l] == sums[l + 1]) l ++;  // 去掉重复情况
                     while (l < r && sums[r] == sums[r - 1]) r --;  // 去掉重复情况
                     l ++;
                     r --;
                 } else if (sum < 0) {
                     l ++;
                 } else {
                     r --;
                 }
             }
         }
         return list;
    }

    public static void main(String[] args) {
        int sums[] = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> list = threeSum1(sums);
        List<List<Integer>> list1 = threeSum2(sums);
        List<List<Integer>> list3 = threeSum3(sums);
        System.out.println(list);
        System.out.println(list1);
        System.out.println(list3);
    }
}
