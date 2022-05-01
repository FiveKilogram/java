/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定二叉树的一条最长路径 如果有多条，输出其中一条
 *
 *
 * @author luweiliang
 * @created 2020/12/7
 */
public class 二叉树的最长路径 {


    /**
     * 给定二叉树的一条最长路径 如果有多条，输出其中一条
     * @param root 给定二叉树的根结点
     * @param longestPath  存放二叉树的最长路径上的结点
     */
   public static void longestPath(TreeNode root, List<TreeNode> longestPath) {
        if (root != null) {
            longestPath.add(root);
            if (root.left == null && root.right == null) { // 左右子树均空
                return ;
            }

            List<TreeNode> leftLongestPath = new ArrayList<>();
            List<TreeNode> rightLongestPath = new ArrayList<>();
            longestPath(root.left, leftLongestPath);
            longestPath(root.right, rightLongestPath);
            if (leftLongestPath.size() >= rightLongestPath.size()) {
                longestPath.addAll(leftLongestPath);
            } else if (leftLongestPath.size() < rightLongestPath.size()) {
                longestPath.addAll(rightLongestPath);

            }
        }
    }

    public static void main(String[] args) {
        List<TreeNode> l = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(lc_102_二叉树层次遍历.levelOrder(root));
        longestPath(root, l);
        for (int i = 0; i < l.size(); i++)
            System.out.println(l.get(i).val);
    }
}
