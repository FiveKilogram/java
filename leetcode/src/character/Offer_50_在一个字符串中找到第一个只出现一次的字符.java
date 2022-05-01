/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

/**
 * Offer_50_在一个字符串中找到第一个只出现一次的字符
 * 如输入acbacd，则输出b
 *
 * @author luweiliang
 * @created 2020/11/13
 */
public class Offer_50_在一个字符串中找到第一个只出现一次的字符 {

    public static int find(String s) {
        char[] ch = s.toCharArray();
        int[] count = new int[26];
        for (char c : ch) {
            count[c - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void findFirst(String str) {
        if (str == null) {
            return;
        }
        int i = 0;
        char[] arr = str.toCharArray();

        int[] hashTable = new int[256];
        for (i = 0; i < 256; i++) {
            hashTable[i] = 0;
        }

        char[] hashKey = arr;
        for (i = 0; i < hashKey.length; i++) {
            int tmp = hashKey[i];// 将char 转为 int,即转为其对应的ASCAII码
            hashTable[tmp]++;
        }

        for (i = 0; i < hashKey.length; i++) {
            if (hashTable[hashKey[i]] == 1) {
                System.out.println((char) hashKey[i]);
                return; // 找出只出现一次的字符后就退出，若要都找出的话不退出就行
            }
        }
    }

    public static void main(String[] args) {
        String s = "acbacd";
         int judge = find(s);
         if (judge != -1) {
            System.out.println(s.charAt(judge));
         } else {
            System.out.println("没有适合的字符");
         }

//        findFirst(s);
    }
}
