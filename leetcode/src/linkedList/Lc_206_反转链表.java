/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 反转一个单链表
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/
 * https://www.ixigua.com/i6795339052045304334/
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @author luweiliang
 * @created 2020/3/19
 */
public class Lc_206_反转链表 {

    public static ListNode reveser(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        //返回新结点
        ListNode prev = null;
        while (head != null) {
            //头结点的next结点，指向临时结点
            ListNode temp = head.next;
            //头结点的next结点，指向新阶段
            head.next = prev;
            //新结点指向头结点
            prev = head;
            //头结点指向临时结点
            head = temp;
        }
        //返回新结点
        return prev;
    }

    public static ListNode reveser1(ListNode head){
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public static ListNode reveser2(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode node = reveser2(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    /**
     * 反转链表
     * @param head 头节点
     * @return
     */
    private ListNode reverse(ListNode head){
        // pre是指向前一个节点的指针，初始头节点前面的null
        ListNode pre = null;
        // curr是当前节点
        ListNode curr = head;
        while (curr!=null){
            // 记录下一个节点的指针
            ListNode next = curr.next;
            // 将指向下一个节点的指针反转指向前一个节点
            curr.next = pre;
            // 更新前一个节点（后移
            pre = curr;
            // 后移当前节点
            curr = next;
        }
        // 最后pre会移动到最后，但此时由于链表反转pre正好是反转后的头
        return pre;
    }

    public static void main (String[] args) {
        ListNode head = new ListNode();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode listNode = reveser(head);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
