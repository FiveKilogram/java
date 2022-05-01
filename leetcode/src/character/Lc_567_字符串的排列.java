/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

/**
 * 字符串的排列
 *
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 示例1:
 * 输入: s1 = "ab" s2 = "eidbaooo" 输出: True 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例2:
 * 输入: s1= "ab" s2 = "eidboaoo" 输出: False
 * 注意：
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 *
 * @author luweiliang
 * @created 2020/5/25
 */
public class Lc_567_字符串的排列 {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];
        for (int i = 0; i < s1.length(); i ++) {
            s1Arr[s1.charAt(i) - 'a'] ++;
            s2Arr[s2.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i ++) {
            if (matches(s1Arr, s2Arr)) return true;
            s2Arr[s2.charAt(i + s1.length()) - 'a'] ++;
            s2Arr[s2.charAt(i) - 'a'] --;
        }
        return matches(s1Arr, s2Arr);
    }

    //匹配
    public static boolean matches(int[] s1, int[] s2){
        for (int i = 0; i < 26; i ++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args){
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }
}
