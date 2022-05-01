package nginx;/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */

import javax.xml.ws.Service;
import java.util.HashMap;
import java.util.Map;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020-05-06
 */
public class WeightedRoundRobin_加权轮询 {
    public static final Map<String, Weight> weights = new HashMap<>();

    public static String get(){
        int totalWeight = 0;
        for (Integer weight : ServiceList.weight_list.values()) {
            totalWeight += weight;
        }
        if (weights.isEmpty()) {
            ServiceList.weight_list.forEach((ip, weight) ->{
                weights.put(ip, new Weight(ip, weight, 0));
            });
        }

        for (Weight weight : weights.values()) {
            weight.setCurrentWeight(weight.getCurrentWeight() + weight.getWeight());
        }

        Weight maxCurrentWeight = null;
        for (Weight weight : weights.values()) {
            if (maxCurrentWeight == null || weight.getCurrentWeight() > maxCurrentWeight.getCurrentWeight()) {
                maxCurrentWeight = weight;
            }
        }
        maxCurrentWeight.setCurrentWeight(maxCurrentWeight.getCurrentWeight() - totalWeight);

        return maxCurrentWeight.getIp();
    }

    public static void main (String[] args) {
        for (int i = 0; i < 7; i ++) {
            System.out.println(get());
        }
    }
}