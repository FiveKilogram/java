/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package queueStack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 队列实现棧
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/solution/yong-zhan-shi-xian-dui-lie-by-leetcode/
 * @author luweiliang
 * @created 2020/3/4
 */
public class StackToQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    private int front;

    public void push(int x){
        if (s1.isEmpty()) {
            front = x;
        }
        s1.push(x);
    }

    public void pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        s2.pop();

    }


    Stack<Integer> head = new Stack<>();
    Stack<Integer> tail = new Stack<>();

    public void push1(int n){
        tail.push(n);
    }

    public int pop1(){
        if (head.isEmpty()) {
            if (tail.isEmpty()) return -1;

            while (!tail.isEmpty()) {
                head.push(tail.pop());
            }
        }
        return head.pop();
    }

}
