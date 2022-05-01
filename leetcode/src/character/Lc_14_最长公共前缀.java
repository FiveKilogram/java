/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

/**
 * 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * 示例 1: 输入: ["flower","flow","flight"] 输出: "fl"
 * 示例 2: 输入: ["dog","racecar","car"] 输出: "" 解释: 输入不存在公共前缀。
 * 说明: 所有输入只包含小写字母 a-z 。
 * 数组中的第一个元素成为前缀，然后循环字符串数组，判断数组中的每一个元素是否以声明的那个前缀一样，
 * 一样就不动，不一样就将声明的那个前缀从0-长度减一，循环知道找到每一个元素都开头的那个前缀
 * @author luweiliang
 * @created 2020/3/30
 */
public class Lc_14_最长公共前缀 {

    /**
     * 方法一：从后往前水平扫描
     * 思路：
     * (1) 取数组中一个字符串作为匹配串去循环匹配数组中其它字符串。
     * (2) 发生不匹配就截去匹配串最后一个字符继续循环，匹配完成就匹配下一个字符串，直到最后。
     * (3) 如果匹配串在匹配过程中长度被截为 0 ，则直接返回不匹配。
     * 判断数组中的每一个元素是否以res开头,不是的话,让res-1,
     * 在判断是否与数组中的元素相同
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0) return null;
        String res = strs[0];
        //字符串可以被自身匹配，所以从第二个开始匹配。
        for (int i = 1; i < strs.length; i ++){
//            System.out.println("111111:" + strs[i].indexOf(res));
            // 如果匹配串不在要匹配字符串的开头，则表示不是要匹配字符串的前缀。
            while(strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
    }

    /**
     * 方法二：从前往后水平扫描
     * 思路：
     * (1) 取数组中一个字符串从前往后遍历字符去匹配其它字符串的相同位置字符。
     * (2) 直到遍历超出数组中最短字符串长度或者遍历到的字符匹配不上，则返回当前匹配串。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length() ; i++) {
            // 取出当前位置要匹配的字符。
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        // 数组中其它字符串都能被 strs[0] 匹配。
        return strs[0];
    }

    /**
     * 方法三：分治算法
     思路：
     将原数组拆分成每两个为一组，分别匹配最长公共前缀，将匹配结果继续两两匹配。
     分治算法的基本思想：
     (1) 将一个规模为N的问题分解为 K 个规模较小的子问题。
     (2) 这些子问题相互独立且与原问题性质相同。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        return longestCommnPrefix2(strs, 0, strs.length - 1);
    }

    public static String longestCommnPrefix2(String[] strs, int left, int right){
        if (left == right) {
            return strs[left];
        } else {
            //将数组分成两组分别查找最长公共前缀，然后再查找两个公共前缀的最长公共前缀。
            int mid = left + (right - left) / 2;
            String l= longestCommnPrefix2(strs, left, mid);
            String r = longestCommnPrefix2(strs, mid + 1, right);
           return commonPrefix(l, r);
        }
    }

    public static String commonPrefix(String left, String right){
        //找出两个字符串中较短的从前往后遍历，匹配出俩字符串最长公共前缀。
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i ++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }

    /**
     * 方法四：二分法查找
     * 思路：
     * (1) 得到字符串数组中最短字符串长度。
     * (2) 根据二分法查找遍历数组找到最长公共前缀。
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        // 遍历得到数组中最短字符串的长度。
        for (String str : strs){
            minLen = Math.min(minLen, str.length());
        }
        int left = 1;
        int right = minLen;
        // 用二分法从最短字符串中间循环遍历。
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (isCommonPrefix(strs, middle)){
                left = middle + 1;
            } else{
                right = middle - 1;
            }
        }
        return strs[0].substring(0, (left + right) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len){
        // 截取当前位置之前的字符串判断是否是数组中字符串的公共前缀。
        String s = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++){
            if (!strs[i].startsWith(s)){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
//        String[] strs = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix1(strs));
        System.out.println(longestCommonPrefix2(strs));
        System.out.println(longestCommonPrefix3(strs));
    }
}
