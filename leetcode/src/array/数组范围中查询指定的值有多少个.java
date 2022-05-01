/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 在这里编写类的功能描述
 * 数组为{3, 2, 2, 3, 1} ,查询为(0, 3, 2)
 * 意思是在数组里下班0到3这个范围中，有几个2，返回2。
 * 假设给你一个数组array，读这个数组到查询非常频繁，请返回所有查询的结果
 * @author luweiliang
 * @created 2020/5/15
 */
public class 数组范围中查询指定的值有多少个 {

    private static Map<Integer, ArrayList<Integer>> map;

    public 数组范围中查询指定的值有多少个(int[] array) {

        //key -> int的值，value ->int[]的数组, 下标上面放到的值是key
        map = new HashMap<>();

        for (int i = 0; i < array.length; i ++) {
            if (! map.containsKey(array[i])) {
                map.put(array[i], new ArrayList<>());
            }
            map.get(array[i]).add(i);
        }
    }

    //查询[l .. r]范围上，有多少个value
    public static int query(int l, int r, int value){
        if (l > r) return 0;
        if (!map.containsKey(value)) return 0;
        ArrayList<Integer> indexArray = map.get(value);
        //查询小于 l 的下标有几个
        int a = countLess(indexArray, l);
        //查询小于 r + 1 的下标有几个
        int b = countLess(indexArray, r + 1);
        return b - a;
    }

    public static int countLess(ArrayList<Integer> array, int limit){
        int l = 0;
        int r = array.size() - 1;
        int mostRight =  -1;
        while (l <= r){
            int mid = l + (r - l) / 2;

            if (array.get(mid) < limit) {
                mostRight = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return mostRight + 1;
    }

    public static void main (String[] args){
        int[] array = {3, 2, 2, 2, 3, 1};
        new 数组范围中查询指定的值有多少个(array);
        System.out.println(query(0, 3, 2));

    }

}
