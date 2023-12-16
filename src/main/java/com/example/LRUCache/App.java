package com.example.LRUCache;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		/*
		 * LRUCache lRUCache = new LRUCache(2); lRUCache.put(1, 1); // cache is {1=1}
		 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
		 * System.out.println(lRUCache.get(1)); // return 1 lRUCache.put(3, 3); // LRU
		 * key was 2, evicts key 2, cache is {1=1, 3=3}
		 * System.out.println(lRUCache.get(2)); // returns -1 (not found)
		 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		 * System.out.println(lRUCache.get(1)); // return -1 (not found)
		 * System.out.println(lRUCache.get(3)); // return 3
		 * System.out.println(lRUCache.get(4)); // return 4
		 */    	
    	/*["LRUCache","put","get","put","get","get"]
    			[[1],[2,1],[2],[3,2],[2],[3]] */
    	
//    	LRUCache lRUCache = new LRUCache(1);
//    	lRUCache.put(2, 1);
//    	System.out.println(lRUCache.get(2));
//    	lRUCache.put(3, 2);
//    	System.out.println(lRUCache.get(2));
//    	System.out.println(lRUCache.get(3));
    	
//    	[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
    			
    	LRUCache lruCache=new LRUCache(3);
    	lruCache.put(1,1);
    	lruCache.put(2, 2);
    	lruCache.put(3, 3);
    	lruCache.put(4, 4);
    	
    	lruCache.get(4);
    	lruCache.get(3);
    	lruCache.get(2);
    	lruCache.get(1);
    	
    	lruCache.put(5,5);
    	
    	lruCache.get(1);
    	lruCache.get(2);
    	lruCache.get(3);
    	lruCache.get(3);
    	lruCache.get(4);
    	lruCache.get(5);
//    	[null,null,null,null,null,4,3,2,-1,null,-1,2,3,-1,5]
    }
}
