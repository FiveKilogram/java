/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * 示例 1
 *
 *    1
 *   / \
 *  2   3
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 *
 * 示例 2
 *
 *      4
 *     / \
 *    9   0
 *  /  \
 * 5    1
 * 输入：root = [4,9,0,5,1]
 * 输出：1026
 * 解释：
 * 从根到叶子节点路径 4->9->5 代表数字 495
 * 从根到叶子节点路径 4->9->1 代表数字 491
 * 从根到叶子节点路径 4->0 代表数字 40
 * 因此，数字总和 = 495 + 491 + 40 = 1026
 *
 *
 *
 * 时间复杂度：O(N)，其中 N 是二叉树中的节点个数。对每个节点访问1次。
 * 空间复杂度：O(N)，其中 N 是二叉树的节点个数。空间复杂度主要取决于递归调用的栈空间，递归栈的深度等于二叉树的高度，最坏情况下，二叉树的高度等于节点个数，空间复杂度为 O(N)。
 *
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/
 * @author luweiliang
 * @created 2021/3/16
 */
public class Lc_129_求根到叶子节点数字之和 {

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * 深度优先算法 - 先序遍历
     * @param root
     * @param prevSum 定义root 节点所能提供的最大累加之和
     * @return
     */
    public static int dfs(TreeNode root, int prevSum) {
        //如果root 为空，说明没有任何节点了，直接返回0
        if (root == null) {
            return 0;
        }


        //如果root没有左、右节点，说明root是最后一个元素
        if (root.left == null && root.right == null) {
            return root.val + prevSum;
        }

        //计算能提供给到左、右子节点的基础值
        int sum = (prevSum + root.val) * 10;
        return dfs(root.left, sum) + dfs(root.right, sum);
    }

    /**
     * 深度优先算法 - 先序遍历
     * @param root
     * @param prevSum
     * @return
     */
    public static int dfs1(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);
        System.out.println(sumNumbers(root));
    }
}
