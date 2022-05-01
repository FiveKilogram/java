/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package thread;

/**
 * 单利模式，双检查
 *
 * 其实single = new Single()这段代码并不具备原子性，从代码层面上来说确实没问题，
 * 但是如果了解JVM指令的就知道其实在执行这句代码的时候在JVM中是需要执行三个指令来完成的，如下：
 * memory = allocate(); //1：分配对象的内存空间
 * ctorInstance(memory); //2：初始化对象
 * instance = memory; //3：设置instance指向刚分配的内存地址
 * 1
 * 2
 * 3
 * 看到上面指令重排的解释之后，那么我们来回顾一下未加volatile修饰符的单例为何会出现问题。
 * 假设有A、B两个线程去调用该单例方法，当A线程执行到single = new Single()时，如果编译器和处理器对指令重新排序，指令重排后：
 * memory = allocate(); //1：分配对象的内存空间
 * instance = memory; //3：设置instance指向刚分配的内存地址，此时对象还没被初始化
 * ctorInstance(memory); //2：初始化对象
 * 1
 * 2
 * 3
 * 当A线程执行到第二步（3：设置instance指向刚分配的内存地址，此时对象还没被初始化）变量single指向内存地址之后就不为null了，
 * 此时B线程进入第一个if，由于single已经不为null了，那么就不会执行到同步代码块，而是直接返回未初始化对象的变量single，从而导致后续代码报错。
 *
 * 发生指令重排序了，需要加上volatile关键字，防止指令重排序
 *
 *
 * https://blog.csdn.net/lc8023xq/article/details/114257797
 * @author luweiliang
 * @created 2020/5/8
 */
public class Singleton {

    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        //第一次检查，不锁定
        if (null == instance) { //①
            // 一旦初始化，第一次检查将无法通过，不会有锁定开销
            synchronized (Singleton.class) {//②
                //第二次检查，锁定
                if (null == instance) {//③
                    instance = new Singleton();//④
                }
            }
        }
        return instance;
    }
}
