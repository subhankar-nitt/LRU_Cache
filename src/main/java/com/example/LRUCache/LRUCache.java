package com.example.LRUCache;

import java.util.HashMap;

import com.example.LRUCache.Node.Node;

public class LRUCache {
	private int capacity;
	private Node head;
	private Node tail;
	HashMap<Integer,Node>map=new HashMap<>();
	
	public LRUCache(int capacity) {
		this.capacity=capacity;
		head = null;
		tail = null;
	}
	
	public int get(int key) {
		Node res = scanList(key);
		if(res==null) {
			
			return -1;
		}else {
			updateKey(res,res.val);
		}
		return res.val;
	}
	public void put(int key,int value) {
		Node scanRes= scanList(key);
		if(scanRes!=null) {
			updateKey(scanRes, value);	
		}else{
			if(capacity!=0) {
				Node node = new Node(key,value);
				if (head==null) {
					head=node;
					tail=head;
				}else {
					Node prevHead=head;
					node.next=prevHead;
					prevHead.prev=node;
					head=node;
				}
				map.put(key, node);
				capacity--;
			}else {
				Node node = new Node(key,value);
				map.put(key, node);
                map.remove(tail.key);
				if(head==tail) {
					head=node;
					tail=head;
					return;
				}
				Node prevHead= head;
				node.next=prevHead;
				prevHead.prev=node;
				head=node;
				tail=tail.prev;
				tail.next=null;
				
			}
		}
	}
	
	public Node scanList(int key) {
		return map.get(key);
	}
	public void updateKey(Node scanRes,int value) {
		scanRes.val=value;
		Node scanNext=scanRes.next;
		Node scanPrev = scanRes.prev;
	
		if (scanPrev==null) {
			return;
		}else if(scanNext==null) {
			scanRes.next=head;
			head.prev=scanRes;
			scanPrev.next=null;
			scanRes.prev=null;
			head=scanRes;
			tail=scanPrev;
		}else {
			scanPrev.next=scanNext;
			scanNext.prev=scanPrev;
			
			scanRes.next=head;
			head.prev=scanRes;
			scanRes.prev=null;
			head=scanRes;
			
		}
		
	}

}