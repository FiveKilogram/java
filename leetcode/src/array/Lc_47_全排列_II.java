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
 * 给定一个可包含重复数字的序列nums，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [
 *  [1,1,2],
 *  [1,2,1],
 *  [2,1,1]
 * ]
 *
 * 示例 2：
 * 输入：nums = [1,2,3]
 * 输出：
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 * @author luweiliang
 * @created 2021/3/12
 */
public class Lc_47_全排列_II {

    /**
     *
     * 思路：DFS(深度优先)遍历 + 回溯 + 剪枝(就是把重复路径剪掉)
     * 时间复杂度：O(n * n)
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {

        // 存放结果
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        //先排序，为了方便剪枝
        //这步很重要，如果不是有序的，剪枝会出错
        Arrays.sort(nums);

        // 暂存结果
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(nums, path,res, used);
        return res;
    }

    /**
     * 这个方法的性能最优，时间复杂度：O(n)
     * DFS(深度优先)遍历 + 回溯 + 剪枝(去重复)
     * @param nums 数组
     * @param path DFS(深度优先)遍历路径
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
            //剪枝条件，已访问过，直接跳过(把重复使用的数据去掉)
            // path里已经收录的元素，直接跳过这层循环
            if (used[i]) {
                continue;
            }

            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历回退的过程中刚刚被撤销选择
            // 如果数组相连元素相等，没有先访问后面的元素，就不会存在重复
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
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


    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permuteUnique(nums));
    }
}
