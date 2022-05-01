/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.List;

/**
 * 重建二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *  * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9], 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *      0
 *     / \
 *   -3   9
 *   /   /
 * -10  5
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/di-gui-er-fen-by-zhang-heng-6/
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/solution/qu-shu-zu-zhong-shu-zuo-wei-tou-jie-dian-di-gui-yo/
 * 思路：
 * 我们可以通过二分法，不停的将中点值设置为当前子树的根节点，左孩子为左半部数组的中点值，右孩子为右半部数组的中点值，递归执行。
 * 1、将有序数组一分为二，中间结点成为根结点，前半部分是左子树，右半部分是右子树；
 * 2、递归构建左子树和右子树，应用到分治思想。
 * 时间复杂度：O(N)，每个元素只访问一次。
 * 空间复杂度O(N)
 * @author luweiliang
 * @created 2020/3/23
 */
public class lc_108_有序数组转换二叉搜索树 {

    public static TreeNode sortedArrayToBST (int[] array){
        if (array == null || array.length == 0) return null;

        return helper(array, 0, array.length - 1);
    }

    public static TreeNode helper(int[] array, int left, int rigth){
        if (left > rigth) return null;
        int mid = (rigth - left) / 2 + left;

        TreeNode root = new TreeNode(array[mid]);
        root.left = helper(array, left, mid - 1);
        root.right = helper(array, mid + 1, rigth);
        return root;
    }

    public static void main (String[] args) {
        int[] array = {4, 6, 8, 10, 12, 14, 16};

        TreeNode treeNode = sortedArrayToBST(array);
        List<Integer> list = lc_144_二叉树前序遍历.preOrder(treeNode);
        System.out.println(list);
    }
}
