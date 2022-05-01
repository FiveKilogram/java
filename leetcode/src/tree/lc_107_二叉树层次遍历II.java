/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树层次遍历II-返回其节点值自底向上的层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/solution/die-dai-he-di-gui-by-powcai-4/
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15  7
 *  [
 *   [15,7],
 *   [9,20],
 *   [3]
 *  ]
 * @author luweiliang
 * @created 2020/3/26
 */
public class lc_107_二叉树层次遍历II {

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i ++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(0, list);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(levelOrder(root));
    }
}
