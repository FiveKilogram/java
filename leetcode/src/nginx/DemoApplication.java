package nginx;/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020-05-06
 */
public class DemoApplication {
    public static void main(String[] args) {
        /**
         * 假设有三个服务器权重配置如下：
         * server A  weight = 4 ;
         * server B  weight = 3 ;
         * server C  weight = 2 ;
         */
        Node serverA = new Node("serverA", 35000000);
        Node serverB = new Node("serverB", 30000000);
        Node serverC = new Node("serverC", 20000000);

        SmoothWeightedRoundRobin smoothWeightedRoundRobin = new SmoothWeightedRoundRobin(serverA, serverB, serverC);
        for (int i = 0; i < 700; i++) {
            new Thread() {
                public void run() {
                    Node i1 = smoothWeightedRoundRobin.select();
                    System.out.println(i1.getServerName());
                }
            }.start();

        }
    }
}