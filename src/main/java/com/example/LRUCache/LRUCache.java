package com.example.LRUCache;

import com.example.LRUCache.Node.Node;

public class LRUCache {
	private int capacity;
	private Node head;
	private Node tail;
	
	public LRUCache(int capacity) {
		this.capacity=capacity;
		Node head = new Node(-1,-1);
		Node tail = new Node(-1,-1);
		
		head.next=tail;
		head.prev=null;
		
		tail.prev=head;
		tail.next=null;
		
		this.head=head;
		this.tail=tail;
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
				Node temp = head.next;
				head.next=node;
				node.prev=head;
				temp.prev=node;
				node.next=temp;
				capacity--;
			}else {
				Node node = new Node(key,value);
				Node prevNode = tail.prev.prev;
				if(prevNode == head) {
					tail.prev.key=key;
					tail.prev.val=value;
					return;
				}
				Node headNext = head.next;
				
				head.next=node;
				node.prev=head;
				
				node.next=headNext;
				headNext.prev=node;
				
				prevNode.next=tail;
				tail.prev=prevNode;
			}
		}
	}
	
	public void printList() {
		
		Node head=this.head;
		while(head!=null) {
			System.out.print(head.val+" ");
			head=head.next;
		}
		System.out.println();
	}
	
	public Node scanList(int key) {
		Node head= this.head;
		while(head!=null) {
			if (head.key==key) {
				return head;
			}
			head=head.next;
		}
		return null;
	}
	public void updateKey(Node scanRes,int value) {
		scanRes.val=value;
		Node scanNext=scanRes.next;
		Node scanPrev = scanRes.prev;
		
		scanPrev.next=scanNext;
		scanNext.prev=scanPrev;
		Node temp = head.next;
		head.next=scanRes;
		scanRes.prev=head;
		
		scanRes.next=temp;
		temp.prev=scanRes;	
	}

}
