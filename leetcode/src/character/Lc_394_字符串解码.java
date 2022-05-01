/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

import java.util.Stack;

/**
 * 字符串解码
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * 思路:借助栈来完成。
 * 1、计算串出现的次数，即[左侧的数字。
 * 2、如果是字母，直接入栈
 * 3、如果是[，则将计算好的次数入栈
 * 4、如果是]，开始弹栈
 *   a.如果是字母，则进行拼接s。（注意后弹栈出的元素放在前面，需要使用insert(0, ch)）
 *   b.如果是数字n，则将n个s进行拼接，然后入栈。并结束弹栈。
 * @author luweiliang
 * @created 2020/5/12
 */
public class Lc_394_字符串解码 {

    public static String decodeString(String s){
        if (s == null || s.length() == 0) return s;

        char[] cs = s.toCharArray();
        Stack<String> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < cs.length; i ++) {
            char ch = cs[i];
            if (ch >= '0' && ch <= '9'){
                //统计数字。eg: 12是2个字符进行处理的
                count = 10 * count + (ch - '0');
            } else if (ch == '['){
                //如果遇到[, 把数字入棧，count归0
                stack.push(String.valueOf(count));
                count = 0;
            } else if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z'){
                //如果是字符直接入棧
                stack.push(String.valueOf(ch));
            } else if (ch == ']') {
                //如果遇到], 开始处理字符串解码
                StringBuffer sb = new StringBuffer();

                //棧不为null，弹出棧元素
                while (!stack.isEmpty()){
                    String s1 = stack.pop();
                    //判断是否是数字
                    if (isDigital(s1)) {
                        int j = 0;
                        while (j++ < Integer.parseInt(s1)){
                            stack.push(sb.toString());
                        }
                        break;
                    } else {
                        sb.insert(0, s1);
                    }
                }
            }
        }

        StringBuilder res = new StringBuilder();
        while (!stack.empty()) {
            res.insert(0, stack.pop());
        }
        return res.toString();
    }

    private static boolean isDigital(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main (String[] args){
        String s = "3[a]2[bc]";
        System.out.println( decodeString(s));
    }
}
