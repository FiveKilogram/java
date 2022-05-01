/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package palindrome;

/**
 * 最长回文子串(中心扩展算法)
 * https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode/
 * https://www.ixigua.com/pseries/6781258815477121543_6781248840965030403/?logTag=DkeO9tOdLVfxv68gOB8TR
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 * 输入: "babad" 输出: "bab", 注意: "aba" 也是一个有效答案; 输入: "cbbd" 输出: "bb"
 * @author luweiliang
 * @created 2020/3/12
 */
public class Lc_5_最长回文子串 {

    String res = "";
    public String longestPalindrome (String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        for (int i = 0; i < s.length(); i ++) {
            //以i为中心，向左向右扩散
            helper(s, i, i);
            //以i右边的间隙为中心，向左向右扩散
            helper(s, i, i + 1);
        }
        return res;
    }

    public void helper (String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res  = cur;
        }
    }

    //优先使用这个方法
    public static String longestPalindrome1 (String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length, max = 0, startIdx = 0;
        for (int i = 0; i < len; i ++) {
            //以i右边的间隙为中心，向左向右扩散
            int len1 = expandCompare(chars, i, i + 1);
            //以i为中心，向左向右扩散
            int len2 = expandCompare(chars, i - 1, i + 1);
            if (len1 > len2 && len1 > max){
                max = len1;
                startIdx = i - (len1 / 2) + 1;
            } else if (len2 > len1 && len2 > max) {
                max = len2;
                startIdx = i - (len2 / 2);
            }
        }
        return new String(chars, startIdx, max);
    }

    public static int expandCompare (char[] chars, int left, int right){
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left --;
            right ++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
//        String s = "babad";
        String s = "cbbd";
        Lc_5_最长回文子串 palindrome = new Lc_5_最长回文子串();
        System.out.println(palindrome.longestPalindrome(s));
        System.out.println(longestPalindrome1(s));

    }
}
