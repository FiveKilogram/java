/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package binarySearch;

/**
 * 在这里编写类的功能描述
 * 例：int[] a = {1,2,2,2,4,8,10}，查找2，返回第一个2的下标1；查找3，返回4的下标4；查找4，返回4的下标4。如果没有大于等于key的元素，返回-1。
 * @author luweiliang
 * @created 2020/5/1
 */
public class 查找第一个大于等于某个数的下标 {
    public static int firstGreatOrEqual(int[] sums, int target){
        if (sums == null || sums.length == 0) return  -1;
        int left = 0;
        int right = sums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left <= sums.length - 1 ? left : -1;
    }

    public static void main (String[] args){
        int[] sums = {1,2,2,2,4,8,10};
        System.out.println(  firstGreatOrEqual(sums, 2));
    }
}
