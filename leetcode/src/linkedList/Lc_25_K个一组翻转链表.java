/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * K个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
 * @author luweiliang
 * @created 2020/12/7
 */
public class Lc_25_K个一组翻转链表 {

    /**
     * K个一组翻转链表
     * 示例：
     * 给你这个链表：1->2->3->4->5
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * 时间复杂度：O(n)，其中 n 为链表的长度。每次停留需要进行一次 O(k)的翻转操作。
     * 空间复杂度：O(1)，我们只需要建立常数个变量。
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) {
            return head;
        }
        // 上次翻转后的链表的尾节点
        ListNode tail = null;
        // 本次待翻转链表的头，也是本次翻转完成后的新链表的尾节点
        ListNode start = head;
        while (start != null) {
            // 根据k寻找待翻转链表的尾
            int count = 0;
            ListNode end = start;
            while (++count != k) {
                end = end.next;
                // 如果end为空，说明循环即将到尾部，且末尾不足k个元素
                if (end == null) {
                    return head;
                }
            }
            // 保存好下次翻转的链表的头
            ListNode nextListNode = end.next;
            // 翻转start-end中的链表，并返回头节点
            ListNode newHead = reverseListNode(start, end);
            if (tail != null) {
                // 将已翻转后的链表的尾节点连接上下次翻转的链表的头，也就是将翻转后的链表接到总链表上去
                tail.next = newHead;
            } else {
                // 此时翻转后的链表节点就为整个链表的新头节点
                head = newHead;
            }
            // 本次翻转后的链表的尾节点连接上下一个待翻转链表的头节点
            start.next = nextListNode;
            // 保存上一次翻转的链表的尾结点，以便连接上本次翻转链表的头节点
            tail = start;
            // 准备进行新一轮的链表反转
            start = nextListNode;
        }
        return head;
    }

    private static ListNode reverseListNode(ListNode start, ListNode end) {
        ListNode tmp = null;
        while (tmp != end) {
            ListNode next = start.next;
            start.next = tmp;
            tmp = start;
            start = next;
        }
        return tmp;
    }

    /**
     * 递归实现
     * 
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup1(ListNode head, int k) {
        // 递归终止条件，当head为null时中止递归
        if (head == null) {
            return null;
        }
        // 根据k寻找待翻转链表的尾
        ListNode end = head;
        for (int i = 0; i < k - 1; i++) {
            end = end.next;
            if (end == null) {
                return head;
            }
        }
        // 保存好下次翻转的链表的头
        ListNode nextListNode = end.next;
        // 翻转[start , end]范围中的链表，并返回头节点
        ListNode newHead = reverseListNode(head, end);
        // 此时head已经变成了链表的尾节点
        // 本次翻转后的链表的尾节点连接上下一个待翻转链表的头节点，递归实现
        head.next = reverseKGroup1(nextListNode, k);
        return newHead;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
//        ListNode f = new ListNode(6);
//        ListNode g = new ListNode(7);

        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
//        e.next = f;
//        f.next = g;

        ListNode listNode = reverseKGroup(head, 3);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
