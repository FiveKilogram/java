/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package thread;

/**
 * 交替打印数字和字母
 * https://www.ixigua.com/pseries/6805817900939608580_6805503340336644615/?logTag=xgd5pkI-vleYmVIWa4Y_6
 * @author luweiliang
 * @created 2020/3/28
 */
public class 交替打印数字和字母 {

    /**
     * 交替大于数字和字母
     * 如：1a2b3c4d5e6f7g8h9i10j11k12l13m14n15o16p17q18r19s20t21u22v23w24x25y26z
     * @param args
     */
    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
////            for (int i = 1; i <= 52; i++) {
//            for (int i = 1; i<= 26; i++) {
//                System.out.println(i);
////                if (i % 2 == 0) {
//                if (i % 1 == 0) {
//                    try {
//                        Thread.sleep(600);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (char j = 'a'; j <= 'z'; j++) {
//                System.out.println(j);
//                try {
//                    Thread.sleep(600);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        t1.start();
//        try{
//          Thread.sleep(300);
//        } catch(InterruptedException e){
//            e.printStackTrace();
//        }
//        t2.start();
        print();

    }

    /**
     *
     * 1a2b3c4d5e6f7g8h9i10j11k12l13m14n15o16p17q18r19s20t21u22v23w24x25y26z
     * for (int i = 1; i <= 26; i++)
     *
     * 12a34b56c78d910e1112f1314g1516h1718i1920j2122k2324l2526m2728n2930o3132p3334q3536r3738s3940t4142u4344v4546w4748x4950y5152z
     * for (int i = 1; i <= 52; i++)
     *
     *
     */
    public static void print(){
        Object o = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (o) {
                try {
                    for (int i = 1; i <= 26; i++) {
                        System.out.print(i);
                        o.notify();
                        o.wait();
                    }

//                    for (int i = 1; i <= 52; i++) {
//                        System.out.print(i);
//                        if (i % 2 == 0) {
//                            o.notify();
//                            o.wait();
//                        }
//                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                o.notify();
            }
        });


        Thread t2 = new Thread(() -> {
            synchronized (o) {
                try {
                    for (char c = 'a'; c <= 'z'; c++) {
                        System.out.print(c);
                        o.notify();
                        o.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
