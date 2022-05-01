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
 * @created 2019/11/25
 */
public class Chain {

    /**
     * 链表反转
     * @param node
     * @return
     */
    public static ListNode reverse(ListNode node){
        if (node == null || node.next == null) {
            return node;
        }
        ListNode preNode = null;
        ListNode currNode = node;
        while(currNode != null){
            ListNode nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        return preNode;
    }

    private static void print(ListNode node){
        System.out.println(node.data);
        if (node.next != null) {
            print(node.next);
        }
    }

    public static ListNode reveser1(ListNode node){
        if (node == null || node.next == null) {
            return node;
        }
        ListNode pre = null;
        ListNode curr = node;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        return pre;
    }

    public static ListNode reveser2(ListNode node, int m, int n){
        if (node == null || node.next == null) {
            return node;
        }
        ListNode pre = null;
        ListNode curr = node;
        while (m > 0){
            pre = curr;
            curr = curr.next;
            m --;
            n --;
        }


        ListNode conn = pre, tail = curr;

        while(n > 0){
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
            n --;
        }
        if (conn != null) {
            conn.next = pre;
        }else{
            node = pre;
        }
        tail.next = curr;
        return node;
    }

    /**
     * 单链表是否有环
     * https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-jian-ce-de-liang-chong-jie-fa-/
     * https://leetcode-cn.com/problems/linked-list-cycle/solution/javashuang-gao-dai-ma-jian-dan-yi-dong-by-lgskoko/
     * @param head
     * @return
     */
    public static boolean isLoop(ListNode head){

        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 是否回文链表
     * https://leetcode-cn.com/problems/palindrome-linked-list/solution/wo-de-kuai-man-zhi-zhen-du-cong-tou-kai-shi-gan-ju/
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head){
        if (head == null || head.next == null){
            return false;
        }
        ListNode slow  = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next !=null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while(pre != null && slow != null){
            if (pre.data != slow.data) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
//        if(head == null || head.next == null) {
//            return true;
//        }
//        ListNode slow = head, fast = head;
//        ListNode pre = head, prepre = null;
//        while(fast != null && fast.next != null) {
//            pre = slow;
//            slow = slow.next;
//            fast = fast.next.next;
//            pre.next = prepre;
//            prepre = pre;
//        }
//        if(fast != null) {
//            slow = slow.next;
//        }
//        while(pre != null && slow != null) {
//            if(pre.data != slow.data) {
//                return false;
//            }
//            pre = pre.next;
//            slow = slow.next;
//        }
//        return true;
    }

    public static void main(String[] args) {

//        ListNode head = new ListNode();
//        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);
//        ListNode f = new ListNode(6);
//
//        head.next = a;
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        e.next = f;
//        f.next = d;
//        System.out.println(isLoop(head));

        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(1);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(isPalindrome(head));
//        reveser1(n1);
//
////        reveser2(n1, 1,2);
//
//        print(n5);
    }
}
