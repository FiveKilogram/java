/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package queueStack;

import java.util.*;

/**
 *
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * 实现 MinStack 类:
 *
 * MinStack() 初始化堆栈对象。
 * void push(int val) 将元素val推入堆栈。
 * void pop() 删除堆栈顶部的元素。
 * int top() 获取堆栈顶部的元素。
 * int getMin() 获取堆栈中的最小元素。
 *
 * 示例:
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 输出：
 * [null,null,null,null,-3,null,0,-2]

 * @author luweiliang
 * @created 2019/8/26
 */
public class lc_155_最小栈 {

    //初始化
    Stack<Integer> A,B;
    public lc_155_最小栈() {
        A = new Stack<>();
        B = new Stack<>();
    }
    //入队，如果插入值，当前插入值小于栈顶元素，则入栈，栈顶元素保存的则为当前栈的最小元素
    public void push(int x) {
        A.push(x);
        if (B.isEmpty() || B.peek() >= x) {
            B.push(x);
        }

    }
    //出栈，如果A出栈等于B栈顶元素，则说明此时栈内的最小元素改变了。
    //这里需要使用 equals() 代替 == 因为 Stack 中存储的是 int 的包装类 Integer
    public void pop() {
        if (A.pop().equals(B.peek()) ) {
            B.pop();
        }
    }
    //栈顶元素为 A 栈
    public int top() {
        return A.peek();
    }

    public int getMin() {
        return B.peek();
    }

    public static void main(String[] args) {
        lc_155_最小栈 minStack = new lc_155_最小栈();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();   // --> 返回 -3.
        minStack.pop();
        minStack.top();      // --> 返回 0.
        minStack.getMin();   // --> 返回 -2.

    }
}
