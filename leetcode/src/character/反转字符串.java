/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/4/25
 */
public class 反转字符串 {
    /**
     * 字符串反转
     * @param s
     */
    public static char[] reverseString(String s){
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;
        while (left < right){
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left ++;
            right --;
        }
        return c;
    }

    public static void main(String[] args){
        String s1 = "abcdefg";
        System.out.println(reverseString(s1));
    }
}
