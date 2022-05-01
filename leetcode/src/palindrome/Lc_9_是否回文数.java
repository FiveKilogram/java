/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package palindrome;

/**
 * 是否是回文数
 * https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode/
 * @author luweiliang
 * @created 2019/8/29
 */
public class Lc_9_是否回文数 {
    public static boolean isPalindrome (int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。if (x < 0 || (x % 10 == 0 && x != 0)) {
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，    return false;
        // 则其第一位数字也应该是 0}
        // 只有 0 满足这一属性
        // 如：1000  反转后变成 0001 也就是1，无法反转比较
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int result = 0;
        while (x > result) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == result || x == result / 10;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(12321));
    }
}
