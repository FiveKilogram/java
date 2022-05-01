/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package thread;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/4/27
 */
public class 多线程按照执行顺序打印 {

    /**
     * 多线程按照执行顺序打印
     * thread1
     * thread2
     * thread3
     * -----------------
     * thread1
     * thread2
     * thread3
     * .....
     * @throws InterruptedException
     */
    public static void print() throws InterruptedException{
        HashSet<Integer> set = new LinkedHashSet<>();
        set.add(1);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Thread thread1 = new Thread(() -> {
            System.out.println("thread1");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("thread2");
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("thread3");
        });

//        thread1.start();
//        thread1.join();
//        thread2.start();
//        thread1.join();
//        thread3.start();

        ExecutorService service = Executors.newSingleThreadExecutor();

        service.submit(thread1);
        service.submit(thread2);
        service.submit(thread3);
        service.shutdown();
    }

    public static void main(String[] args) throws InterruptedException{
        for (int i = 0; i < 10; i++) {
            print();
            Thread.sleep(100);
            System.out.println("-----------------");
        }
    }
}
