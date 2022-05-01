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
public class 一个数组有2n个元素_基数_偶数 {
//    public static void sort(int[] nums) {
//        int idxj = 1;  //基数
//        int idxo = 0;  //偶数
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] % 2 == 1) {
//                if (i % 2 == 1) {
//                    idxj = Math.max(idxj, i + 2);
//                } else {
//                    while (nums[i] % 2 == 1) {
//                        swap(nums, i, idxj);
//                        idxj += 2;
//                    }
//                }
//            } else {
//                if (i % 2 == 0) {
//                    idxo = Math.max(idxo, i + 2);
//                } else {
//                    while (nums[i] % 2 == 0) {
//                        swap(nums, i, idxo);
//                        idxo += 2;
//                    }
//                }
//            }
//        }
//    }


    public static void oddEven(int[] a, int left, int right) {
        int i = left, j = right;
        while (i <= right) {
            while (i <= right) {
                if (i % 2 == 0 && a[i] % 2 == 1) {
                    break;
                } else {
                    i++;
                }
            }
            while (j >= left) {
                if (j % 2 == 1 && a[j] % 2 == 0) {
                    break;
                } else {
                    j--;
                }
            }
            if (i <= right && j >= left) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 1, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 1};
        //int[] nums = {1,1,1,2,2,2};
//        sort(nums);
        oddEven(nums, 0, nums.length - 1);
        for (Integer i : nums) {
            System.out.println(i);
        }
    }
}



