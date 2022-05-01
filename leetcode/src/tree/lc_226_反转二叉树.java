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
 * 反转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/solution/fan-zhuan-er-cha-shu-by-leetcode/
 * 示例：
 * 输入：
      4
    /   \
   2     7
  / \   / \
 1   3 6   9

 输出：
      4
    /   \
   7     2
  / \   / \
 9   6 3   1

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/invert-binary-tree
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author luweiliang
 * @created 2020/3/26
 */
public class lc_226_反转二叉树 {

    public static TreeNode reverseTree(TreeNode root){
        if (root == null) return root;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
         while (!queue.isEmpty()) {
             TreeNode node = queue.poll();
             TreeNode temp = node.left;
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

    //递归实现
    public static TreeNode invert(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = invert(root.left);
        root.right = invert(root.right);
        swap(root);
        return root;
    }

    //非递归，用栈实现
    public static void invertByStack(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.empty()){
            TreeNode node = stack.pop();
            swap(node);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
    }

    public static void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(lc_102_二叉树层次遍历.levelOrder(root));
        TreeNode treeNode =  reverseTree(root);
        System.out.println(lc_102_二叉树层次遍历.levelOrder(treeNode));
    }
}
