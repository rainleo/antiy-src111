package com.antiy.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author zhouye
 * @date  2019-07-17
 * map相关工具
 */
@Component
public class MapUtil<K,V> {
	public HashMap<K,V> getMap(K key,V value){
		HashMap<K, V> map = new HashMap<>(8);
		map.put(key, value);
		return map;
	}
}
