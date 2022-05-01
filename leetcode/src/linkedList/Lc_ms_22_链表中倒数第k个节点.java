/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/3/20
 */
public class Lc_ms_22_链表中倒数第k个节点 {

    public static ListNode getKthFromEnd(ListNode head, int k){
        if (head == null) return head;

        ListNode q = head;
        ListNode h = head;
        for (int i = 0; i < k; i ++) {
            q = q.next;
        }
        while (q != null) {
            q = q.next;
            h = h.next;
        }
        return h;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        ListNode e = new ListNode(6);
//        ListNode f = new ListNode(6);

        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
//        e.next = f;
        ListNode listNode = getKthFromEnd(head, 2);
        System.out.println(listNode.data);
    }

}
