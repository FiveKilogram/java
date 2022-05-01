/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package num;

/**
 * 转换为二进制
 *
 * @author luweiliang
 * @created 2019/9/20
 */
public class Binary {
    public static void main(String[] args) {
        String str = toBinary(11);
        System.out.println(str);
    }

    static String toBinary(int num) {
        String str = "";
        while (num != 0) {
            str = num % 2 + str;
            num = num / 2;
        }
        return str;
    }
}
