/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

/**
 * 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *    1
 *   / \
 *  2   3
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 *
 *     -10
 *     / \
 *    9  [20]
 *       /  \
 *    [15]  [7]
 * 输入：root = [-10, 9, 20, null, null, 15, 7] 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 *
 * 时间复杂度：O(N)，其中 N 是二叉树中的节点个数。对每个节点访问不超过 22 次。
 * 空间复杂度：O(N)，其中 N 是二叉树中的节点个数。空间复杂度主要取决于递归调用层数，最大层数等于二叉树的高度，最坏情况下，二叉树的高度等于二叉树中的节点个数。
 *
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
 * @author luweiliang
 * @created 2021/3/16
 */
public class Lc_124_二叉树中的最大路径和 {

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    /**
     * 深度优先搜索
     * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-de-zui-da-lu-jing-he-zhu-yao-li-jie-ti-/
     */
    public static int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        /**
         Q：左右孩子贡献为什么要大于等于0？
         A: 因为计算从某一节点出发的路径和的时候，计算公式为： 当前节点值 + 左孩子贡献 + 右孩子贡献，
         而左右孩子贡献是「可选的」，也就是说当某一边贡献小于0的时候，我可以在计算路径和时不算这一边
         这种情况也就相当于其贡献为 0，但是注意路径和至少包含「当前节点的值」。
         */

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);     // 左孩子贡献
        int rightGain = Math.max(maxGain(node.right), 0);   // 右孩子贡献

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        // 求的过程中考虑包含当前根节点的最大路径
        int priceNewpath = node.val + leftGain + rightGain;
        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        //返回包含当前根节点和左子树或者右子树的路径
        return node.val + Math.max(leftGain, rightGain);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }
}
