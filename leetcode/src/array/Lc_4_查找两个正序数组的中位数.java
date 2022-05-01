/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 在这里编写类的功能描述
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。你可以假设 nums1 和 nums2 不会同时为空。
 * 示例 1:
 * nums1 = [1, 3] nums2 = [2] 则中位数是 2.0
 * 示例 2:
 * nums1 = [1, 2] nums2 = [3, 4] 则中位数是 (2 + 3)/2 = 2.5
 * https://blog.csdn.net/chen_xinjia/article/details/69258706
 * @author luweiliang
 * @created 2020/7/19
 */
public class Lc_4_查找两个正序数组的中位数 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 > len2) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len = len1 + len2;
        int cut1 = 0, cut2 = 0, cutL = 0, cutR = len1 - 1;
        while (cut1 <= len1){
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len / 2 - cut1;
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == len1) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == len2) ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 > R2) {
                cutR = cut1 - 1;
            } else if(L2 > R1){
                cutL = cut1 + 1;
            } else {   //这是正确的切割。
                if (len % 2 == 0) {       // 偶数个数的时候
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return (L1 + R1) / 2;
                } else {
                    R1 = (R1 < R2) ? R1 : R2;
                    return R1;
                }
            }
        }
        return  -1;
    }

    //优先使用这个代码
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        //总长度
        int totalLen = len1 + len2;
        //midLen = 一半的长度, i1 = num1的下标索引，i2 = num2的下标索引，currIdx = 累加器的索引，currVal = 当前值，prevVal= 上一个值；
        int midLen = (totalLen / 2), i1 = 0, i2 = 0, currIdx = 0, currVal = 0, prevVal = 0;
//        int midLen = (totalLen >> 1), i1 = 0, i2 = 0, currIdx = 0, currVal = 0, prevVal = 0;
        while (currIdx <= midLen) {
            //开始将当前值给上一个值
            prevVal = currVal;
            //i1的长度走完了，经过循环到了尽头
            if (i1 == len1) {
                //i1走完了，i2指针的元素赋值给当前的值
                currVal = nums2[i2];
                //累加器++，i1走完了，i2也要开始走了
                currIdx ++; i2 ++;
                continue;
            }
            //i2的长度走完了，经过循环到了尽头
            if (i2 == len2) {
                //i2走完了，i1指针的元素赋值给当前的值
                currVal = nums1[i1];
                //累加器++，i2走完了，i1也要开始走了
                currIdx ++; i1 ++;
                continue;
            }
            //i1还有和i2还没有走完，
            //如果，nums1[i1] < nums2[i2] ，i1对应的元素小于i2对应的元素，把i1的指针的元素赋值给当前值，累加器++， i1的指针要后移
            if (nums1[i1] < nums2[i2]) {
                currVal = nums1[i1];
                currIdx ++; i1 ++;
            } else {
                //否则，nums1[i1] >= nums2[i2], i1对应的元素大于i2对应的元素，把i2的指针的元素赋值给当前值，累加器++，i2的指针要后移
                currVal = nums2[i2];
                currIdx ++; i2 ++;
            }
        }
        //如果是基数直接反复currVal，如果是偶数把上一个值和当前值的和除以2；
        return (totalLen % 2) == 1 ? currVal : (prevVal + currVal) / 2.0;
        //return (totalLen & 1) == 1 ? currVal : (prevVal + currVal) / 2.0;
    }

        public static void main(String[] args) {
//        int[] sums1 = {1, 3};
//        int[] sums2 = {2};

        int[] sums1 = {1, 2};
        int[] sums2 = {3, 4};
        System.out.println(findMedianSortedArrays(sums1, sums2));
        System.out.println(findMedianSortedArrays1(sums1, sums2));
    }
}
