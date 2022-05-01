/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 * 示例 1:输入: head = [4,5,1,9], node = 5 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2: 输入: head = [4,5,1,9], node = 1 输出: [4,5,9]
 * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *
 * 说明:
 * 链表至少包含两个节点。
 * 链表中所有节点的值都是唯一的。
 * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * 不要从你的函数中返回任何结果。
 * @author luweiliang
 * @created 2020/3/20
 */
public class Lc_面试题18_删除链表的节点 {

    public static ListNode deleteListNode (ListNode head, int data) {
        if (head == null) return head;
        if (head.data == data) return head.next;

        ListNode prev = head;
        ListNode cur = head;

        while (cur != null && cur.data != data) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return head;
    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head.data == val) return head.next;

        ListNode prev = head;
        ListNode cur = head;

        while (cur != null && cur.data != val) {
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        return head;
    }

    public static void main (String[] args) {
        ListNode head = new ListNode(4);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(9);

        head.next = b;
        b.next = c;
        c.next = d;
        ListNode listNode = deleteListNode(head,5);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
