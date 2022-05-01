/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/4/27
 */
public class 数组元素中的奇数放左边_偶数放右边 {

    /**
     * 给一个无序数组,要求实现把奇数放左边, 偶数放右边(不要求稳定性)
     * 思路：
     * 维护两个指针，一个指针指向数组的第一个数字，向后移动；一个指针指向最后一个数字，向前移动。
     * 如果第一个指针指向的数字是偶数而第二个指针指向的数字是奇数，我们就交换这两个数字。
     *
     * 时间为O(N)，空间复杂度为O(1)
     *
     * @param sums
     */
    public static void sort(int[] sums){
        if (sums == null || sums.length == 0) return;
        int i = 0, j = sums.length - 1;
        while(i < j) {
            while (sums[i] % 2 != 0) {
                i++;
            }
            while (sums[j] % 2 == 0) {
                j--;
            }
            if (i < j) {
                int temp = sums[i];
                sums[i] = sums[j];
                sums[j] = temp;
            }
        }
    }

    /**
     * 给一个无序数组, 从第一个元素开始，到第几个元素结束，要求实现把奇数放左边, 偶数放右边
     * @param sums
     * @param n
     */
    public static void sort(int[] sums, int n){
        if (sums == null || sums.length == 0) return;
        int i = 0, j = n - 1;
        while (sums[i] % 2 != 0) {
            i ++;
        }
        while (sums[j] % 2 == 0) {
            j --;
        }
        if (i < j) {
            int temp = sums[i];
            sums[i] = sums[j];
            sums[j] = temp;
        }
    }

    public static void main(String[] args){
        int[] sums = {1, 3, 2, 8, 4, 5, 7};
        sort(sums);
        for (int i = 0; i < sums.length; i ++) {
            System.out.println(sums[i]);
        }
    }
}
