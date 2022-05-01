/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */

import java.util.BitSet;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2020/8/19
 */
public class 布隆过滤器 {
    private static final int DEFAULT_SIZE = 2 << 32;
    private static final int[] seeds = new int[]{1,3,5,7,11,17,19,61};
    private static SimpleHash[] funs = new SimpleHash[seeds.length];
    private static BitSet bits = new BitSet(DEFAULT_SIZE);

    //添加一个数到bit中
    public static void addValue(String value){
        for (SimpleHash fun : funs) {
            int hash = fun.hash(value);
            bits.set(hash, true);
        }
    }

    //判断是否存在该值
    public static boolean contains(String value){
        if(value == null || value.length() ==0) return true;
        boolean result = true;
        for (SimpleHash fun : funs) {
            result =  bits.get(fun.hash(value)) && result;
            if(!result) return false;//一个不存在则为不存在
        }
        return true;
    }

    public static void main(String[] args) {

        for (int i = 0; i < funs.length; i++) {
            funs[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
        }
        System.out.println(contains("my"));
        addValue("my");
        System.out.println(contains("my"));
        System.out.println(contains("my 1"));
    }

   static class SimpleHash{

        private int cap;

        private int seed;

        public SimpleHash(int cap,int seed) {
            this.cap = cap;
            this.seed =seed;
        }

        //生成hash的算法
        public int hash(String value){

            int result = 0;
            for (int i = 0; i < value.length(); i++) {
                result = seed * result + value.charAt(i);
            }
            return (cap -1 ) & result;
        }
    }

}
