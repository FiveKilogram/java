/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 82_删除排序链表中的重复元素II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 * 示例 1: 输入: 1->2->3->3->4->4->5 输出: 1->2->5
 * 示例 2: 输入: 1->1->1->2->3 输出: 2->3
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/solution/java-ya-jie-dian-fei-di-gui-rong-yi-li-jie-yong-sh/
 * @author luweiliang
 * @created 2020/4/6
 */
public class Lc_82_删除排序链表中的重复元素II {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {
            if (cur.next.data == cur.next.next.data) {
                int data = cur.next.data;
                while (cur.next != null && cur.next.data == data) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main (String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);

        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        ListNode listNode = deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
