/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * 示例 1：
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *         5
 *        / \
 *       4   8
 *     /   /  \
 *  * 7   12   4
 *   11         \
 *  /  \         1
 * 7    2
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 *
 * 示例 2
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 *
 *      1
 *     / \
 *   2    3
 *
 *
 * 示例 3：
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--25/
 * @author luweiliang
 * @created 2020/3/26
 */
public class le_112_路径总和 {

    /**
     * 深度优先算法 - 优先这个方法
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        //定义一个结果集的数组，容量为1
        //root是有元素的，我们进行深度优先遍历
        // 1、
        boolean[] result = new boolean[1];
        //变相的改为遍历节点求出最大的深度，在求高度的过程中顺便判断一下是否满足平衡二叉树的特性
        dfs(root, targetSum, 0, result);
        return result[0];
    }

    /**
     * 深度优先遍历
     * @param root 需要保证入参root一定不能为空
     * @param sum
     * @param calcSum
     * @param result
     */
    private static void dfs(TreeNode root, int sum, int calcSum, boolean[] result){
        //需要保证入参root一定不能为空
        //递归的终止条件，如果 root的左、右子节点都为空的话，则可以开始比较 sum == calcSum;
        //首先选择一个元素进行累加，最后完成一个跟节点到叶子节点的累加之和
        calcSum += root.val;

        //再来看，是否符合叶子节点
        if (root.left == null && root.right == null) {
            if(sum == calcSum) {
                result[0] = true;
                return;
            }
        }

        //能来到这里，说明当前的root节点还不是叶子节点，则有最多两种选择
        //选择左子节点
        if (root.left != null) {
            dfs(root.left, sum, calcSum, result);
        }
        //选择右子节点
        if (root.right != null) {
            dfs(root.right, sum, calcSum, result);
        }
    }

    /**
     * 广度优先搜索
     * @param root
     * @param targetSum
     * @return
     */
    public static boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root==null) {
            return false;
        }
        //定义存入节点的队列
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //入队顶元素
        queue.offer(root);
        while (!queue.isEmpty()) {
            //出队
            TreeNode node = queue.poll();
            //如果遍历到了底部
            if (node.left == null && node.right == null) {
                if (node.val == targetSum) {
                    return true;
                }
                continue;
            }
            //遍历左节点
            if (node.left != null) {
                node.left.val += node.val;
                queue.offer(node.left);
            }
            //遍历右节点
            if (node.right != null) {
                node.right.val += node.val;
                queue.offer(node.right);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);


        int target = 22;
        System.out.println(hasPathSum(root, target));
        System.out.println(hasPathSum1(root, target));
    }
}
