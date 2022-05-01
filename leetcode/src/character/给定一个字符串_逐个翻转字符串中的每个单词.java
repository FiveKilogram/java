/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

/**
 * 给定一个字符串_逐个翻转字符串中的每个单词
 * 输入：the key is blue
 * 输出：blue is key the
 * @author luweiliang
 * @created 2020/4/22
 */
public class 给定一个字符串_逐个翻转字符串中的每个单词 {

    public static String reverseWordsTwo(String s){
        if (s == null) return s;
        String[] str = s.split(" ");
        int left = 0;
        int right = str.length - 1;
        while (left < right) {
            String temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            left ++;
            right --;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i ++) {
            sb.append(str[i]);
            if (i != str.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }


    public static void main(String[] args){
        String s = "the key is blue";
        System.out.println(reverseWordsTwo(s));
    }
}
