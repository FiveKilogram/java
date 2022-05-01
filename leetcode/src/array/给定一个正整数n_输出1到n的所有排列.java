/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2021/3/13
 */
public class 给定一个正整数n_输出1到n的所有排列 {
    // 递归实现列举所有排列
    public static Set<String> selectAllArrange(int n) {
        Set<String> set = new HashSet<String>();
        if (1 == n) {
            set.add("1");
        } else {
            Set<String> oldSet = selectAllArrange(n - 1);
            // 遍历n-1时得到的结果
            for (String str : oldSet) {
                // 将每个字符串转为字符数组
                char[] oldArray = str.toCharArray();
                for (int i = 0; i < n; i++) {
                    char[] newArray = new char[n];
                    // 新数组是原数组插入n后的结果
                    for (int j = 0; j < n; j++) {
                        if (j < i) {
                            newArray[j] = oldArray[j];
                        } else if (j == i) {
                            newArray[j] = String.valueOf(n).charAt(0);
                        } else {
                            newArray[j] = oldArray[j - 1];
                        }
                    }
                    // 将数组转为字符串，存入集合
                    String s = String.valueOf(newArray);
                    set.add(s);
                }
            }
        }
        return set;
    }

    public static void main(String[] args) {
        System.out.println(selectAllArrange(3));
    }
}
