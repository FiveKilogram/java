package XieChen;

import java.io.*;
import java.util.*;

public class Main8 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode head=null;
        ListNode node=null;
        int m=in.nextInt();
        while(in.hasNextInt()){
            int v=in.nextInt();
            if(head==null){
                node=new ListNode(v);
                head=node;
            }else{
                node.next=new ListNode(v);
                node=node.next;
            }
        }

        ListNode more = new ListNode(-1);
        ListNode moreHead = more;
        ListNode less = new ListNode(-1);
        ListNode lessHead = less;

        while (head != null){
            if(head.val < m){
                less.next = head;
                less = less.next;
            }else {
                more.next = head;
                more = more.next;
            }
            head = head.next;
        }
        more.next = null;
        less.next = moreHead.next;
        head = lessHead.next;


        if(head!=null){
            System.out.print(head.val);
            head=head.next;
            while(head!=null){
                System.out.print(",");
                System.out.print(head.val);
                head=head.next;
            }
        }else{
            System.out.println(" ");
        }
        System.out.println();
    }
}
