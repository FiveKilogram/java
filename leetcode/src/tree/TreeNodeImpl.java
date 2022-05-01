/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

/**
 * 查找二叉树节点
 *
 * @author luweiliang
 * @created 2019/10/23
 */
public class TreeNodeImpl {

    public static TreeNode findTreeNode(TreeNode treeNode, int data){
        TreeNode ptn;
        if (treeNode == null) {
            return null;
        }
        if (treeNode.val == data) {
            return treeNode;
        } else {
            if ((ptn = findTreeNode(treeNode.left, data)) != null) {
                return ptn;
            }
            if ((ptn = findTreeNode(treeNode.right, data)) != null) {
                return ptn;
            }
            return null;
        }

    }

    public static TreeNode findTreeNode1(TreeNode treeNode, int data){
        TreeNode current = treeNode;
        while (current != null){
            if (current.val > data) {
                current = current.left;
            } else if (current.val < data) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    public static boolean inser(TreeNode treeNode, int data){
        TreeNode root = treeNode;
        TreeNode newNode = new TreeNode(data);
        if (root == null) {
            root = newNode;
            return true;
        } else {
            TreeNode current = root;
            TreeNode parenNode = null;
            while (current != null) {
                if (current.val > data) {
                    current = current.left;
                    if (current == null) {
                        parenNode.left = newNode;
                        return true;
                    }
                }
                if (current.val < data) {
                    current = current.right;
                    if (current == null) {
                        parenNode.right = newNode;
                        return true;
                    }
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node8 = new TreeNode(8, null, null);

//        root.setLeftTree(node2);
//        root.setRightTree(node3);
//        node2.setLeftTree(node4);
//        node3.setLeftTree(node5);
//        node3.setRightTree(node6);
//        node5.setLeftTree(node7);
//        node5.setRightTree(node8);
        TreeNode treeNode = findTreeNode1(root, 5);
        System.out.println(treeNode.val);
    }

}
