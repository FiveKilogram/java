/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例: 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 时间复杂度O(n)
 * 时间复杂度O(1)
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @author luweiliang
 * @created 2020/4/9
 */
public class Lc_24_两两交换链表中的节点 {

    /**
     * 链表两两交换
     * 链表：1->2->3->4
     *
     * 第一轮交换
     *  1、定义一个虚拟头节点dummy，指针指向dummy节点；
     *  2、dummy的下一个节点指向元素2；
     *  3、元素2下一个节点指向元素1；
     *  4、元素1下一个节点指向元素3；
     *  5、一轮完成后，2->1->3->4；
     *  6、下一轮开始，指针指向元素1的节点，然后继续两两交换
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head){
        if (head == null || head.next == null) return head;

        //0->1->2->3->4
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null){
            //1->2->3->4
            ListNode start = temp.next;
            //2->3->4
            ListNode end = temp.next.next;
            //0->2
            temp.next = end;
            //1->3
            start.next = end.next;
            //2->1
            end.next = start;
            //下一轮的开始节点：1->3->4
            temp = start;
            //第一轮结束后：0->2->1->3->4
        }
        return dummy.next;
    }


    /**
     * 链表两两交换
     * 链表：1->2->3->4
     *
     * 第一轮交换
     *  1、定义一个虚拟头节点dummy，指针指向dummy节点；
     *  2、dummy的下一个节点指向元素2；
     *  3、元素2下一个节点指向元素1；
     *  4、元素1下一个节点指向元素3；
     *  5、一轮完成后，2->1->3->4；
     *  6、下一轮开始，指针指向元素1的节点，然后继续两两交换
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs1(ListNode head) {
        //特殊情况处理，节点数量小于2
        if (head == null || head.next == null) {
            return head;
        }
        //必须定义一个dummy节点，从而记住最后链表的头部
        ListNode dummy = new ListNode(0);
        //自定义节点next与链表链接上
        dummy.next = head;
        //需要一个节点记住，发生交换前，上一次交换的末尾节点索引点
        ListNode prev = dummy;

        //下一次交换的下一个节点，下下个节点都不为空才能交换
        while (prev.next != null && prev.next.next != null) {
            //定义下一次交换的第一个节点
            ListNode start = prev.next;
            //定义下一次交换的第二个节点
            ListNode then = prev.next.next;
            //第一个和第二个节点位置交换
            //这里有个必须注意的是，链表位置交换，比如1->2->3->4->5，这个链表，2和3要交换。执行交换操作就是
            //1先指向3，然后2执行4，最后3指向2,这样就链接起来了。
            prev.next = then;
            start.next = then.next;
            then.next = start;
            //最后更新下一次交换前的上个节点node
            prev = start;
        }
        return dummy.next;
    }

    public static void main (String[] args) {
        ListNode head = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);

        head.next = b;
        b.next = c;
        c.next = d;
        ListNode listNode = swapPairs1(head);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
