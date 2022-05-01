/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package reverse;

/**
 * 在这里编写类的功能描述
 * https://leetcode-cn.com/problems/reverse-string/solution/fan-zhuan-zi-fu-chuan-by-leetcode-solution/
 * https://leetcode-cn.com/problems/reverse-string/solution/zi-jie-ti-ku-344-jian-dan-fan-zhuan-zi-f-7gqs/
 * @author luweiliang
 * @created 2020/3/12
 */
public class StringReverse {

    /**
     * 字符串反转
     * 思路与算法
     * 对于长度为 N 的待被反转的字符数组，我们可以观察反转前后下标的变化，假设反转前字符数组为 s[0] s[1] s[2] ... s[N - 1]，那么反转后字符数组为 s[N - 1] s[N - 2] ... s[0]。比较反转前后下标变化很容易得出 s[i] 的字符与 s[N - 1 - i] 的字符发生了交换的规律，因此我们可以得出如下双指针的解法：
     * 将 left 指向字符数组首元素，right 指向字符数组尾元素。
     * 当 left < right：
     * 交换 s[left] 和 s[right]；
     * left 指针右移一位，即 left = left + 1；
     * right 指针左移一位，即 right = right - 1。
     * 当 left >= right，反转结束，返回字符数组即可。
     *
     * 时间复杂度：O(N)，其中 NN 为字符数组的长度。一共执行了 N/2N/2 次的交换。
     * 空间复杂度：O(1)。只使用了常数空间来存放若干变量。
     * @param s
     */
    public static char[] reverseString(char[] s){
        if (s == null || s.length <= 1) {
            return s;
        }
        int left = 0;
        int right = s.length - 1;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
        return s;
    }

    public static void main(String[] args){
        char[] s = {'h','e','l','l','o'};
        System.out.println(reverseString(s));
    }
}
