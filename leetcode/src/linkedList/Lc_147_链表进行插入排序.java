/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 对链表进行插入排序
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 * 输入: 4->2->1->3 输出: 1->2->3->4
 * 插入排序算法：
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 * 时间复杂度：O(n^2)，其中 nn 是链表的长度。
 * 空间复杂度：O(1)
 *
 * https://leetcode-cn.com/problems/insertion-sort-list/solution/dui-lian-biao-jin-xing-cha-ru-pai-xu-by-leetcode-s/
 * @author luweiliang
 * @created 2020/4/11
 */
public class Lc_147_链表进行插入排序 {

    public static ListNode insertSort(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head, temp = null, prev = null;

        while (cur != null && cur.next != null) {
            if (cur.data <= cur.next.data) {
                cur = cur.next;
            } else {
                temp = cur.next;
                cur.next = temp.next;
                prev = dummy;
                while (prev.next.data <= temp.data) {
                    prev = prev.next;
                }
                temp.next = prev.next;
                prev.next = temp;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode listNode = insertSort(head);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
