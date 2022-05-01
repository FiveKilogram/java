/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 数组中的最长山脉
 *
 * 示例 1：
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 *
 * 示例 2：
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *
 * @author luweiliang
 * @created 2020/6/8
 */
public class Lc_845_数组中的最长山脉 {
    public static int longestMountain(int[] A) {

        //标记此时处于上山或下山的任意一中状态（上山为 真 ，反之）
        //由于第一次必然是上山，所以值为 真
        boolean sign = true;
        //存储每一次测量的数据
        int length = 1;
        //记录截至最新的测量中的最大长度
        int max = 1;
        //开始“登山”（默认此时处于第一个点）
        for (int i = 1; i < A.length; i++) {
            // i - 1 代表当前位置
            // i  代表眼前位置
            if (A[i] > A[i - 1] && sign) {      //上山中
                length++;
            } else if (A[i] < A[i - 1] && length > 1) {    //下山中（并且题目要求，最小山脉长度为 3，所以下山之前必须上山一次）
                //标记此时为下山状态
                sign = false;
                length ++;
                //下山更新最大长度即可
                max = length > max ? length : max;
            } else if (A[i] == A[i - 1]) {    //平地，结束登山
                sign = true;
                length = 1;
            } else if (!sign) {      //结束登山，但注意上一个山脉登山最后的一部分可能是另一个山脉的一部分
                i --;
                sign = true;
                length = 1;
            }
        }
        return max > 2 ? max : 0;
    }

    public static int longestMountain1(int[] array) {
        boolean sign = true;
        int length = 1;
        int max = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1] && sign)
                length ++;
            else if (array[i] < array[i - 1] && length > 1) {
                sign = false;
                length ++;
                max = length > max ? length : max ;
            }  else { //结束登山只有两种可能，并且代码又所重复，精简如下
                if (!sign) {
                    i --;
                }
                sign = true;
                length = 1;
            }
        }
        return max > 2 ? max : 0;
    }

    public static void main (String[] args){
        int[] array = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(longestMountain(array));
    }
}
