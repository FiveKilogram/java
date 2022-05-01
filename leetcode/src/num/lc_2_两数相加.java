/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

/**
 *
 * 两数相加
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
 * @author luweiliang
 * @created 2019/8/26
 */
public class lc_2_两数相加 {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2!= null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode addtwoNum (ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
//        ListNode x = l1, y = l2;
        while (l1 != null && l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static ListNode addTwoNum2(ListNode l1, ListNode l2) {
        int carry = 0;  //是否有进为
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while (l1 != null && l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int num = carry + x + y;
            carry = num / 10;
            curr.next = new ListNode(num % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry == 1) {
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }

    /**
     * 两数相加
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNum3(ListNode l1, ListNode l2){
        int carry = 0; //是否有进为
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while (l1 != null && l2 != null) {
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            int num = carry + x + y;
            carry = num / 10;
            curr.next = new ListNode(num % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static ListNode twoSumAdd(ListNode l1, ListNode l2){
        int carry = 0;   //进位数
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while(l1 != null && l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(carry == 1){
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static ListNode twoAdd(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while(l1 != null && l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int num = carry + x + y;
            carry = num / 10;
            curr.next = new ListNode(num % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) {
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static ListNode twoAdd2 (ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while(l1 != null && l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int num = carry + x + y;
            carry = num / 10;
            curr.next = new ListNode(num % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static ListNode twoAdd3(ListNode l1, ListNode l2){
        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while (l1 != null && l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int num = carry + x + y;
            carry = num / 10;
            curr.next = new ListNode(num % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
         }
         if (carry > 0) {
            curr.next = new ListNode(carry);
         }
         return pre.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode twoNumAdd(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while (l1 != null && l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l1 == null ? 0 : l2.val;
            int num = carry + x + y;
            carry = num / 10;
            curr.next = new ListNode(num % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }
    public static ListNode twoSumAdd1(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pre = new ListNode(0);
        ListNode curr = pre;
        while (l1 != null && l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int num = carry + x + y;
            carry = num / 10;
            curr.next = new ListNode(num % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return pre.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l11 = new ListNode(4);
        ListNode l111 = new ListNode(3);
        l1.next = l11;
        l11.next = l111;

        ListNode l2 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l222 = new ListNode(4);
        l2.next = l22;
        l22.next = l222;

        ListNode node = addTwoNumbers(l1,l2);
        while(node != null){
            System.out.print(node.val+" ");
            node = node.next;
        }
    }
}