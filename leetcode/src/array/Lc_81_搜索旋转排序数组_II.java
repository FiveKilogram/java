/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 搜索旋转排序数组_II
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 * 示例 1: 输入: nums = [2,5,6,0,0,1,2], target = 0 输出: true
 * 示例 2:输入: nums = [2,5,6,0,0,1,2], target = 3 输出: false
 进阶:这是 搜索旋转排序数组的延伸题目，本题中的nums可能包含重复元素。
 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 * https://www.ixigua.com/i6812248016712368654/?logTag=d-34QHi3eII-IH9oi_aqi
 * @author luweiliang
 * @created 2020/4/29
 */
public class Lc_81_搜索旋转排序数组_II {

    public static boolean search(int[] sums, int target){
        if (sums == null || sums.length == 0) return false;

        int left = 0;
        int right = sums.length - 1;
        while (left + 1 < right){
            int mid = (right - left) / 2 + left;
            if (sums[mid] == target) return true;

            //判断左右两边的数据和mid比较，如果比较重复的数据指针移动
            if (sums[left] == sums[mid] && sums[mid] == sums[right]) {
                left ++;
                right --;
            }
            if (sums[left] <= sums[mid]) {
                if(sums[left] <= target && target <= sums[mid]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (sums[mid] <= target && target <= sums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (sums[left] == target) return true;
        if (sums[right] == target) return true;
        return false;
    }

    public static void main(String[] args) {
        int array[] = {2,5,6,0,0,1,2};
        System.out.println(search(array, 3));
    }
}
