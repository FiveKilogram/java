/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 移动0到数组的末尾
 * 给定一个数组sums,编写一个方法将所有0移动到数组到末尾
 * 要求：保存非0元素的相对顺序
 * 空间复杂度O(1)
 * @author luweiliang
 * @created 2020/5/17
 */
public class 移动0到数组的末尾 {

    public static void moveZeroes(int[] sums){
        if (sums == null || sums.length == 0) return;
        int flag = 0;
        for (int i = 0; i < sums.length; i ++) {
            //当前元素 !=0,就把其交换到左边，等于0的交换到右边
            if (sums[i] != 0) {
                int temp = sums[i];
                sums[i] = sums[flag];
                sums[flag ++] = temp;
            }
        }
    }

    public static void main (String[] args){
        int[] sums = {0, 1, 2, 0, 3, 7, 0, 12};
        moveZeroes(sums);
        for (int i = 0; i < sums.length; i ++) {
            System.out.println(sums[i]);
        }
    }
}
