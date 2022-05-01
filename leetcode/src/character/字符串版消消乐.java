/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

/**
 * 字符串版消消乐
 * 替换输入字符串的'b'和连续的'a'和'c'
 * 输入'aaadbbcc'， 输出 'aaabcc'
 * 输入'abaca'， 输出 'aa'
 * 输入'aaabbccc'， 输出
 * @author luweiliang
 * @created 2020/4/22
 */
public class 字符串版消消乐 {

    public static void deleteStr(String s){
        if (s == null) return;

        char[] str = s.toCharArray();
        int i = 0;
        int newLength = 0;
        while(i != str.length -1) {
            if (str[i] != 'b') {
                str[newLength] = str[i];
                if (newLength == 0) {
                    newLength ++;
                    i++;
                    continue;
                }
                if (str[newLength] == 'c' && str[newLength - 1] == 'a'){
                    newLength --;
                } else {
                    newLength ++;
                }
            }
            i ++;
        }
        System.out.println(str);
//        System.out.println(newLength);
    }

    public static void main(String[] args) {
        String s = "aaadbbcc";
        deleteStr(s);
    }

}
