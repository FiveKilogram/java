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
 * 二叉树的最大深度& 二叉树的高度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/solution/marveljian-dan-de-xue-xi-bi-ji-104-by-marvel_ty/
 * @author luweiliang
 * @created 2020/3/25
 */
public class le_104_二叉树的最大深度 {

    public static int maxDepth(TreeNode root) {
        int maxDepth = 0;
        if (root == null) return maxDepth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            maxDepth ++;
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
               TreeNode node = queue.poll();
               if (node.left != null) {
                   queue.offer(node.left);
               }
               if (node.right != null) {
                   queue.offer(node.right);
               }
            }
        }
        return maxDepth;
    }

    public static int levelHeight(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //高度
        int Height = 0;
        //存储每一层的元素数量，初始值为1的原因是root不为空时是第一层
        int levelSize = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            levelSize --;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (levelSize == 0) {
                levelSize = queue.size();
                Height ++;
            }
        }
        return Height;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(levelHeight(root));
        System.out.println(maxDepth(root));
    }
}
