/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 抢红包
 * https://blog.csdn.net/qq_35393472/article/details/80073948
 * @author luweiliang
 * @created 2020/5/6
 */
public class 抢红包 {

    public static void fun() {
        List<Integer> list = generatePacketsByDoubleMean(4, 16);
        System.out.println(list);
    }

    // 二倍均值法
    private static List<Integer> generatePacketsByDoubleMean(int person, int money) {
        List<Integer> list = new ArrayList<>();
        Random ran = new Random();
        while (person > 1) {
            int num = ran.nextInt(2 * (money / person));
            list.add(num);
            money = money - num;
            person --;
        }
        list.add(money);
        return list;
    }

    /**
     * 二倍均值法
     * 剩余红包金额为M，剩余人数为N，那么有如下公式：
     * 每次抢到的金额 = 随机区间 （0， M / N X 2）
     * 这个公式，保证了每次随机金额的平均值是相等的，不会因为抢红包的先后顺序而造成不公平。
     * 举个栗子：
     * 假设有10个人，红包总额100元。
     * 100/10X2 = 20, 所以第一个人的随机范围是（0，20 )，平均可以抢到10元。
     * 假设第一个人随机到10元，那么剩余金额是100-10 = 90 元。
     * 90/9X2 = 20, 所以第二个人的随机范围同样是（0，20 )，平均可以抢到10元。
     * 假设第二个人随机到10元，那么剩余金额是90-10 = 80 元。
     * 80/8X2 = 20, 所以第三个人的随机范围同样是（0，20 )，平均可以抢到10元。
     * 以此类推，每一次随机范围的均值是相等的。
     * @param totalAmount
     * @param personNum
     * @return
     */
    public static List<Integer> redPackage(Integer totalAmount, Integer personNum) {
        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = personNum;
        Random random = new Random();
        for (int i = 0; i < personNum - 1; i++) {
            // 随机范围：[1，剩余人均金额的两倍)，左闭右开
//            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 1) + 1;
            int amount = random.nextInt((restAmount / restPeopleNum) * 2);
            restAmount = restAmount - amount;
            restPeopleNum --;
            amountList.add(amount);
        }
        amountList.add(restAmount);

        return amountList;
    }

    public static void main(String[] args){
//        fun();
        List<Integer> amountList = redPackage(5000, 10);

        for (Integer amount : amountList) {
            System.out.println("抢到金额：" + new BigDecimal(amount).divide(new BigDecimal(100)));
        }
    }
}
