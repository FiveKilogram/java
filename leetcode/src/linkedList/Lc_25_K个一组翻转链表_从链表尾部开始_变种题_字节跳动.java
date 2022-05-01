/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * K个一组翻转链表_从链表尾部开始
 *
 * 给定单链表的头结点 head，实现一个调整链表的函数，从链表尾部开始，以 K 个结点为一组进行逆序翻转，头部剩余结点不足一组时，不需要翻转。
 * 示例：
 * 给你这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 1->3->2->5->4
 * 当 k = 3 时，应当返回: 1->2->5->4->3
 * https://www.cnblogs.com/plokmju/archive/2004/01/13/linkedreverse_toutiao.html
 * @author luweiliang
 * @created 2020/12/7
 */
public class Lc_25_K个一组翻转链表_从链表尾部开始_变种题_字节跳动 {

    /**
     * K个一组翻转链表_从链表尾部开始
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroupPlus(ListNode head, int k) {
        // 翻转链表
        head = reverseList(head);
        // K 个一组翻转链表
        head = reverseKGroup(head, k);
        // 翻转链表
        head = reverseList(head);
        return head;
    }

    /**
     * K个一组翻转链表_从链表尾部开始
     * 最优解
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroupPlus_最优解答(ListNode head, int k) {
        if (head == null || k <= 1) return head;
        // 计算原始链表长度
        int length = linkedLength(head);
        if (length < k)
            return head;

        // 计算 offset
        int offsetIndex = length % k;

        // 原始链表正好可以由 K 分为 N 组，可直接处理
        if (offsetIndex == 0) {
            return reverseKGroup(head, k);
        }

        // 定义并找到 prev 和 offset
        ListNode prev = head, offset = head;
        while (offsetIndex > 0) {
            prev = offset;
            offset = offset.next;
            offsetIndex --;
        }
        // 将 offset 结点为起始的子链表进行翻转，再拼接回主链表
        prev.next = reverseKGroup(offset, k);
        return head;
    }

    /**
     * 时间复杂度：O(n)，其中 nn 为链表的长度。
     * 空间复杂度：O(1)，我们只需要建立常数个变量。
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // 增加虚拟头结点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 定义 prev 和 end 结点
        ListNode prev = dummy;
        ListNode end = dummy;

        while(end.next != null) {
            // 以 k 个结点为条件，分组子链表
            for (int i = 0; i < k && end != null; i++)
                end = end.next;
            // 不足 K 个时不处理
            if (end == null)
                break;
            // 处理子链表
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;
            // 翻转子链表
            prev.next = reverseList(start);
            // 将子连表前后串起来
            start.next = next;
            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    // 递归完成单链表翻转
    private static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    private static int linkedLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
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

//        System.out.println("--------------------从链表尾部开始反转，一般--------------------");
//
//        ListNode listNode1 = reverseKGroupPlus(head, 2);
//        while (listNode1 != null) {
//            System.out.println(listNode1.data);
//            listNode1 = listNode1.next;
//        }

        System.out.println("--------------------从链表尾部开始反转,最优解--------------------");
        ListNode listNode2 = reverseKGroupPlus_最优解答(head, 2);
        while (listNode2 != null) {
            System.out.println(listNode2.data);
            listNode2 = listNode2.next;
        }
    }
}
