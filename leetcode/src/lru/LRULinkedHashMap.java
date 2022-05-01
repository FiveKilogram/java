/*
 * Copyright (c) 2017 maoyan.com
 * All rights reserved.
 *
 */
package lru;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * 在这里编写类的功能描述
 *
 * @author luweiliang
 * @created 2019/11/22
 */
public class LRULinkedHashMap<K, V> {
    int cacheSize;
    LinkedHashMap<K, V> cache;

    public LRULinkedHashMap(int cacheSize){
        this.cacheSize = cacheSize;
        cache = new LinkedHashMap(16, 0.75F, true){

            @Override
            protected boolean removeEldestEntry (Entry entry){
                if (cacheSize + 1 == cache.size()){
                    return true;
                } else {
                    return false;
                }
            }
        };
    }

    public V get(K key){
       return cache.get(key);
    }

    public void put(K k, V v){
       cache.put(k, v);
    }
}
