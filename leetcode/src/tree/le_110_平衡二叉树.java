/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 *      3
 *     / \
 *   9   20
 *     /   \
 *   15    17
 *
 * 示例 2
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 *         1
 *        / \
 *       2   2
 *     /  \
 *    3    3
 *  /  \
 * 4    4
 *
 *
 * 示例 3
 * 输入：root = []
 * 输出：true
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author luweiliang
 * @created 2020/3/25
 */
public class le_110_平衡二叉树 {

    public static boolean isBalanced(TreeNode root) {
        //定义一个结果集的数组，容量为1
        boolean[] result = new boolean[1];
        result[0] = true;

        //变相的改为遍历节点求出最大的深度，在求高度的过程中顺便判断一下是否满足平衡二叉树的特性
        calcDepth(root, result);
        return result[0];
    }

    private static int calcDepth(TreeNode node, boolean[] result){
        if (node == null) return 0;

        //看下左节点的高度
        int leftDepth = calcDepth(node.left, result);
        //看下右节点的高度
        int rightDepth = calcDepth(node.right, result);
        //比较是否满足平衡二叉树的特性，(左子树的高度 -  左子树的高度 不能大于1)
        if (Math.abs(leftDepth - rightDepth) > 1) {
            result[0] =  false;
            //目的达到了，就可以随便返回了，结束流程
            return 0;
        }
        //能来到这里，说明是符合平衡二叉树的特性，那就按照正常的方式求出root 最大的深度值
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);
        System.out.println(isBalanced(root));
    }
}
