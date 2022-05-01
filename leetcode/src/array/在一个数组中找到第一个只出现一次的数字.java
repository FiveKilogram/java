/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/11/14
 */
public class 在一个数组中找到第一个只出现一次的数字 {

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * 
     * @param arr
     * @return
     */
    public static Integer find_Num(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= arr.length; j++) {
                // 注意循环结束的条件，实际运行时j不会超出数组范围
                if (i == j) {
                    continue;
                }
                if (j == arr.length) {
                    // 因为这里的判断，让代码运行时在超出范围前就结束了循环
                    return arr[i];
                }
                if (arr[i] == arr[j]) {
                    break;
                }
            }
        }
        return null;// 找不到则返回null
    }

    public static int getSingleNumber(int[] arr) {
        if (arr.length == 0) { // 数组不能为空 这里我随意抛了个异常
            throw new RuntimeException("数组不能为空");
        }
        // 新建一个HashSet 集合 用于存储我们需要的结果
        Set<Integer> set = new HashSet<>();

        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
            // 如果集合包含该元素 就移除当前元素 (也就是说重复了就把数据移出容器)
            if (set.contains(arr[i])) {
                set.remove(arr[i]);
                // 移除重复数据后 继续执行循环
                continue;
            }
            // 如果不包含该元素就放入到set集合中
            set.add(arr[i]);
        }
        // 根据题意最终只会存在一个单独的数据 所以使用迭代器取出数据即可
        return set.iterator().next();

        // 取出指定的值
        // Iterator<Integer> it = set.iterator();
        // int count = 1;
        // int res = -1;
        // while (it.hasNext()) {
        // if (count == 2) {
        // res = it.next();
        // break;
        // }
        // it.next();
        // count ++;
        // }
        // return res;
    }

    public static int singleNumber(int[] nums) {
        // 初始化最终结果 ，假定第一个数是最终结果
        int result = nums[0];
        // 遍历数组 无限异或直到遍历完毕
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        // 异或特性 重复的全部消除
        return result;
    }

    public static void main(String[] args) {
        // 在一个数组中找到第一个只出现一次的数字
        int[] array = { 4, 1, 4, 2, 1, 2, 5 };
         System.out.println(find_Num(array));
        System.out.println(getSingleNumber(array));
    }

}
