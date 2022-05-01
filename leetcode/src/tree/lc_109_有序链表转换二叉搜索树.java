/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package tree;


import linkedList.ListNode;

import java.util.List;

/**
 * 有序链表转换二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9], 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *      0
 *     / \
 *   -3   9
 *   /   /
 * -10  5
 * https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/solution/java-liang-chong-fang-fa-jie-ti-by-zxy0917/
 * 思路：
 * 因为链表是有序的，我们递归时每次把中间的数加为节点进行构造二叉树就可以了，这个每次找链表的中间节点依旧可以使用快慢指针的方法进行找。
 * 找中间节点和构造二叉树便是此题的重点啦，找中间的节点也可以使用数组，就是把链表的数据都存到数组中，然后每次找中间的节点。
 * 时间复杂度：O(N)，每个元素只访问一次。
 * 空间复杂度：O(N)
 * @author luweiliang
 * @created 2020/3/23
 */
public class lc_109_有序链表转换二叉搜索树 {

    public static TreeNode sortedHeadToBST(ListNode head){
        if (head == null || head.next == null) return null;
        return helper(head, null);
    }

    public static TreeNode helper(ListNode head, ListNode tail){
        if (head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.data);
        root.left = helper(head, slow);
        root.right = helper(slow.next, tail);

        return root;
    }


    public static void main (String[] args) {
//        ListNode head = new ListNode(1);
//        ListNode a = new ListNode(2);
//        ListNode b = new ListNode(3);
//        ListNode c = new ListNode(4);
//        ListNode d = new ListNode(5);
//        ListNode e = new ListNode(6);

        ListNode head = new ListNode(-10);
        ListNode a = new ListNode(-3);
        ListNode b = new ListNode(0);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(9);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
//        d.next = e;

        TreeNode treeNode = sortedHeadToBST(head);
        List<Integer> list = lc_144_二叉树前序遍历.preOrder(treeNode);
        System.out.println(list);
    }
}
