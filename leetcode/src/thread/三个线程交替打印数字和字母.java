/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package thread;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/3/28
 */
public class 三个线程交替打印数字和字母 {

    private static char c = 'a';
    private static int i = 0;
    public static void main (String[] args){
        print1();
//        print2();
//        print3();
    }

    private static void print1() {
        Thread t = new Thread() {
            public void run () {
               int threadId = Integer.parseInt(Thread.currentThread().getName());
                while (i < 26){
                    if (i % 3 == threadId - 1){
                        System.out.println(threadId + " " + (char) c++);
                        i ++;
                        if (i == 26) {
                            System.out.println("成功");
                        }
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread t1 = new Thread(t, "1");
        Thread t2 = new Thread(t, "2");
        Thread t3 = new Thread(t, "3");
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 三个线程交叉打印数字和字母
     * 1 a
     * 2 b
     * 3 c
     * 1 d
     * 2 e
     * 3 f
     * .......
     */
    public static void print2(){
        Object o = new Object();
        Thread t = new Thread(() -> {
            synchronized (o) {
                int threadId = Integer.parseInt(Thread.currentThread().getName());
                while (i < 26) {
                    if (i % 3 == threadId - 1) {
//                        System.out.println(i % 3 );
//                        System.out.println(threadId - 1);
                        System.out.println(threadId + " " + (char) c ++);
                        i ++;
                        if (i == 26) {
                            System.out.println("打印结束");
                        }
                        o.notifyAll();
                    } else {
                        try {
//                            System.out.println(" o.wait()");
                            o.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t1 = new Thread(t, "1");
        Thread t2 = new Thread(t, "2");
        Thread t3 = new Thread(t, "3");
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * 三个线程打印数字
     * 123123123123。。。。
     */
    public static void print3(){
        Object o = new Object();
        Thread t = new Thread(() -> {
            synchronized (o) {
                int threadId = Integer.parseInt(Thread.currentThread().getName());
                while (true) {
                    if (i % 3 == threadId - 1) {
                        System.out.println(threadId);
                        i ++;
                        o.notifyAll();
                    } else {
                        try {
                            o.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t1 = new Thread(t, "1");
        Thread t2 = new Thread(t, "2");
        Thread t3 = new Thread(t, "3");
        t1.start();
        t2.start();
        t3.start();
    }
}
