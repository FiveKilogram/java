/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/5/12
 */
public class 两个大数相加 {

    public static String getStringSum(String num1,String num2) {
        StringBuffer result = new StringBuffer();
        //反转字符串  123 --> 321  8912 --> 2198
        num1 = new StringBuffer(num1).reverse().toString();
        num2 = new StringBuffer(num2).reverse().toString();
        int len1 = num1.length();
        int len2 = num2.length();
        int maxLen = len1 > len2 ? len1 : len2;
        int nTakeOver = 0 ; //进位
        //2.把两个字符串补齐，即短字符串的高位用0补齐
        if(len1 < len2){  // 3210
            for(int i = len1;i < len2; i++) {
                num1 += "0";
            }
        } else if (len1 > len2){
            for(int i = len2 ; i < len1 ; i++) {
                num2 += "0";
            }
        }
        System.out.println(num1);
        System.out.println(num2);

        //3.逐位相加  3210 2198
        for(int i = 0; i < maxLen; i ++) {
            int nSum = Integer.parseInt(num1.charAt(i) +"") + Integer.parseInt(num2.charAt(i) +"")+ nTakeOver;
            nTakeOver = 0;
            System.out.println("maxLen:"+maxLen);
            if(i < (maxLen - 1)) {
                if(nSum >= 10) {
                    nTakeOver = 1;
                    result.append(nSum - 10);
                }else {
                    nTakeOver = 0;
                    result.append(nSum);
                }
            }else {
                StringBuffer lastSum = new StringBuffer();
                //最后一位数的加法特殊处理,先反转
                lastSum.append(nSum).reverse();
                result.append(lastSum);
                result.reverse().toString();
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str1 = getStringSum("999999999999999999999999999999999999999999999999999999999999999999999999999999","911911111111111111111111111111111111111111111111111111119999999999");
        System.out.println(str1);
    }
}
