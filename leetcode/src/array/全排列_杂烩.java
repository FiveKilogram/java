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
 * 在这里编写类的功能描述
 * https://blog.csdn.net/weixin_41708020/article/details/109106481
 *
 * @author luweiliang
 * @created 2021/3/13
 */
public class 全排列_杂烩 {
    static List<Integer> t = new ArrayList<>();
    static List<List<Integer>> ans = new ArrayList<>();

    /**
     * 所有集合可能，给定一组不含重复元素的整数数组nums，返回该数组所有肯能的子集(幂集)
     * 说明：解集不能包括重复的子集
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }
    public static void dfs(int cur, int[] nums){
        if(cur == nums.length){
            ans.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(nums[cur]);
        dfs(cur + 1, nums);
        t.remove(t.size() - 1);
        dfs(cur + 1, nums);
    }

    /**
     * 数组中有重复, 给定一组不含重复元素的整数数组nums，返回该数组所有肯能的子集(幂集)
     * 说明：解集不能包括重复的子集
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> mylist = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), mylist, nums, 0);
        return mylist;
    }

    private static void backtrack(List<Integer> temp, List<List<Integer>> mylist, int[] nums,
                           int start){
        mylist.add(new ArrayList<>(temp));
        for(int i = start; i < nums.length; ++i){
            //相同则跳到下一个
            if(i > start && nums[i] == nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            backtrack(temp, mylist, nums, i+1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println("---------------给定一组不含重复元素的整数数组---------------------");
        System.out.println(subsets(nums));

        System.out.println("---------------给定一组可能含重复元素的整数数组---------------------");
        System.out.println(subsetsWithDup(nums));
    }
}
