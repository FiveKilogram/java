/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1: 给定数组 nums = [1,1,2], 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2: 给定 nums = [0,0,1,1,1,2,2,3,3,4], 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * 你不需要考虑数组中超出新长度后面的元素。
 * 时间复杂度：O(n)，假设数组的长度是 n，那么i 和 j 分别最多遍历 n 步。
 * 空间复杂度：O(1)。
 * @author luweiliang
 * @created 2020/5/23
 */
public class Lc_26_删除排序数组中的重复项 {

    public static int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        int len = nums.length;
        // 数组只有 0 个或者 1 个元素时直接返回数组长度。
        if (len < 2) {
            return len;
        }

        // slow慢指针，fast快指针,初始值为1，最少有两个元素
        int slow = 1, fast = 1;
        while (fast < len) {
            if (nums[fast] == nums[slow - 1]) {
                fast ++;
                continue;
            }
            nums[slow] = nums[fast];
            slow ++; fast ++;
        }
        return slow;
    }

    /**
     * 打印去重复后的数据
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        int len = nums.length;
        // 数组只有 0 个或者 1 个元素时直接返回数组长度。
        if (len < 2) {
            return len;
        }
        // 定义指针 i 指向去重后数组对应索引。
        int i = 0;
        // 从第二个元素开始遍历，判断是否和 i 指向元素重复。
        for (int j = 1; j < len; j++) {
            // 如果重复则继续遍历，否则去重。
            if (nums[j] != nums[i]) {
                // 将遍历到的不重复元素对应到去重后位置。
                nums[++i] = nums[j];
            }
        }
        /**
        //打印出重复后的新数组
        //如果数组中包括0， 那么就是 m <= nums[i]；
        //如果数组中不包括0，那么就是 m < nums[i]；
        for (int m = 0; m <= nums[i]; m ++) {
            System.out.println(nums[m]);
        }
        **/

        // 最后去重后数组的长度为去重后最后一个元素的索引 i + 1 。
        return i + 1;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j ++;
                nums[j] = nums[i];
            }
        }
//        for (int i = 0; i <nums[j]; i++) {
//            System.out.println(nums[i]);
//        }
        return j + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4,5};
//        removeDuplicates(sums);
//        System.out.println("长度：" + removeDuplicates(nums));
//        System.out.println("长度：" + removeDuplicates(nums));
        int length = removeDuplicates(nums);
        System.out.println("长度：" + length);
        for (int i = 0; i < length; i ++) {
            System.out.println(nums[i]);
        }
    }
}
