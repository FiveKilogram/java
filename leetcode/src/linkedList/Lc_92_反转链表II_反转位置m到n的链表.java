/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package linkedList;

/**
 * 反转链表 II(反转从位置 m 到 n 的链表。请使用一趟扫描完成反转）
 * https://leetcode-cn.com/problems/reverse-linked-list-ii/solution/4-ge-zhi-zhen-3-ge-zhi-zhen-by-liweiwei1419/
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * 时间复杂度:O(N)
 * 空间复杂度:O(1)
 * @author luweiliang
 * @created 2020/3/19
 */
public class Lc_92_反转链表II_反转位置m到n的链表 {

    /**
    //思路：head表示需要反转的头节点，pre表示需要反转头节点的前驱节点
    //我们需要反转n-m次，我们将head的next节点移动到需要反转链表部分的首部，需要反转链表部分剩余节点依旧保持相对顺序即可
    //比如1->2->3->4->5,m=1,n=5
    //第一次反转：1(head) 2(next) 3 4 5 反转为 2 1 3 4 5
    //第二次反转：2 1(head) 3(next) 4 5 反转为 3 2 1 4 5
    //第三次发转：3 2 1(head) 4(next) 5 反转为 4 3 2 1 5
    //第四次反转：4 3 2 1(head) 5(next) 反转为 5 4 3 2 1
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode *dummy=new ListNode(-1);
        dummy->next=head;
        ListNode *pre=dummy;
        for(int i=1;i<m;++i)pre=pre->next;
        head=pre->next;
        for(int i=m;i<n;++i){
            ListNode *nxt=head->next;
            //head节点连接nxt节点之后链表部分，也就是向后移动一位
            head->next=nxt->next;
            //nxt节点移动到需要反转链表部分的首部
            nxt->next=pre->next;
            pre->next=nxt;//pre继续为需要反转头节点的前驱节点
        }
        return dummy->next;
     **/

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) return head;

        ListNode dummp = new ListNode(0);
        dummp.next = head;
        ListNode prev = dummp;

        for (int i = 1; i < m; i ++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        for (int i = 0; i < n - m; i ++){
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummp.next;
    }

    public  static ListNode reverseBetween2(ListNode head, int m, int n){
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = dummy.next;

        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
            cur = cur.next;
        }

        for (int i = 0; i < n - m; i ++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }
        return dummy.next;
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
        ListNode listNode = reverseBetween2(head, 2,4);
        while (listNode != null) {
            System.out.println(listNode.data);
            listNode = listNode.next;
        }
    }
}
