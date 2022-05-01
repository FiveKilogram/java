/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 是否完全二叉树
 * https://www.jb51.net/article/114413.htm
 * @author luweiliang
 * @created 2020/3/26
 */
public class lc_是否完全二叉树 {

    public static boolean isCompltie(TreeNode root){
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean lefa = false;        //叶子节点
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (lefa && !(node.left == null && node.right == null)) {
                // 如果之前层遍历的结点没有右孩子，且当前的结点有左或右孩子，直接返回false
                return false;
            }
            if (node.left != null && node.right != null) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null){
                // 如果当前结点有右孩子却没有左孩子，直接返回false
                return false;
            } else {
                // 如果当前结点没有右孩子，那么之后层遍历到的结点必须为叶子结点
                lefa = true;
                if (node.left != null){
                    queue.offer(node.left);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(isCompltie(root));
    }
}
