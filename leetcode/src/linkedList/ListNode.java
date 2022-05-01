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
public class ListNode {

    public Integer data;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(Integer data) {
        this.data = data;
    }

    public ListNode(Integer data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}
