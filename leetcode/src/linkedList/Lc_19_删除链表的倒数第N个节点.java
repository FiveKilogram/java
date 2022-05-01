/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：给定一个链表: 1->2->3->4->5, 和 n = 2. 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明： 给定的 n 保证是有效的。
 * 进阶：你能尝试使用一趟扫描实现吗？
 * 上述算法可以优化为只使用一次遍历。我们可以使用两个指针而不是一个指针。第一个指针从列表的开头向前移动n+1 步，
 * 而第二个指针将从列表的开头出发。现在，这两个指针被 n 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，
 * 直到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第 n 个结点。
 * 我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/shuang-zhi-zhen-by-reedfan/
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/solution/19-shan-chu-lian-biao-de-dao-shu-di-n-ge-jie-dian-/
 * 时间复杂度 O(n)
 * 空间复杂度：O(1)
 * @author luweiliang
 * @created 2020/3/16
 */
public class Lc_19_删除链表的倒数第N个节点 {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i ++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd1(ListNode hade, int n) {
        ListNode dummy = new ListNode(0);
        ListNode fast = dummy;
        ListNode slow = dummy;
        dummy.next = hade;

        while (n != 0) {
            fast = fast.next;
            n --;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
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
        ListNode listNode = removeNthFromEnd(head, 2);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }


}
