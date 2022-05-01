/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 链表的中间节点
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个中间结点。
 * 输入：[1,2,3,4,5,6] 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 * @author luweiliang
 * @created 2020/4/11
 */
public class Lc_876_链表的中间节点 {

    public static ListNode middleNode(ListNode head){
        if(head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode listNode = middleNode(head);
        System.out.println(listNode.data);
    }
}
