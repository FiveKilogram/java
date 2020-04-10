package LeetCode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    private int cap;
	private Map<Integer, Integer> map = new LinkedHashMap<>();  // ���ֲ���˳��

	public LRUCache(int capacity) {
		this.cap = capacity;
	}

	public int get(int key) {
		if (map.keySet().contains(key)) {
			int value = map.get(key);
			map.remove(key);
                       // ��֤ÿ�β�ѯ�󣬶���ĩβ
			map.put(key, value);
			return value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.keySet().contains(key)) {
			map.remove(key);
		} else if (map.size() == cap) {
			Iterator<Map.Entry<Integer, Integer>> iterator=map.entrySet().iterator();
			iterator.next();
			iterator.remove();
		}
		map.put(key, value);
	}
}
