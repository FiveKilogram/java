/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 寻找旋转排序数组中的最小值
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组[0,1,2,4,5,6,7] 可能变为[4,5,6,7,0,1,2])。
 * 请找出其中最小的元素。你可以假设数组中不存在重复元素。
 * 示例 1: 输入: [3,4,5,1,2] 输出: 1
 * 示例 2: 输入: [4,5,6,7,0,1,2] 输出: 0
 *
 * 时间复杂度为O(logN)
 * 空间复杂度为O(1)
 * @author luweiliang
 * @created 2020/5/22
 */
public class Lc_153_寻找旋转排序数组中的最小值 {

    public static int findMin(int[] nums) {
        int left = 0;
        //左闭右闭区间，如果用右开区间则不方便判断右值
        int right = nums.length - 1;
        //循环不变式，如果left == right，则循环结束
        while (left < right) {
            int mid = left + (right - left) / 2;
            //中值 > 右值，最小值在右半边，收缩左边界
            if (nums[mid] > nums[right]) {          //中值 > 右值，最小值在右半边，收缩左边界
                left = mid + 1;                     // 因为中值 > 右值，中值肯定不是最小值，左边界可以跨过mid
            } else if (nums[mid] < nums[right]) {   // 明确中值 < 右值，最小值在左半边，收缩右边界
                right = mid;                        // 因为中值 < 右值，中值也可能是最小值，右边界只能取到mid处
            }
        }
        //循环结束，left == right，最小值输出nums[left]或nums[right]均可
        return nums[left];
    }

    public static void main(String[] args) {
        int array[] = {4, 5, 6, 7, 0, 1, 2};
        int index = findMin(array);
        System.out.println(index);
    }
}
