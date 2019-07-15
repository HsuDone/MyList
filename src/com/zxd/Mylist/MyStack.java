package com.zxd.Mylist;

import java.util.NoSuchElementException;


/**
 * @author 章旭东
 *
 */
public class MyStack {
	private Node head = new Node();
	private class Node{
		Object data ;
		Node next;
		public Node(Object obj) {
			this.data = obj;
		}
		public Node() {}
	}
	public void push(Object obj) {
		Node newNode = new Node(obj);
		newNode.next = this.head.next;
		this.head.next = newNode;
	}
	public Object pop() {
		Object result;
		if(head.next == null)
			throw new NoSuchElementException("Stack is Empty");
		else {
			 result = head.next.data;
			head.next = head.next.next;
		}
		return result;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node p = head.next;
		while(p != null) {
			sb.append(p.data+", ");
			p = p.next;
		}
		if(! isEmpty())
			sb.delete(sb.lastIndexOf(","), sb.length());
		sb.append(']');
		return sb.toString();
	}
	public boolean isEmpty() {
		return head.next == null;
	}
	
}
