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
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/3/26
 */
public class lc_145_二叉树后序遍历 {

    /**
     * 后序遍历：左子树->右子树->根节点（左->右->根）
     *
     * @param root
     * @return
     */
    public static List<Integer> pustOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> tempStack = new Stack<>();

        while (root != null || !tempStack.isEmpty()){
            while (root != null) {
                stack.push(root);
                tempStack.push(root);
                root = root.right;
            }
            if (!tempStack.isEmpty()) {
                root = tempStack.pop();
                root = root.left;
            }
        }
        while (!stack.isEmpty()){
            list.add(stack.pop().val);
        }
        return list;
    }

    public static void postOrder(TreeNode root) {
        if (root != null) {
            Stack<TreeNode> stackTemp = new Stack<>();
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stackTemp.isEmpty()) {
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

            while (!stack.isEmpty()) {
                System.out.println(stack.pop().val);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.right = new TreeNode(14);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        System.out.println(pustOrder(root));
    }
}
