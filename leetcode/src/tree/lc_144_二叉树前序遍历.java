/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树前序遍历
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/solution/er-cha-shu-xian-xu-bian-li-by-ac_pipe/
 * @author luweiliang
 * @created 2020/3/25
 */
public class lc_144_二叉树前序遍历 {

    /**
     * 前序遍历：根节点->左子树->右子树（根->左->右）
     * @param root
     * @return
     */
    public static List<Integer> preOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.isEmpty()) {
            //这里代表还有左子树, 注意是while循环.
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            //左子树为null, 这时候开始遍历右子树.
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(preOrder(root));
    }
}
