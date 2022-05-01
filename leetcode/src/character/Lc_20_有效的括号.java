/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

import java.util.Stack;

/**
 * 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/solution/valid-parentheses-fu-zhu-zhan-fa-by-jin407891080/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1: 输入: "()" 输出: true，示例 2: 输入: "()[]{}"输出: true，示例 3: 输入: "(]" 输出: false，示例 4: 输入: "([)]"输出: false
 * @author luweiliang
 * @created 2020/3/16
 */
public class Lc_20_有效的括号 {
   public static boolean isValid(String s) {
       if (s == null || s.length() == 0) {
           return true;
       }

       Stack<Character> stack = new Stack<>();

       for (int i = 0; i < s.length(); i ++) {
           Character ch = s.charAt(i);
           if (ch.equals('(')) {
               stack.push(')');
           } else if (ch.equals('{')) {
               stack.push('}');
           } else if (ch.equals('[')) {
               stack.push(']');
           } else {
               if (stack.isEmpty() || !ch.equals(stack.pop())) {
                   return false;
               }
           }
       }
       return stack.isEmpty();
   }

    public static boolean isValid1(String s) {
        if (s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()";
        System.out.println(isValid(s));
        System.out.println(isValid1(s));
    }
}
