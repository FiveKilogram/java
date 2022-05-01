/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例: 输入: [1,2,3]
 * 输出:
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 * 深度优先，回溯 + 剪枝
 * 深度优先遍历，回溯算法
 *  状态：每个节点表示了求解问题的不同阶段
 *  深度优先遍历回到上一层节点时需要"状态重置"
 *  状态变量：
 *    1、递归到了第几层 depth
 *    2、已经选了那些数(路径)，path，这个变量是一个栈
 *    3、boolean数组，used
 * https://leetcode-cn.com/problems/permutations/solution/pei-yang-chou-xiang-neng-li-de-yi-dao-ti-1731/
 * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
 * @author luweiliang
 * @created 2021/3/12
 */
public class Lc_46_全排列 {

    /**
     * 回溯算法
     *
     * 思路：DFS(深度优先)遍历 + 回溯 + 剪枝(就是把重复路径剪掉)
     * 时间复杂度：O(n * n)的阶层
     * https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
     * https://leetcode-cn.com/problems/permutations/solution/pei-yang-chou-xiang-neng-li-de-yi-dao-ti-1731/
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        // 存放结果
        List<List<Integer>> res = new ArrayList<>();
        // 暂存结果
        List<Integer> path = new ArrayList<>();
        // dfs(nums, path, res);
        boolean[] used = new boolean[nums.length];
        dfs(nums, path,res, used);
        return res;
    }

    /**
     * 这个方法的性能最优，时间复杂度：O(n)
     * DFS(深度优先)遍历 + 回溯 + 剪枝(去重复)
     * @param nums 数组
     * @param path DFS(深度优先)遍历路径
     * @param used 当前的值在之前是否已经选择过，也就是说当前的值是否在path数组变量里面，初始化为false，表示没有被选择，空间换时间的思想
     * @param res 排列结果集合
     * [
     *      [1, 2, 3], [1, 3, 2],
     *      [2, 1, 3], [2, 3, 1],
     *      [3, 1, 2], [3, 2, 1]
     *  ]
     *  时间复杂度：O(n)
     */
    private static void dfs(int[] nums, List<Integer> path, List<List<Integer>> res, boolean[] used) { // O(n)
        // 设置搜索结束条件：深度达到nums长度，此时说明找到了一组;
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            // 回溯
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 剪枝条件，已访问过，直接跳过(把重复使用的数据去掉)
            // path里已经收录(使用)的元素，直接跳过这层循环
            if (used[i]) {
                continue;
            }

            // 递归前，添加路径，同时标记为已访问，回溯求值
            path.add(nums[i]);
            used[i] = true;

            dfs(nums, path, res, used);
            // 递归后，撤销路径
            // 回溯的过程中，将当前的节点从path中删除(回溯后，删掉最后一个元素，重新标记为未访问)
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    /**
     * DFS(深度优先)遍历 + 回溯 + 剪枝(去重复)
     * @param nums 数组
     * @param path DFS(深度优先)遍历路径
     * @param res 排列结果集合
     * [
     *      [1, 2, 3], [1, 3, 2],
     *      [2, 1, 3], [2, 3, 1],
     *      [3, 1, 2], [3, 2, 1]
     *  ]
     *  时间复杂度： O(n^2)
     */
    private static void dfs(int[] nums, List<Integer> path, List<List<Integer>> res) {

        // 设置搜索结束条件：深度达到nums长度，此时说明找到了一组;
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            // 回溯
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // path里已经收录的元素，直接跳过
            // 剪枝，把重复使用的数据去掉，直接退出当前循环
            if (path.contains(nums[i])) {
                continue;
            }
            // 递归前，添加路径
            path.add(nums[i]);
            dfs(nums, path, res);
            // 递归后，撤销路径
            // 回溯的过程中，将当前的节点从path中删除
            path.remove(path.size() - 1);
        }
    }

    /**
     * DFS(深度优先)遍历 + 回溯算法的通用模板
     * @param nums 数组
     * @param path DFS(深度优先)遍历路径
     * @param res 排列结果集合
     * [
     *      [1, 1, 1], [1, 1, 2], [1, 1, 3], [1, 2, 1], [1, 2, 2], [1, 2, 3], [1, 3, 1], [1, 3, 2], [1, 3, 3],
     *      [2, 1, 1], [2, 1, 2], [2, 1, 3], [2, 2, 1], [2, 2, 2], [2, 2, 3], [2, 3, 1], [2, 3, 2], [2, 3, 3],
     *      [3, 1, 1], [3, 1, 2], [3, 1, 3], [3, 2, 1], [3, 2, 2], [3, 2, 3], [3, 3, 1], [3, 3, 2], [3, 3, 3]
     *  ]
     */
    private static void dfs_template(int[] nums, List<Integer> path, List<List<Integer>> res) {
        // 设置搜索结束条件：深度达到nums长度，此时说明找到了一组;
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            //回溯
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 递归前，添加路径
            path.add(nums[i]);
            dfs(nums, path, res);
            // 递归后，撤销路径
            // 回溯的过程中，将当前的节点从 path 中删除
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
}
