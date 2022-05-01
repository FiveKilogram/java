package nginx;/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020-05-06
 */
public class SmoothWeightedRoundRobin {
    private volatile List<Node> nodeList = new ArrayList(); // 保存权重
    private ReentrantLock lock = new ReentrantLock() ;

    public SmoothWeightedRoundRobin(Node ...nodes) {
        for (Node node : nodes) {
            nodeList.add(node) ;
        }
    }

    public Node select(){
        try {
            lock.lock();
            return this.selectInner() ;
        }finally {
            lock.unlock();
        }
    }

    private Node selectInner(){
        int totalWeight = 0 ;
        Node maxNode = null ;
        int maxWeight = 0 ;

        for (int i = 0; i < nodeList.size(); i++) {
            Node n = nodeList.get(i);
            totalWeight += n.getWeight() ;

            // 每个节点的当前权重要加上原始的权重
            n.setCurrentWeight(n.getCurrentWeight() + n.getWeight());

            // 保存当前权重最大的节点
            if (maxNode == null || maxWeight < n.getCurrentWeight() ) {
                maxNode = n ;
                maxWeight = n.getCurrentWeight() ;
            }
        }
        // 被选中的节点权重减掉总权重
        maxNode.setCurrentWeight(maxNode.getCurrentWeight() - totalWeight);

        return maxNode ;
    }
}