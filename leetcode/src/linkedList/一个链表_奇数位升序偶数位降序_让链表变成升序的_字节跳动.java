/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 *
 * 题目描述：一个链表，奇数位升序偶数位降序，让链表变成升序的。
 * 比如：1 8 3 6 5 4 7 2 9，最后输出1 2 3 4 5 6 7 8 9。
 *
 * 给定一个奇数位升序，偶数位降序的链表，将其重新排序。
 * 输入: 1->8->3->6->5->4->7->2->NULL
 * 输出: 1->2->3->4->5->6->7->8->NULL
 *
 * 分析：
 * 这道题可以分成三步：
 * 首先根据奇数位和偶数位拆分成两个链表。
 * 然后对偶数链表进行反转。
 * 最后将两个有序链表进行合并。
 *
 * 时间复杂度为O(N)，
 * 空间复杂度O(1)。
 *
 * https://www.cnblogs.com/xidian2014/p/8652632.html
 *
 * @author luweiliang
 * @created 2021/3/17
 */
public class 一个链表_奇数位升序偶数位降序_让链表变成升序的_字节跳动 {

    /**
     * 按照奇偶位拆分成两个链表
     * @param head
     * @return
     */
    public static ListNode[] splitList(ListNode head) {
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode cur1 = null;
        ListNode cur2 = null;

        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {   //基数
                if (cur1 != null) {
                    cur1.next = head;
                    cur1 = cur1.next;
                } else {
                    cur1 = head;
                    head1 = cur1;
                }
            } else {                //偶数
                if (cur2 != null) {
                    cur2.next = head;
                    cur2 = cur2.next;
                } else {
                    cur2 = head;
                    head2 = cur2;
                }
            }
            head = head.next;
            count ++;
        }
        //跳出循环，要让最后两个末尾元素的下一个都指向null
        cur1.next = null;
        cur2.next = null;
        ListNode[] heads = new ListNode[]{head1, head2};
        return heads;
    }

    /**
     * 反转链表
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

//    /**
//     * 合并两个有序链表
//     * @param head1
//     * @param head2
//     * @return
//     */
//    public static ListNode mergeLists(ListNode head1, ListNode head2) {
//        if (head1 == null && head2 == null) {
//            return null;
//        }
//        if (head1 == null || head2 == null) {
//            return head1 == null ? head2 : head1;
//        }
//        ListNode first = new ListNode(-1);
//        ListNode cur = first;
//        while (head1 != null && head2 != null) {
//            if (head1.data < head2.data) {
//                cur.next = head1;
//                head1 = head1.next;
//            } else {
//                cur.next = head2;
//                head2 = head2.next;
//            }
//            cur = cur.next;
//        }
//        cur.next = head1 != null ? head1 : head2;
//        return first.next;
//    }

    /**
     * 合并两个有序链表
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeLists(ListNode head1, ListNode head2) {

        ListNode dump = new ListNode(0);
        ListNode prev = dump;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                prev.next = head1;
                head1 = head1.next;
            } else {
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
        }
        prev.next = head1 == null ? head2 : head1;
        return dump.next;
    }

    /**
     * 打印链表
     * @param head
     */
    private static void printList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur.next != null) {
            System.out.print(cur.data + "\t");
            cur = cur.next;
        }
        System.out.println(cur.data);
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        ListNode head = node1;
        printList(head);


        ListNode[] heads = splitList(head);
//        printList(heads[0]);
//        printList(heads[1]);
        ListNode reverseHead = reverseList(heads[1]);   //偶数反转
//        printList(reverseHead);
        ListNode mergeHead = mergeLists(heads[0], reverseHead);   //两个链表合并
        printList(mergeHead);
    }
}
