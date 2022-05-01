/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package reverse;

/**
 * 数字反转
 * https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
 * https://leetcode-cn.com/problems/reverse-integer/solution/java-yi-dong-yi-jie-xiao-lu-gao-by-spirit-9-26/
 * https://www.cnblogs.com/yswyzh/p/10711352.html
 * 示例 1: 输入: 123 输出: 321
 * 示例 2:输入: -123 输出: -321
 * 示例 3: 输入: 120 输出: 21
 * @author luweiliang
 * @created 2019/8/27
 */
public class IntgerReverse {
    public static int reverse(int x) {
        long result = 0;
        while (x != 0){
            System.out.println("result * 10 ：" + result * 10);
            System.out.println("x % 10 ：" + x % 10);
            System.out.println("result * 10 + x % 10：" + result * 10 + x % 10);
            result = result * 10 + x % 10;
            System.out.println("result：" + result);
            System.out.println(" x / 10：" +  x / 10);
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }

    /**
     * 数字反转
     * @param x
     * @return
     */
    public static int numReverse(int x){
        long result = 0;
        while (x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }

    public static int reverse1(int num){
        long result = 0;
        while(num != 0){
            result = result * 10 + num % 10;
            num = num / 10;
        }
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }

    public static int reverse11(int sum){
        long result = 0;
        while (sum != 0){
            result = result * 10 + sum % 10;
            sum = sum / 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }



    public static void main(String[] args) {
        System.out.println(reverse(345));
    }

}
