/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 示例 1：
 * 输入：s = "We are happy."输出："We%20are%20happy."
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/solution/mian-shi-ti-05-ti-huan-kong-ge-by-leetcode-solutio/
 * @author luweiliang
 * @created 2020/9/9
 */
public class Offer_5_替换空格 {

    /**
     * 时间复杂度：O(n)。遍历字符串 s 一遍。
     * 空间复杂度：O(n)。额外创建字符数组，长度为 s 的长度的 3 倍。
     * @param s
     * @return
     */
    public static String replaceSpace (String s){
        if (s == null) return s;
        int n = s.length();

        int cnt = 0;
        for (char c : s.toCharArray()){
            if (c == ' ') cnt ++;
        }
        char[] array = new char[n + 2 * cnt];
        int j = 0;
        for (int i = 0; i < n; i ++) {
            char c = s.charAt(i);
            if (c == ' '){
                array[j ++] = '%';
                array[j ++] = '2';
                array[j ++] = '0';
            } else {
                array[j ++] = c;
            }
        }
        return new String(array);
    }

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
}
