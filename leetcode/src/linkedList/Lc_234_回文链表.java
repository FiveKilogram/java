/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 请判断一个链表是否为回文链表
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * https://leetcode-cn.com/problems/palindrome-linked-list/solution/wo-de-kuai-man-zhi-zhen-du-cong-tou-kai-shi-gan-ju/
 *
 * @author luweiliang
 * @created 2020/4/5
 */
public class Lc_234_回文链表 {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head, pre = head, prepre = null;

        while(fast != null && fast.next != null) {
            //pre记录反转的前半个列表，slow一直是原表一步步走
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        //长度是奇数还要走一步才后fast=null,偶数不需要处理
        if (fast != null){
            slow = slow.next;
        }

        while (pre != null && slow != null) {
            if (pre.data != slow.data) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    public static boolean isPalindrome1(ListNode head){
        //如果链表只有一个有效节点或者没有有效节点，return true
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;
        //快慢指针，快指针一次走两步，慢指针一次走一步
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //从slow开始，反转后半段链表
        ListNode prev = null;
        ListNode cur = slow;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        //对比前半段和后半段的data值是否相同
        while (prev != null && head.data != null){
            if(prev.data != head.data){
                return false;
            }
            prev = prev.next;
            head = head.next;
        }
        return true;
    }

    public static void main (String[] args) {
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(1);
        head.next = a;
        a.next = b;
        b.next = c;
        System.out.println(isPalindrome(head));
//        System.out.println(isPalindrome1(head));
        }
}
