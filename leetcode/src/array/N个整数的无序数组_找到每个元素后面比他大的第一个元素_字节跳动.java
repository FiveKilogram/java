/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

import java.util.Stack;

/**
 * N个整数的无序数组_找到每个元素后面比他大的第一个元素_字节跳动，如果没有找到的为-1，要求时间复杂度为O(N)
 *
 * https://blog.csdn.net/weixin_44026997/article/details/104352797
 * https://blog.csdn.net/Broken_Wave/article/details/82390882
 *
 * @author luweiliang
 * @created 2021/3/15
 */
public class N个整数的无序数组_找到每个元素后面比他大的第一个元素_字节跳动 {

    /**
     * N个整数的无序数组_找到每个元素后面比他大的第一个元素_字节跳动，如果没有找到的为是-1，要求时间复杂度为O(N)
     * 借助栈，时间复杂度O(n)
     * 思路：我们用栈来保存未找到右边第一个比它大的元素的索引（保存索引是因为后面需要靠索引来给新数组赋值），初始时，栈里放的是第一个元素的索引0值。
     * 第二是以空间换时间，用到了数据结构栈，用到了单调栈思想，单调栈可以用来解决一类问题，单调栈是指：栈内元素保持一定单调性（单调递增或单调递减）的栈。
     * 这里的单调递增或递减是指的从栈顶到栈底单调递增或递减。既然是栈，就满足后进先出的特点。与之相对应的是单调队列。
     *
     * 利用单调栈，从左至右依次压入数据的索引（若直接压数，则还需要一个数组保存栈中元素所对应的数组位置）
     * 当当前元素小于等于栈顶的索引所对应的数组的值，入栈当前索引，否则将栈顶索引出栈，并在栈顶索引所对应的res数组中记录下当前的值。
     * @param array
     * @return
     */
    public static int[] findMaxRight(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        int size = array.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();
        // 初始化栈底指针的索引为0
        stack.push(0);
        int index = 1;
        //栈底元素小于数组的长度
        while (index < size) {
            // 如果，栈不为空，同时当当前元素大于栈顶的索引所对应的数组的值，将栈顶索引出栈，并在栈顶索引所对应的res数组中记录下当前的值。
            // 栈顶较小,说明新元素是栈顶元素的后面的第一个比他大的元素
            if (!stack.isEmpty() && array[index] > array[stack.peek()]) {
                result[stack.pop()] = array[index];
            } else {
                //否则，当当前元素小于等于栈顶的索引所对应的数组的值，入栈当前索引
                stack.push(index);
                // 更新栈底指针
                index ++;
            }
        }

        //最后再检查栈中剩余元素，代表剩余元素右边没有比它大的值，在result对应位置赋值为-1
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 5, 3, 6, 4, 8, 9, 10 };
        int[] res = findMaxRight(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
