/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 在这里编写类的功能描述
 * https://blog.csdn.net/m0_38001814/article/details/90610728
 * @author luweiliang
 * @created 2019/10/25
 */
public class TreeNodePrint {

    /**
     * 先序遍历
     * @param root
     */
    public static void preOrder(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            while(root != null){
                System.out.println(root.data);
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void inOrder(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.data);
                root = root.right;
            }
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void postOrder(BinaryTreeNode root){
        if (root != null) {
            Stack<BinaryTreeNode> stackTemp = new Stack<>();
            Stack<BinaryTreeNode> stack = new Stack<>();
            while (root != null || !stackTemp.isEmpty()){
                while (root != null) {
                    stackTemp.push(root);
                    stack.push(root);
                    root = root.right;
                }
                if (!stackTemp.isEmpty()) {
                    root = stackTemp.pop();
                    root = root.left;
                }
            }

            while(!stack.isEmpty()){
                System.out.println(stack.pop().data);
            }
        }
    }

    /**
     * 层次遍历
     * @param root
     */
    public static void levelOrder(BinaryTreeNode root){
        Queue<BinaryTreeNode> list = new LinkedList<>();
        list.offer(root);
        while (list != null){
           root = list.poll();
           System.out.print(root.data +"\n");
//            System.out.print("\n");
           if (root.left != null) {
               list.offer(root.left);
           }
           if (root.right != null) {
               list.offer(root.right);
           }
        }
    }

    /**
     * 二叉树的高度
     * @param root
     * @return
     */
    public static int leveHigth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //树的高度
        int height = 0;
        //存储每一层的元素数量，初始值为1的原因是root不为空时是第一层
        int levetSize  = 1;
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            levetSize --;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            //即将访问下一层
            if (levetSize == 0) {
                levetSize = queue.size();
                height ++;
            }
        }
        return height;
    }

    /**
     * 是否完全二叉树
     * @param root
     * @return
     */
    public static boolean isCompltie(BinaryTreeNode root){
        if (root == null) {
            return false;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leaf = false;
        while (!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            if (leaf && !(node.left == null && node.right == null)) {
                return false;
            }
            if (node.left != null && node.right != null){
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null){
                return false;
            } else {  //node.leftTree != null && node.rightTree == null || node.leftTree == null && node.rightTree == null
                leaf = true;
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return true;
    }

    /**
     * Leetcode226-翻转二叉树（四种方法）
     * 前序遍历、中序遍历、后序遍历、层次遍历
     * @param root
     * @return
     */
    public static BinaryTreeNode invertTree(BinaryTreeNode root){
        if (root == null) {
            return root;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            BinaryTreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

    public static BinaryTreeNode init(){
        BinaryTreeNode fNode = new BinaryTreeNode("F", null, null);
        BinaryTreeNode eNode = new BinaryTreeNode("E", null, null);
        BinaryTreeNode dNode = new BinaryTreeNode("D", null, null);
        BinaryTreeNode cNode = new BinaryTreeNode("C", fNode, null);
        BinaryTreeNode bNode = new BinaryTreeNode("B", dNode, eNode);
        BinaryTreeNode root = new BinaryTreeNode("A", bNode, cNode);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = init();
//        System.out.println("前序遍历:");
//        preOrder(root);
//        System.out.println("中序遍历:");
//        inOrder(root);
//        System.out.println("后序遍历:");
//        postOrder(root);
        System.out.println("层次遍历:");
        levelOrder(root);
    }
}
