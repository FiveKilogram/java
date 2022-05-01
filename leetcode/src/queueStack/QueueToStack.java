/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package queueStack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现棧
 * https://leetcode-cn.com/problems/implement-stack-using-queues/solution/yong-dui-lie-shi-xian-zhan-by-leetcode/
 * @author luweiliang
 * @created 2020/3/4
 */
public class QueueToStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    int top = 0;

    public void push(int x){
        q1.add(x);
        top = x;
    }

    public void pop(){
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }


    public int pop1() {
        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        int top1 = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return top1;
    }

    public static void main(String[] args) {
        QueueToStack queueToStack = new QueueToStack();
        queueToStack.push(1);
        queueToStack.push(2);
        queueToStack.push(3);
        queueToStack.pop();
        queueToStack.pop();
        queueToStack.push(4);
        queueToStack.pop();

//        System.out.println(queueToStack.pop1());
//        System.out.println(queueToStack.pop1());
//        queueToStack.push(4);
//        System.out.println(queueToStack.pop1());


    }
}
