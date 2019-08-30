package Thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class ProducerConsumer {

    private final int MAX_SIZE = 100;
    //定义队列
    private final Queue<Integer> queue = new LinkedList<Integer>();

    public static void main(String[] args) {
        ProducerConsumer producerCustomer = new ProducerConsumer();
        Producer producer = producerCustomer.new Producer();
        Consumer customer = producerCustomer.new Consumer();
        new Thread(producer).start();
        new Thread(customer).start();
    }

class Producer implements Runnable{
    @Override

    public void run() {
        while (true) {
            //lock
            synchronized (queue) {
                if (queue.size() < MAX_SIZE) {
                    //生产者生产
                    int num = new Random().nextInt(100);
                    //将生产的东西放到队列中
                    queue.offer(num);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //生产完毕 唤醒消费者
                    queue.notifyAll();
                    //输出生产者信息
                    System.out.println("producer:" + Thread.currentThread().getName() + "produce" + num + "productSize" + queue.size());
                } else {
                    //队列已满 生产者等待
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


}

class Consumer implements Runnable{

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (queue.size() > 0) {
                    //消费者消费数据
                    int num = queue.poll();
                    System.out.println("consumer " + Thread.currentThread().getName() + "consumer" + num + "conpacity" + queue.size());
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //唤醒生产者
                    queue.notifyAll();
                } else {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


}