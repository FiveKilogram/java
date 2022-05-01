/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

import org.w3c.dom.NodeList;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 合并K个排序链表
 * 合并k个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 时间复杂度O(N log K)
 * 空间复杂度 O(n)
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/gui-bing-pai-xu-by-reedfan/
 * @author luweiliang
 * @created 2020/3/17
 */
public class Lc_23_合并K个排序链表 {

    /**
     * 分治方式 - 优先使用这个方法，性能应该会高一些
     * @param lists
     * @return
     */
    public static ListNode mergeKListNode(ListNode[] lists){
        if (lists == null || lists.length == 0) {
            return null;
        }
        //将lists的[第0个位置]到[第size-1个位置]的元素整体排序，最后返回一个新的有序链表
        return sort(lists, 0, lists.length - 1);
    }

    /**
     * 二分法，将元素整体排序，最后返回一个新的有序链表
     * @param lists
     * @param l
     * @param r
     * @return
     */
    public static ListNode sort(ListNode[] lists, int l, int r){
        //终止条件
        if (l >= r) return lists[l];
        int mid = (r - l) / 2 + l;
        ListNode l1 = sort(lists, l, mid);
        ListNode l2 = sort(lists, mid + 1, r);
        return merge(l1, l2);
    }

    public static ListNode merge(ListNode l1, ListNode l2){
        ListNode dump = new ListNode(0);
        ListNode prev = dump;

        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                dump.next = l1;
                l1 = l1.next;
            } else {
                dump.next = l2;
                l2 = l2.next;
            }
            dump = dump.next;
        }
        //有可能l1或者l2里面还有元素
        dump.next = l1 == null ? l2 : l1;
        return prev.next;
    }

    /**
     * 小顶堆实现
     * 借助 PriorityQueue 方式来构建小顶堆
     * 时间复杂度O(N log K)
     * 空间复杂度 O(k)
     * @param lists
     * @return
     */
    public static ListNode mergeSListNode2 (ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        //构建一个虚拟的头节点
        ListNode dump = new ListNode(0);
        ListNode cur = dump;

        //定义小顶堆，使用优先队列来比较排序；
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a ,b) -> a.data - b.data);

        //将队列的所有元素放到queue中
        for (ListNode list : lists) {
            if (list != null) {
                queue.offer(list);
            }
        }
        //处理整体排序，涉及到queue的取出和放进
        //当小顶堆有元素是，就把元素取出来，取出来的是最小的那个元素
        while (!queue.isEmpty()) {
            //poll出最小值
            cur.next = queue.poll();

            //把取出来最小元素的下一个元素指向当前节点，指针后移
            cur = cur.next;
            //最小值的下一个元素不为空，也就是还有元素
            if (cur.next != null) {
                //将取出来最小值的后面的那个元素再次放到queue中去
                queue.offer(cur.next);
            }
        }
        return dump.next;
    }

    public static ListNode mergeKListNode1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
       return merge(lists, 0, lists.length  -1);
    }

    public static ListNode merge(ListNode[] lists, int left, int right) {
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 =  merge(lists, mid + 1, right);
        return merge1(l1, l2);
    }

    public static ListNode merge1 (ListNode l1, ListNode l2) {
        ListNode dump = new ListNode(0);
        ListNode prev = dump;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                dump.next = l1;
                l1 = l1.next;
            } else {
                dump.next = l2;
                l2 = l2.next;
            }
            dump = dump.next;
        }
        dump.next = l1 == null ? l2 : l1;
        return prev.next;
    }

    public static ListNode mergeKListNode2 (ListNode[] lists){
       if (lists == null || lists.length == 0) {
           return null;
       }
       if (lists.length == 1) {
           return lists[0];
       }
       ListNode dump = new ListNode (0);
       ListNode cur = dump;

       PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a, b) -> (a.data - b.data));

       for (ListNode list : lists) {
           if (list != null) {
               queue.offer(list);
           }
       }

       while (!queue.isEmpty()) {
           ListNode temp = queue.poll();
           cur.next = temp;
           cur = cur.next;
           if (temp.next != null) {
               queue.offer(temp.next);
           }
       }
       return dump.next;
    }

    NodeList[] lists = {};
    public static void main (String[] args) {

        ListNode head = new ListNode(1);
        ListNode a = new ListNode(4);
        ListNode b = new ListNode(5);

        ListNode head1 = new ListNode(1);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);


        ListNode head2 = new ListNode(2);
        ListNode g = new ListNode(6);
        ListNode h = new ListNode(8);

        head.next = a;
        a.next = b;

        head1.next = c;
        c.next = d;

        head2.next = g;
        g.next = h;

//        ListNode[] lists = new ListNode[]{head, head1, head2};
        ListNode[] lists = {head, head1, head2};
        ListNode listNode =  mergeKListNode(lists);
//        ListNode listNode =  mergeSListNode2(lists);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
