/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/12/31
 */
public class Heap_Stack_溢出的代码 {

    public static void main(String[] args) {
        Heap();
//        Stack();
    }

    //堆溢出
    public static void Heap() {
        ArrayList list = new ArrayList();
        while(true) {
            list.add(new Heap_Stack_溢出的代码());
        }
    }

    //棧溢出
    public static void Stack() {
        new Heap_Stack_溢出的代码().test();
    }

    private void test() {
        test();
    }
}
