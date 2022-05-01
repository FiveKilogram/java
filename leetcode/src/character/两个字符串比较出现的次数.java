/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

/**
 * 两个字符串比较出现的次数
 * 窗口指针移动
 * abcabc
 * abc
 * @author luweiliang
 * @created 2020/5/14
 */
public class 两个字符串比较出现的次数 {
    public static int solution(String str1, String str2) {
        int count = 0;
        if (str1.length() < str2.length()) {
            return count;
        }
        int start = 0;
        int end = str2.length() - 1;
        while (end < str1.length()) {
            if (str1.substring(start, end + 1).equals(str2)) {
                count ++;
            }
            start ++;
            end ++;
        }
        return count;
    }

    public static void main(String[] args) {
        String str1 = "abcabcabc";
        String str2 = "abc";
        System.out.println(solution(str1, str2));
    }
}
