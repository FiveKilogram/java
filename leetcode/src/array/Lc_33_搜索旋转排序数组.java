/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 在这里编写类的功能描述
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1。你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1：输入：nums = [4,5,6,7,0,1,2], target = 0 输出：4
 * 示例 2：输入：nums = [4,5,6,7,0,1,2], target = 3 输出：-1
 * 示例 3：输入：nums = [1], target = 0 输出：-1
 * 思路：如果中间的数小于最右边的数，则右半段是有序的，若中间数大于最右边数，则左半段是有序的，
 * 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/solution/duo-si-lu-wan-quan-gong-lue-bi-xu-miao-dong-by-swe/
 * https://www.ixigua.com/i6810834712366416395/?logTag=PyNXNPup3SfjGay5FrngS
 * @author luweiliang
 * @created 2020/4/29
 */
public class Lc_33_搜索旋转排序数组 {
    public static int search(int[] sums, int target){
        if (sums == null || sums.length == 0) return -1;
        int left = 0;
        int right = sums.length - 1;
        while (left + 1 < right){
            int mid = (right - left) / 2 + left;
            if (sums[mid] == target) {
                return mid;
            }
            //和target不一样的值
            if (sums[left] < sums[mid]) {
                //局部升序
                if (sums[left] <= target && target <= sums[mid]) {
                    right = mid ;
                } else {
                    left = mid;
                }
            } else {
                //局部升序
                if (sums[mid] <= target && target <= sums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if(sums[left] == target) return left;
        if(sums[right] == target) return right;
        return -1;
    }

    public static int search1(int[] sums, int target){
        if (sums == null || sums.length == 0) return -1;
        int left = 0;
        int right = sums.length - 1;
        while (left + 1 < right){
            int mid = (right - left) / 2 + left;
            if (sums[mid] == target) {
                return mid;
            }
            //和target不一样的值
            if (sums[mid] >= sums[0]) {
                //局部升序
                if (sums[left] <= target && target <= sums[mid]) {
                    right = mid ;
                } else {
                    left = mid;
                }
            } else if (sums[mid] <= sums[sums.length - 1]) {
                //局部升序
                if (sums[mid] <= target && target <= sums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if(sums[left] == target) return left;
        if(sums[right] == target) return right;
        return -1;
    }

    public static void main(String[] args){
        int[] sums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(sums, 1));
//        System.out.println(search1(sums, 3));
    }
}
