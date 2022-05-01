/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

import java.util.Arrays;

/**
 * 最接近三数只和
 * https://leetcode-cn.com/problems/3sum-closest/solution/dui-shuang-zhi-zhen-fa-jin-xing-yi-dian-you-hua-da/
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2)
 * 时间复杂度：O(N^2)
 *
 * @author luweiliang
 * @created 2020/3/13
 */
public class lc_16_最接近的三数之和 {

    public static int threeSumClosest (int[] sums, int target) {
        if (sums == null || sums.length < 3) {
            return -1;
        }
        Arrays.sort(sums);
        int res = sums[0] + sums[1] + sums[2];
        for (int i = 0; i < sums.length - 2; i ++) {
            int l = i + 1, r = sums.length -1;
            while (l < r) {
               int sum = sums[i] + sums[l] + sums[r];
               if (sum > target) {
                   r --;
               } else {
                   l ++;
               }
               if (Math.abs(sum - target) < Math.abs(res - target)){
                   res = sum;
               }
            }
        }
        return res;
    }

    public static int threeSumClosest1(int[] sums, int target){

        if (sums == null || sums.length < 3){
            return -1;
        }
        Arrays.sort(sums);

        int res = sums[0] + sums[1] + sums[2];
        for (int i = 0; i < sums.length - 2; i ++) {
            int l = i +1, r = sums.length -1;
            while (l < r) {
                int sum = sums[i] + sums[l] + sums[r];
                if (Math.abs(sum - target) < Math.abs(res - target)) {
                    res = sum;
                }
                if (sum < target) {
                    l ++;
                } else {
                    r --;
                }
            }
        }
        return res;
    }

    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length - 1;
            while(left != right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;
                if(sum > target){
                    right--;
                    // 解决nums[right]重复
                    while(left != right && nums[right] == nums[right+1])
                        right--;
                }
                else{
                    left++;
                    // 解决nums[left]重复
                    while(left != right && nums[left] == nums[left-1])
                        left++;
                }
            }
            // 解决nums[i]重复
            while(i<nums.length-2 && nums[i] == nums[i+1])
                i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] sums = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(sums, 1));
        System.out.println(threeSumClosest1(sums, 1));
        System.out.println(threeSumClosest2(sums, 1));
    }

}
