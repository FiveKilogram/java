/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * Lc_189_旋转数组
 * 给定一个数组，将数组中的元素向右移动n个位置，其中n是非负数
 * 输入：[1, 2, 3, 4, 5, 6, 7] 和 n = 3
 * 输出：[5, 6, 7, 1, 2, 3, 4]
 * 解释:向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * @author luweiliang
 * @created 2020/4/25
 */
public class Lc_189_旋转数组 {

    public static int[] rotateArray(int[] sums, int n) {
        if (sums == null || sums.length == 0) return new int[] {-1};
        int starNum, endNum;
        for (int i = 0; i < n; i ++){
            endNum = sums[sums.length - 1];
            for (int j = 0; j < sums.length; j ++){
                starNum = sums[j];
                sums[j] = endNum;
                endNum = starNum;
            }
        }
        return sums;
    }


    public static int[]  rotateArray1(int[] sums, int n){
        if (sums == null || sums.length == 0) return new int[] {-1};;
        reverse(sums, 0, sums.length - 1);
        reverse(sums, 0, n - 1);
        reverse(sums, n, sums.length - 1);
        return sums;
    }

    public static void reverse(int[] sums, int left, int right){
        while (left < right){
            int temp = sums[left];
            sums[left] = sums[right];
            sums[right] = temp;
            left ++;
            right --;
        }
    }

    public static void main (String[] args) {
//        int[] sums = {1, 2, 3, 4, 5, 6, 7};
        int[] sums = {4,5,6,7,0,1,2};
//        int[] res = rotateArray(sums, 3);
        int[] res = rotateArray1(sums, 3);
        for (int i = 0; i < sums.length; i++) {
            System.out.println(sums[i]);
        }
    }


}
