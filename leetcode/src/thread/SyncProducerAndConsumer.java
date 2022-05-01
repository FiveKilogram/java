/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用synchronized对存储加锁，然后用object原生的wait() 和 notify()做同步
 *
 * @author luweiliang
 * @created 2020/5/2
 */
public class SyncProducerAndConsumer {

    private final int MAX_LEN = 10;
    private Queue<Integer> queue = new LinkedList<Integer>();
    class Producer extends Thread {
        @Override
        public void run() {
            producer();
        }
        private void producer() {
            while(true) {
                synchronized (queue) {
                    while (queue.size() == MAX_LEN) {
                        queue.notify();
                        System.out.println("当前队列满");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    queue.notify();
                    System.out.println("生产者生产一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    class Consumer extends Thread {
        @Override
        public void run() {
            consumer();
        }
        private void consumer() {
            while (true) {
                synchronized (queue) {
                    while (queue.size() == 0) {
                        queue.notify();
                        System.out.println("当前队列为空");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.poll();
                    queue.notify();
                    System.out.println("消费者消费一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SyncProducerAndConsumer pc = new SyncProducerAndConsumer();
        SyncProducerAndConsumer.Producer producer = pc.new Producer();
        SyncProducerAndConsumer.Consumer consumer = pc.new Consumer();
        producer.start();
        consumer.start();
    }
}
