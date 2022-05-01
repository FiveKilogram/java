/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/solution/shuang-zhi-zhen-jie-jue-by-sheng-tian-ban-zi-4/
 * 时间复杂度 O(M+N)
 * 空间复杂度：O(1)
 * // 1 - 2 - 3 \
 * //            6 - 7
 * //     4 - 5 /
 * @author luweiliang
 * @created 2020/3/23
 */
public class Lc_两个链表的第一个公共节点 {

    /**
     * 当指针1访问到A的末尾开始访问B，当指针2访问到B的末尾开始访问A，这样，指针1,2会同时访问到公共节点
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode getIntersectionNode(ListNode l1, ListNode l2){
        if (l1 == null || l2 == null) return null;

        ListNode node1 = l1;
        ListNode node2 = l2;

        while (node1 != node2) {
            node1 = node1 == null ? l2 : node1.next;
            node2 = node2 == null ? l1 : node2.next;
        }
        return node1;
    }

    public static void main (String[] args) {
        // 1 - 2 - 3 \
        //            6 - 7
        //     4 - 5 /
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        // 第一个node
        node1.next = node2;
        node2.next = node3;
        node3.next = node6;
        node6.next = node7;

        // 第二个node
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        ListNode listNode = getIntersectionNode(node1, node4);
        System.out.println(listNode.data);
    }
}
