/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 147. 对链表进行插入排序
 * https://leetcode-cn.com/problems/sort-list/solution/sort-list-gui-bing-pai-xu-lian-biao-by-jyd/
 *
 * @author luweiliang
 * @created 2020/4/11
 */
public class Lc_148_链表排序链表_归并_快速 {


    public static ListNode sortList (ListNode head) {
        //return mergeSort(head);
        return quickSort(head);
//        return quickSort2(head, null);
//        return quickSort3(head);

    }

    public static ListNode quickSort(ListNode head){
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return quickSort(head, tail);

    }

    /**
     * 快速排序
     * @param head
     * @param tail
     * @return
     */
    public static ListNode quickSort(ListNode head, ListNode tail){
        //判断为空或者是否只有一个节点
        if (head == null || tail == null || head == tail) return head;

        //从第一个节点和第一个节点的后面一个节点，head 指向的是当前遍历到的最后一个<= key的节点
        ListNode first = head;
        ListNode second = head.next;
        int key = head.data;

        //结束条件，next到最后了
        while (second != null && second != tail.next) {
            //一直往后寻找<=key的节点，然后与left的后继节点交换
            if (second.data < key) {
                first = first.next;
                //判断一下，避免后面的数比第一个数小，不用换的局面
                if (first != second) {
                    sw(first, second);
                }
            }
            second = second.next;
        }
        //判断，有些情况是不用换的，提升性能
        if (head != first) {
            sw(head, first);
        }
        //前部分递归
        quickSort(head, first);
        //后部分递归
        quickSort(first.next, tail);
        return head;
    }

    public static void sw(ListNode l1, ListNode l2){
        int temp = l1.data;
        l1.data = l2.data;
        l2.data = temp;
    }

    /**
     * 快速排序
     * @param head
     * @param end
     * @return
     */
    public static ListNode quickSort2(ListNode head, ListNode end){
        if (head == end || head.next == end || head.next.next == end) return head;
        // 将小于划分点的值存储在临时链表中
        ListNode tmpHead = new ListNode(-1);
        //partition为划分点
        ListNode partition = head.next;
        //p为链表指针
        ListNode p = partition;
        //tp为临时链表指针
        ListNode tp = tmpHead;
        // 将小于划分点的结点放到临时链表中
        while (p.next != end){
            if (p.next.data < partition.data){
                tp.next = p.next;
                tp = tp.next;
                p.next = p.next.next;
            }else {
                p = p.next;
            }
        }
        // 合并临时链表和原链表，将原链表接到临时链表后面即可
        tp.next = head.next;
        // 将临时链表插回原链表，注意是插回！（不做这一步在对右半部分处理时就断链了）
        head.next = tmpHead.next;
        quickSort2(head,partition);
        quickSort2(partition,end);
        // 题目要求不带头节点，返回结果时去除
        return head.next;
    }

    /**
     * 快速排序
     * @param head
     * @return
     */
    public static ListNode quickSort3(ListNode head){
        if(head == null || head.next == null) return head;

        int pivot = head.data;
        // 链表划分
        ListNode ls = new ListNode(-1), rs = new ListNode(-1);
        ListNode l = ls, r = rs, cur = head;

        while(cur != null){
            if(cur.data < pivot){
                l.next = cur;
                l = l.next;
            }else{
                r.next = cur;
                r = r.next;
            }
            cur = cur.next;
        }
        l.next = rs.next;
        r.next = null;

        // 递归调用,先重排右边的,再把指针置空,再重排左边的
        // 和归并排序很像的
        ListNode right = quickSort3(head.next);
        head.next = null;
        ListNode left = quickSort3(ls.next);
        // 拼接左半部分和右半部分
        cur = left;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = right;
        return left;
    }

    /**
     * 归并排序
     * @param head
     * @return
     */
    public static ListNode mergeSort (ListNode head){
        if (head == null || head.next == null) return head;
        ListNode midNode = getMidNode(head);
        ListNode rightHead = midNode.next;
        midNode.next = null;
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(rightHead);
        return merge(left, right);
    }

    //找到链表中间节点（Lc_876_链表的中间结点）
    public static ListNode getMidNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // 合并两个有序链表（Lc_21_合并两个有序链表）
    public static ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode res = new ListNode(0);
        ListNode cur = res;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(2);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        //快速排序
        ListNode listNode = sortList(head);
//        //归并排序
//        ListNode listNode = mergeSort(head);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
