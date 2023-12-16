package com.example.LRUCache;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	LRUCache lRUCache = new LRUCache(2);
//    	lRUCache.put(1, 1); // cache is {1=1}
//    	lRUCache.put(2, 2); // cache is {1=1, 2=2}
//    	System.out.println(lRUCache.get(1));    // return 1
//    	lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//    	System.out.println(lRUCache.get(2));    // returns -1 (not found)
//    	lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//    	System.out.println(lRUCache.get(1));    // return -1 (not found)
//    	System.out.println(lRUCache.get(3));    // return 3
//    	System.out.println(lRUCache.get(4));    // return 4
    	
    	/*["LRUCache","put","get","put","get","get"]
    			[[1],[2,1],[2],[3,2],[2],[3]] */
    	
    	LRUCache lRUCache = new LRUCache(1);
    	lRUCache.put(2, 1);
    	System.out.println(lRUCache.get(2));
    	lRUCache.put(3, 2);
    	System.out.println(lRUCache.get(2));
    	System.out.println(lRUCache.get(3));
    	

    }
}
