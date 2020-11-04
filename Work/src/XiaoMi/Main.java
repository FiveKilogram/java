package XiaoMi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    /**
     * 小米之家有很多米粉喜欢的产品，产品种类很多，价格也不同。比如某签字笔1元，某充电宝79元，
     * 某电池1元，某电视1999元等
     *
     * 假设库存不限，小明去小米之家买东西，要用光N元预算的钱，请问他最少能买几件产品？
     * @param prices
     * @param budget
     * @return
     */

    //static int result;
    static int solution(int[] prices, int budget) {
        if(budget<prices[prices.length-1])
            return -1;

        int result = 0;
        Arrays.sort(prices);
        int i = prices.length-1;
        while (i>=0){
            if(budget>prices[i]){
                budget = budget - prices[i];

                result = result + 1;
            }
            i--;
        }
        if(budget>0)
            return -1;

        return result;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _prices_size = 0;
        _prices_size = Integer.parseInt(in.nextLine().trim());
        int[] _prices = new int[_prices_size];
        int _prices_item;
        for(int _prices_i = 0; _prices_i < _prices_size; _prices_i++) {
            _prices_item = Integer.parseInt(in.nextLine().trim());
            _prices[_prices_i] = _prices_item;
        }

        int _budget;
        _budget = Integer.parseInt(in.nextLine().trim());

        res = solution(_prices, _budget);
        System.out.println(String.valueOf(res));

    }
}
