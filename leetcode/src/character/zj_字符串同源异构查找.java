/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package character;

/**
 * 在这里编写类的功能描述
 * https://blog.csdn.net/weixin_42158657/article/details/105548087
 * 如一个是源string： caabcb 目标string： acabb 。源字符中aabcb就是目标字符串（acabb ）的同源异构体
 * 思路：窗口的大小和目标串一致。进入窗口的字符，从cout中减1，出去窗口的字符，从cout中加1。
 * flag是比较器，如果flag++，标识欠目标串的。flag–，标识还给目标串的。最后如果flag==0，标识匹配到了
 * @author luweiliang
 * @created 2020/4/18
 */
public class zj_字符串同源异构查找 {

    /**
     * @param s 源值
     * @param a 目标值
     * @return
     */
    public static int commpareString(String s, String a){
        if (s == null || a == null) return -1;

        char[] aim = a.toCharArray();
        int[] count = new int[128];

        for (int  i = 0; i < aim.length; i ++) {
            count[aim[i]] ++;
        }

        //定义一个目标窗口和目标字符串一样大小 以及是否找到了同源异构的flag,flag=0代表找到了，flag=整数则表示多余字符，为负数，则缺少字符
        //什么叫欠债表呢
        //从源来字符串里从头遍历，如果一个字符串出现在欠债表里，则欠债表里的相应字符串的个数减一，如果个数小于0，则flag--
        //当第一次遍历完窗口[0...M-1]的大小的数据后,下一个窗口遍历是[1...M],
        //这是需要处理逻辑和第一次遍历窗口的逻辑不一样
        //第二次以及以后窗口向左边移动的时候，如果进入窗口的字符，如果在欠债表里已经<=0,那么flag++，且欠债表里的相应字符串的个数减一
        //从左边出去的窗口数据[R-M] 以及<0,则flag--,则欠债表里响应字符串的个数+1

        //进入窗口的字符，在欠债表里个数-1，出去窗口的字符，在欠债表里个数+1（ps:还给欠债表）

        int m = aim.length;    //窗口的长度
        char[] str = s.toCharArray();
        int flag = 0;  //无效点数的标识
        int r = 0;

        //先让窗口拥有m个字符
        for (; r < m; r++) {
            if (count[str[r]]-- <= 0){ //在-1之前已经是0了，如果再次-1必然是负数，flag+1（我欠表里字符一个）
                flag ++;
            }
        }
        //r=m
        //[0..m-1]
        //第一次形成了长度为m的窗口
        //当第一次遍历完窗口[0...M-1]的大小的数据后,下一个窗口遍历是[1...M],
        for (; r < str.length; r++) {
            //验证[0..m-1]的窗口
            if (flag == 0) {
                return r - m;
            }
            // 0[0..m-1]m
            //[1..m]
            //[1..m+1]
            //第二次以及以后窗口向左边移动的时候，如果进入窗口的字符，如果在欠债表里已经<=0,那么flag++，且欠债表里的相应字符串的个数减一
            if (count[str[r]]-- <= 0) {
                flag ++;
            }
            if(count[str[r - m]]++ < 0) {
                flag --;
            }
        }

        //最后一个窗口的判断
        return flag == 0 ? r - m : -1;
    }

    /**
     * 有2个string,一个是源string：  caabcb  目标string： acabb
     * 从源string里找到 目标的同源异构
     * 返回同源异构的起始位置
     * ----------------------------------------
     * 根据目标串新建欠债表，每个字符出现次数
     * a=2
     * c=1
     * b=2
     */
    public static void main(String [] args){

        int a = commpareString("caabcb","acabb");
        System.out.println(a);
    }


}
