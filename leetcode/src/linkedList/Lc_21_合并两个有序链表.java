/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：输入：1->2->4, 1->3->4 输出：1->1->2->3->4->4
 * 时间复杂度 O(n)
 * 空间复杂度：O(1)
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/die-dai-he-di-gui-ban-ben-dong-tai-tu-xiang-jie-by/
 * @author luweiliang
 * @created 2020/3/17
 */
public class Lc_21_合并两个有序链表 {

    public static ListNode mergeTwoListNode(ListNode l1, ListNode l2) {

        ListNode dump = new ListNode(0);
        ListNode prev = dump;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        //有可能l1或者l2里面还有元素
        prev.next = l1 == null ? l2 : l1;
        return dump.next;
    }

    public static ListNode mergeTwoListNode1(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        if (l1.data < l2.data) {
            l1.next = mergeTwoListNode1(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListNode1(l1, l2.next);
            return l2;
        }
    }

    public static void main (String[] args) {

        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);

        ListNode head1 = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(7);

        head.next = a;
        a.next = b;

        head1.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        ListNode listNode = mergeTwoListNode(head, head1);

        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
