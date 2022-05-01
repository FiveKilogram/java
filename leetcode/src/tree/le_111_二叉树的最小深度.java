/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--25/
 * @author luweiliang
 * @created 2020/3/26
 */
public class le_111_二叉树的最小深度 {

    /**
     * 优先使用这个方法
     * 层次遍历
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        // 空树，高度为 0
        if(root == null){
            return 0;
        }
        // 初始化队列和层次
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;

        // 当队列不为空
        while(!queue.isEmpty()){
            // 当前层的节点数
            int n = queue.size();
            // 弹出当前层的所有节点，并将所有子节点入队列
            for(int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                // 最早出现左右节点都为空，证明为叶子节点，即为二叉树的最小高度
                if(node.left == null && node.right == null){
                    return depth;
                }
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

    /**
     * 层次遍历 + 递归
     * @param root
     * @return
     */
    public static int minDepth1(TreeNode root){
        if (root == null) return 0;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        return minDepth(queue, 0);
    }

    /**
     * 最小level的高度
     * @param queue
     * @param level
     * @return
     */
    private static int minDepth(LinkedList<TreeNode> queue, int level){
        int size = queue.size();
        for (int i = 0; i < size; i ++) {
          TreeNode node = queue.removeFirst();
          //取出元素的时候需要看一下左、右子节点是不是都是空的，如果是空的结束整个流程
          if (node.left == null && node.right == null) {
              return level + 1;
          }

          //能走到这里，证明左、右子节点最少有一个有值
          if (node.left != null) {
              queue.addLast(node.left);
          }
          if (node.right != null) {
              queue.addLast(node.right);
          }
        }
        level ++;
        //继续递归调用，求出最小的level的高度
        return minDepth(queue, level);
    }

    public static int minDepth2(TreeNode root){
        if (root == null) return 0;
        if (root.left == null || root.right == null){
            return Math.max(minDepth(root.left), minDepth(root.right)) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }

    public static int minDepth3(TreeNode root) {
        if(root == null) return 0;
        //这道题递归条件里分为三种情况
        //1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
        if(root.left == null && root.right == null) return 1;
        //2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
        int m1 = minDepth3(root.left);
        int m2 = minDepth3(root.right);
        //这里其中一个节点为空，说明m1和m2有一个必然为0，所以可以返回m1 + m2 + 1;
        if(root.left == null || root.right == null) return m1 + m2 + 1;

        //3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
        return Math.min(m1,m2) + 1;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(6);
//        root.right = new TreeNode(14);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(8);
//        root.right.left = new TreeNode(12);
//        root.right.right = new TreeNode(16);

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
//        root.left.left = new TreeNode(0);
//        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
/**
        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(6);
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(4);
//        root.right.right.left = new TreeNode(12);
        root.right.right.right = new TreeNode(5);
//        root.right.right.right.left = new TreeNode(12);
        root.right.right.right.right = new TreeNode(6);
 **/
        System.out.println(minDepth(root));
        System.out.println(minDepth1(root));
        System.out.println(minDepth2(root));
        System.out.println(minDepth3(root));
    }
}
