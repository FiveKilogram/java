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
 * @created 2020/11/20
 */
public class 死锁的代码 {

    /**
     * 死锁发生的必要条件：
     * 互斥条件：一个资源每次只能被一个进程使用。
     * 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
     * 不剥夺条件:进程已获得的资源，在末使用完之前，不能强行剥夺。
     * 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
     */
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    /**
     * 线程1获取lock1后，500ms后想获取lock2锁，但是此时thread2获取了锁，
     * 因此，thread1在等待thread2释放lock2，同时thread2在等待thread1释放lock1。循环等待，产生死锁。
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    try{
                        System.out.println(Thread.currentThread().getName()+"获得了lock1锁");
                        Thread.sleep(500);//sleep的原因是等待thread2获取锁
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println(Thread.currentThread().getName()+"获得了lock2锁");
                    }
                }
            }
        },"Thread1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2){
                    try{
                        System.out.println(Thread.currentThread().getName()+"获得了lock2锁");
                        Thread.sleep(500);
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println(Thread.currentThread().getName()+"获得了lock1锁");
                    }
                }
            }
        },"Thread2");
        thread1.start();
        thread2.start();
    }
}
