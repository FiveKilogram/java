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
 * @created 2020/5/25
 */
public class 计算有序数组去重后的长度 {

    public static int removeDuplicate(int[] nums){
        if (nums.length == 0) return 0;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast ++) {
            if (nums[slow] != nums[fast]) {
                slow ++;
                nums[slow] = nums[fast];
            }
        }
        //打印出重复后的新数组
        //如果数组中包括0， 那么就是 i < nums[slow]；
        //如果数组中不包括0，那么就是 i < nums[slow]；
        for (int i = 0; i < nums[slow]; i++) {
            System.out.println(nums[i]);
        }
        // 最后去重后数组的长度为去重后最后一个元素的索引 i + 1 。
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] sums = {1, 1, 2, 2, 3, 3, 3, 4, 5, 6, 6, 7, 8};
//        removeDuplicate(sums);
        System.out.println("长度：" + removeDuplicate(sums));
    }
}
