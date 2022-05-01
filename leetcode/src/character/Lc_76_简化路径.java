/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；
 * 两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。
 * 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * 始终以斜杠 '/' 开头。
 * 两个目录名之间必须只有一个斜杠 '/' 。
 * 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 *
 * 返回简化后得到的 规范路径.
 *
 * 示例 1：
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 *
 * 示例 2：
 * 输入：path = "/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
 *
 * 示例 3：
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 *
 * 示例 4：
 * 输入：path = "/a/./b/../../c/"
 * 输出："/c"
 *
 * @author luweiliang
 * @created 2020/4/23
 */
public class Lc_76_简化路径 {

    /**
     * 解题思路
     * 本题使用了三种容器来求解绝对路径
     * 首先定义栈用来存储路径信息，定义字符数组 str 来分隔字符串
     * 依次遍历字符数组内容，这里使用增强型 for 循环，如果是 “..” 还要再判断是否为空才能弹出栈
     * 如果不为空也不为 “.” 这说明当前元素是路径信息，入栈即可
     * 最后遍历完之后，先判断栈中是否有元素，没有则返回 “/”
     * 如果有元素，则使用 StringBuilder 来存放可变字符串，最后返回 ans 即可。
     *
     * 链接：https://leetcode-cn.com/problems/simplify-path/solution/2020040371medianzhan-zi-fu-shu-zu-ke-bian-zi-fu-ch/
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        // 以 / 分割路径并存储到 str 字符串数组中
        String[] str = path.split("/");

        for (int i = 0; i < str.length; i++) {
            // 除去每个字符串两边的空格
            String cur = str[i].trim();
            if (cur == null || cur.length() == 0 || cur.equals(".")) {
                continue;
            }
            if (cur.equals("..")) {
                // 必须要判断栈是否为空
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(cur);
            }
        }

        String ans = "";
        // 巧妙的反向构建结果
        while (!stack.isEmpty()) {
            ans = "/" + stack.pop() + ans;
        }
        // 最后还要判断是否为空
        return ans.length() == 0 ? "/" : ans;
    }

    /**
     * https://leetcode-cn.com/problems/simplify-path/solution/zhan-by-powcai/
     * 思路:
     * 一句话解释: 栈解决,把当前目录压入栈中,遇到..弹出栈顶,最后返回栈中元素.
     * @param path
     * @return
     */
    public static String simplifyPath1(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String item : path.split("/")) {
            if (item.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!item.isEmpty() && !item.equals(".")) stack.push(item);
        }
        String res = "";
        for (String d : stack) res = "/" + d + res;
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        String s = simplifyPath("/home/");
        System.out.println(s);
    }
}
