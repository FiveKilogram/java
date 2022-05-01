/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串的长度。
 * 示例 1: 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2: 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3: 输入: "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 时间复杂度: O(N)
 * 空间复杂度: O(M)
 * @author luweiliang
 * @created 2020/3/27
 */
public class Lc_3_无重复字符的最长子串 {

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int len = s.length();
        int nas = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < len; j ++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            nas = Math.max(nas, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return nas;
    }

    public static int lengthOfLongestSubstring2 (String s){
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0, j = 0; i < s.length(); i ++) {
            if (map.containsKey(s.charAt(i))) {
                j = Math.max(j, map.get(s.charAt(i)));
            }
            res = Math.max(res, i - j + 1);
            map.put(s.charAt(i), i + 1);
        }
        return res;
    }

    @Deprecated
    public static int lengthOfLongestSubstring1 (String s) {
        if (s == null || s.length() == 0) return 0;
        //HashSet中存放已经找到的不重复的字符
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        //i，j两个指针,分别记录当前起始位置和终止位置
        for (int i = 0, j = 0; i < s.length(); i ++) {

            //HashSet中包含字符i，从HashSet中移除j指针那一位，j右移
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j++));
            } else {
                //右边指针的下一位不在hashSet中，放入HashSet中
                set.add(s.charAt(i));
                //更新 res 为最大值
                res = Math.max(res, set.size());
            }
        }
        //返回最大值
        return res;
    }

    public static int lengthOfLongestSubstring3 (String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i ++) {
            //如果映射中存在该字符
            if (map.containsKey(s.charAt(i))) {
                //更新滑动窗口的左边界 j
                j = Math.max(j, map.get(s.charAt(i)));
            }
            //更新 res 为最大值
            res = Math.max(res, i - j + 1);
            //更新映射中该字符映射的 Value 值为当前位置加一
            map.put(s.charAt(i), i  + 1);
        }
        //返回最大值
        return res;
    }

    public static void main(String[] args){
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println(lengthOfLongestSubstring1("pwwkew"));
//        System.out.println(lengthOfLongestSubstring2("pwwkew"));
        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
    }
}
