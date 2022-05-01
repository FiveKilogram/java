/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 环形链II_入环的第一个结点
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
 *
 * @author luweiliang
 * @created 2020/3/21
 */
public class Lc_142_环形链II_入环的第一个结点 {

    public  static ListNode detectCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                break;
            }
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public static void main (String[] args){
        ListNode head = new ListNode();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = d;
        ListNode listNode = detectCycle(head);
        System.out.println(listNode.data);
    }
}
