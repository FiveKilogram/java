/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;

import java.util.Stack;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 二叉搜索树转换成一个排序的双向链表
 *
 * 核心思想
 * 在二叉搜索树中，每个结点都有两个指向子节点的指针，在双向链表中，每个结点也有两个指针，分别指向前一个结点和后一个结点。
 * 在二叉搜索树中，左子节点的值总是小于右子结点的值，右子结点的值总是大于父节点的值。
 * 因此，我们在转换为双向链表时，原先指向左子节点的指针调整为链表中指向前一个节点的指针，原先指向右子结点的指针调整为链表中指向后一个结点的指针。
 *
 * 时间复杂度：
 * 该算法首先从根要点一直向左走，找到最左边的结点，其时间复杂度为O(logN)，
 * 然后对二叉排序树中的每个结点遍历一次，进行指针变换，其时间复杂度为O(N)，所以总的时间复杂度为O(N)
 *
 * 空间复杂度：
 * 由于ConvertNode函数进行递归调用，其函数有两个开参，而函数栈中的函数调用层数不会超过树高，所以其空间复杂度为O(logN)
 *
 * @author luweiliang
 * @created 2020/5/13
 */
public class 二叉树转换为双向链表 {

    /**
     * 深度优先(DFS, Depth First Search)
     * @param root
     * @return
     */
    public static TreeNode convert(TreeNode root) {

        // LastNodeOfList指向已经转换好的链表的最后一个结点
        TreeNode lastNodeOfList = null;
        // 返回头结点
        TreeNode headNodeOfList = ConvertNode(root, lastNodeOfList);
        // 一直倒退到头结点
        while (headNodeOfList != null && headNodeOfList.left != null) {
            headNodeOfList = headNodeOfList.left;
        }
        return headNodeOfList;
    }

    // 把二叉树转换成链表,获得链表最后结点（即最大结点）
    static TreeNode ConvertNode(TreeNode pNode, TreeNode LastNodeOfList) {
        if (pNode == null) {
            return null;
        }
        TreeNode current = pNode;

        if (current.left != null) {
            //把左子树转成链表
            LastNodeOfList = ConvertNode(current.left, LastNodeOfList);
        }
        // 当前结点的左边就是左子树构成的链表的最后一个结点
        current.left = LastNodeOfList;

        if (LastNodeOfList != null) {
            //把转换好的链表后面连接当前结点
            LastNodeOfList.right = current;
        }

        //此时根转换好的链表最后一个结点就是当前结点
        LastNodeOfList = current;
        // 同理 把右子树转成链表
        if (current.right != null) {
            LastNodeOfList = ConvertNode(current.right, LastNodeOfList);
        }
        return LastNodeOfList;
    }

    /**
     * 广度优先(BFS, Breadth First Search)
     * 1、核心是中序遍历的非递归算法
     * 2、修改当前遍历节点与前一遍历节点的指针指向
     * @param root
     * @return
     */
    public static TreeNode convertBSTToBiList(TreeNode root) {
        if (root == null) return root;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        //用于保存中序遍历序列的上一节点
        TreeNode prev = null;
        //是否是第一个节点标记
        boolean isFirst = true;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (isFirst) {
                //将中序遍历序列中的第一个节点记为root
                root = current;
                prev = root;
                isFirst = false;
            } else {
                prev.right = current;
                current.left = prev;
                prev = current;
            }
            current = current.right;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(6);
        node.right = new TreeNode(14);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(8);
        node.right.left = new TreeNode(12);
        node.right.right = new TreeNode(16);

        TreeNode result = convertBSTToBiList(node);
        System.out.print(result.val + " " + result.right.val + " " + result.right.right.val + " "
                + result.right.right.right.val + " " + result.right.right.right.right.val + " "
                + result.right.right.right.right.right.val + " " + result.right.right.right.right.right.right.val);

    }
}
