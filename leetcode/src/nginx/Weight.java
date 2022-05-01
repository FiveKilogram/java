/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package nginx;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/5/6
 */
public class Weight {

    private String ip;
    private Integer weight;            //初始权重 （保持不变）
    private Integer currentWeight;     //当前权重

    public Weight(String ip, Integer weight, Integer currentWeight) {
        this.ip = ip;
        this.weight = weight;
        this.currentWeight = currentWeight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(Integer currentWeight) {
        this.currentWeight = currentWeight;
    }
}
