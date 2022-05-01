/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 输入: 1->2->3->4->5->NULL, k = 2 输出: 4->5->1->2->3->NULL
 * 解释: 向右旋转 1 步: 5->1->2->3->4->NULL 向右旋转 2 步: 4->5->1->2->3->NULL
 * 头结点化简代码,可以遍历到newHead前一个节点；
 * 用双指针节点一个遍历到末尾，一个留下k个未遍历；
 * 完成两次遍历后，将该链接的节点连起来就行了。
 *
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * @author luweiliang
 * @created 2020/4/25
 */
public class Lc_61_旋转链表 {
    public static ListNode rotateRight(ListNode head, int k){
        if(k == 0 || head == null) return head;

        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode temp = prev;

        int len = 0;
        //求出链表的长度
        while (prev.next != null){
            prev = prev.next;
            len ++;
        }
        //边界条件判断，k可能大于len，所以要取模
//        k = k % len;
//        if (k == 0) return head;
        if (k % len == 0) return head;

        for (int i = 0; i < len - k; i ++){
            temp = temp.next;
        }

        //记录next的位置，也就是返回值的头结点
        ListNode newNode = temp.next;
        //断开连接
        temp.next = null;
        //上一个节点的下一个节点指向头节点
        prev.next = head;
        return newNode;
    }

    /**
     * https://leetcode-cn.com/problems/rotate-list/solution/dong-hua-yan-shi-kuai-man-zhi-zhen-61-xu-7bp0/
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight1(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        // 计算链表中节点个数
        int len = calculateLen(head);
        k = k%len;

        // 慢指针初始指向头节点
        ListNode slow = head;
        // 快指针初始指向头节点
        ListNode fast = head;

        // 快指针先向前移动k步
        for(int i = 0; i < k; i++) {
            fast= fast.next;
        }

        // 快慢指针同时向前移动，直到快指针指向的节点的
        // 下一个节点为null
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 快指针此时在链表末尾
        // 然后其指向的节点的后继指针指向头节点
        // 这时链表首尾相连成环
        fast.next = head;
        // 新的头节点是慢指针所指节点的下一个节点
        head = slow.next;
        // 慢指针所指节点的的后继指针指向null
        // 断开环
        slow.next = null;
        return head;
    }

    private static int calculateLen(ListNode head){
        int len = 0;
        while (head!=null) {
            head = head.next;
            len++;
        }
        return len;
    }

    public static void main (String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        head.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode listNode = rotateRight(head, 2);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
