/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

import java.util.Arrays;

/**
 * 给定两个字符串, A 和 B。
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 
 * 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea'。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 *
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 *
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 *
 * https://leetcode-cn.com/problems/rotate-string/solution/gao-pin-mian-shi-ti-xuan-zhuan-zi-fu-chuan-by-ivan/
 * @author luweiliang
 * @created 2020/4/25
 */
public class Lc_796_旋转字符串 {
    /**
     * 解题思路
     * 两个字符串的长度不同，肯定false
     * 如果用暴力法，挨个遍历A字符，找到和B第一个字符相等的，比如 A:12345,B 34512 则A的遍历顺序为34512，既要绕到开头且时间复杂度也是O(n^2)
     * 有更巧妙的解法，就是给A后面再拼一个A，比如 1234512345，再判断B是否是A的字串，因为1234512345枚举了所有旋转数。
     *
     *
     * 时间复杂度：O(N^2)，其中 NN 是字符串 A 的长度。
     * 空间复杂度：O(N)，即 A + A 需要的空间。
     * @param a
     * @param b
     * @return
     */
    public static boolean rotateString(String a, String b) {
        //(a + a) = 'abcdeabcde'，也就是在'abcdeabcde'包括了'cdeab'
        return a.length() == b.length() && (a + a).contains(b);
    }

    /**
     * KMP算法
     * @param A
     * @param B
     *
     * 时间复杂度：O(m+n)
     * https://leetcode-cn.com/problems/rotate-string/solution/gao-pin-mian-shi-ti-xuan-zhuan-zi-fu-chuan-by-ivan/
     * @return
     */
    public static boolean rotateString_KMP(String A, String B) {
        int N = A.length();
        if (N != B.length()) return false;
        if (N == 0) return true;

        //Compute shift table
        int[] shifts = new int[N+1];
        Arrays.fill(shifts, 1);
        int left = -1;
        for (int right = 0; right < N; ++right) {
            while (left >= 0 && (B.charAt(left) != B.charAt(right)))
                left -= shifts[left];
            shifts[right + 1] = right - left++;
        }

        //Find match of B in A+A
        int matchLen = 0;
        for (char c: (A+A).toCharArray()) {
            while (matchLen >= 0 && B.charAt(matchLen) != c)
                matchLen -= shifts[matchLen];
            if (++ matchLen == N) return true;
        }

        return false;
    }

    public static void main(String[] args){
        String a = "abcde";
        String b = "cdeab";
        System.out.println(rotateString(a,b));
        System.out.println(rotateString_KMP(a, b));
    }
}
