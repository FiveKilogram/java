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
public class Node {
    public int weight ;          // 初始权重 （保持不变）
    public String serverName ;   // 服务名
    private int currentWeight ; // 当前权重

    public Node( String serverName, int weight) {
        this.weight = weight;
        this.serverName = serverName ;
        this.currentWeight = weight ;
    }

    public Node() {
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }
}