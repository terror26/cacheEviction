package cacheEviction;

import java.util.List;

import cacheEviction.algorithm.LruCache;

public class MainClass {

	public static void main(String[] args) {
		// cache of size 3 , 1,1  : 2,2 : 3,3 , 1,1 add 4,4 then cache items = 44 11 33 
		// put 5,5 , then result = 55 44 11
		
		LruCache<Integer, String> lru = new LruCache<>(3);
		lru.addKeyValue(1, "1");
		lru.addKeyValue(2, "2");
		lru.addKeyValue(3, "3");
		lru.addKeyValue(1, "1");
		lru.addKeyValue(4, "4");
		
		lru.printKeys(); 
		System.out.println("----------- ");
		
		lru.addKeyValue(5, "5");
		
		lru.printKeys(); 
		
		
	}

}
