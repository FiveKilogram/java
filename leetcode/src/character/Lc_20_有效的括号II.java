/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计一种算法，返回n对括号的所有合法的(开闭一一对应)组合；
 * 要求：解集不能包含重复的子集。
 * 举例：给出 n=3,生成结果[((())), (()()), (())(), ()(()), ()()()]
 * 思路：深度优先搜索 + 剪枝
 * @author luweiliang
 * @created 2020/5/8
 */
public class Lc_20_有效的括号II {

    public static List<String> generateParentheses(int n){
        //返回的集合
        List<String> list = new ArrayList<>();
        //构建一个括号的数组，应为括号是成对出现的
        char[] chars = new char[n * 2];
        //定义chars的下标
        int index = 0;
        dfs(list, chars, n, n, index);
        return list;
    }

    //深度优先搜索
    public static void dfs(List<String> list, char[] chars, int left, int right, int index){
        if (left > right) return;
        if (left == 0 && right == 0) list.add(new String(chars));

        if (left > 0) {
            chars[index] = '(';
            dfs(list, chars, left - 1, right, index + 1);
        }
        if (right > 0) {
            chars[index] = ')';
            dfs(list, chars, left, right - 1, index + 1);
        }
    }

    public static void main (String[] args){
        System.out.println(generateParentheses(3));
    }
}
