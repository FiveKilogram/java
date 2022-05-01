/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package lru;


import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
 * LRU（最近最少访问）
 * https://www.jianshu.com/p/ec1952b9d84a
 * @author luweiliang
 * @created 2019/11/22
 */
public class LRUCache extends LinkedHashMap<Integer, Integer>  {

    LinkedHashMap<Integer, Integer> cache;
    int cacheSize;

    public LRUCache(int cacheSize){
        cache = new LinkedHashMap<>(cacheSize);
        this.cacheSize = cacheSize;
    }

    public int get (int key){
        if (! cache.containsKey(key)) {
            return -1;
        }
        int value = cache.get(key);
        cache.remove(key);
        cache.put(key, value);
        return value;
    }

    public void put (int key, int value){
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
        if (cache.size() == cacheSize){
            Set<Integer> keySet = cache.keySet();
            Iterator<Integer> iterator = keySet.iterator();
            cache.remove(iterator.next());
        }
        cache.put(key, value);
    }

    public void print(){
       Iterator iterator = cache.entrySet().iterator();
       while (iterator.hasNext()){
         Entry entry = (Entry) iterator.next();
           System.out.println(entry.getKey() + ":" + entry.getValue());
       }
    }


    public static void main(String[] args) {

        LRUCache cache = new LRUCache(5);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.put(5,5);
        System.out.println(cache.get(5));
        cache.print();
        cache.put(6,6);
        cache.put(7,7);
        cache.put(5,5);
        cache.put(1,1);
        System.out.println("-------------------");
        cache.print();
    }
}
