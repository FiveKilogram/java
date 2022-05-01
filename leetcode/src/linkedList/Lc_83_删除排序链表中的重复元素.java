/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 83_删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次.
 * 示例 1:输入: 1->1->2 输出: 1->2
 * 示例 2:输入: 1->1->2->3->3 输出: 1->2->3
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/solution/hua-jie-suan-fa-83-shan-chu-pai-xu-lian-biao-zhong/
 * @author luweiliang
 * @created 2020/4/6
 */
public class Lc_83_删除排序链表中的重复元素 {

    public static ListNode deleteDuplicates (ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.data == cur.data) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main (String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(3);

        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode listNode = deleteDuplicates(head);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
