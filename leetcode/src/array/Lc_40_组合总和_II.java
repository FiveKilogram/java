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
 *
 * 给定一个候选人编号的集合candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 * 注意：解集不能包含重复的组合。
 *
 * 示例1:
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 *
 * 示例2:
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 *
 * https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
 * @author luweiliang
 * @created 2020/5/22
 */
public class Lc_40_组合总和_II {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        //排序是关键步骤：现将数组进行排序，解决不能包含重复的组合
        Arrays.sort(candidates);

        List<Integer> path = new ArrayList<>();
        dfs(candidates, 0, len, target, path, res);
        return res;
    }

    /**
     * @param candidates 候选数组
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param len        冗余变量，是 candidates 里的属性，可以不传
     * @param target     表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径，是一个栈
     * @param res        结果集列表
     */
    private static void dfs(int[] candidates, int begin, int len, int target, List<Integer> path, List<List<Integer>> res) {
        // target 为负数和 0 的时候不再产生新的孩子结点
        if (target < 0) {
            return;
        }
        //如果递归到叶子结点，节点值刚好等于0，那说明路径上的元素就是结果
        if (target == 0) {
            //将路径上的结果加入返回结果集上
            res.add(new ArrayList<>(path));
            //退出递归
            return;
        }

        // 重点理解这里从 begin 开始搜索的语意
        for (int i = begin; i < len; i++) {
            //大剪枝，如果在有序的情况下，当前元素已经大于目标数组元素，那说明后面的元素就不在需要遍历，原因后面的元素比当前元素更大。

            // or 两种翻译描述

            // 大剪枝：减去 candidates[i] 小于 0，减去后面的 candidates[i + 1]、candidates[i + 2] 肯定也小于 0，因此用 break
            if(target - candidates[i] < 0){
                break;
            }
            //小剪枝，发生在同层， 可以自己在图上画一个在第一个节点取1后的几种情况就可以发现。如果同层的元素的值，相同，就不在需要递归了，
            // 原因在有序的情况下，后面出现的元素都会相同，造成结果集也会相同

            // or 两种翻译描述

            // 小剪枝：同一层相同数值的结点，从第 2 个开始，候选数更少，结果一定发生重复，因此跳过，用 continue
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //将数组的元素加入路径集合中
            path.add(candidates[i]);

            // 由于元素不可以重复使用，下一轮搜索的起点是 i + 1。而不是i
            // 这里的重复，但是同层不能重复，不同层是允许重复的
            dfs(candidates, i + 1, len, target - candidates[i], path, res);

            //剪枝，将元素从末尾开始删除，相当于将树，从叶子结点开始向根结点删除。
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
//        int[] candidates = {2,3,6,7};
//        int target = 7;
        int[] candidates = {1, 2, 3, 5, 8};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
    }
}
