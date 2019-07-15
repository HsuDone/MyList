package com.zxd.Mylist;

import java.util.NoSuchElementException;


/**
 * @author 章旭东
 *
 */
public class MyLinkedList {
	private Node head = new Node();
	private int size = 0;
	private class Node{
		Object data;
		Node next;
		public Node() {}
		public Node(Object data) {
			this.data = data;
		}
	}
	public void add(Object obj) {
		add(size, obj);
	}
	
	public void add(int index,Object obj) {
		checkOutOfBoundsWhenAdd(index);
		Node p = head;
		Node newNode = new Node(obj);
		for(int i = 0 ; i < index ; i ++)
			p = p.next;
		newNode.next = p.next;
		p.next = newNode;
		size++;
	}
	
	public Object remove(Object obj) {
		Object oldelement = null;
		Node node = head.next;
		Node pre = head;
		while(node != null)
		{
			if(node.data.equals(obj)) {
				oldelement = node.data;
				pre.next = node.next;
				this.size -- ;
				break;
			}
			pre = node;
			node = node.next;
		}
		return oldelement;
	}
	public void push(Object obj) {
		Node newNode = new Node(obj);
		newNode.next = this.head.next;
		this.head.next = newNode;
		size++;
	}
	public Object pop() {
		if(head.next == null)
			throw new NoSuchElementException("Stack is Empty");
		Object result = head.next.data;
		head.next = head.next.next;
		size --;
		return result;
	}
	public Object set(int index,Object obj) {
		checkOutOfBoundsWhenSearch(index);
		Node node = head.next;
		for(int i = 0 ; i < index ; i ++)
			node = node.next;
		Object oldelement = node.data;
		node.data = obj;
		return oldelement;
	}
		
	public Object get(int index) {
		checkOutOfBoundsWhenSearch(index);
		Node node = head.next;
		for(int i = 0 ; i < index ; i ++)
			node = node.next;
		return node.data;
	}
	public void offer(Object obj) {
		this.add(obj);
	}
	public Object poll() {
		Object res = get(0);
		remove(0);
		return res;
	}
	
	public Object remove(int index) {
		checkOutOfBoundsWhenAdd(index);
		Node node = head;
		for(int i = 0 ; i < index ; i ++)
			node = node.next;
		Object oldelment = node.next.data;
		node.next = node.next.next;
		size -- ;
		return oldelment;
	}
	
	private void checkOutOfBoundsWhenAdd(int index)
	{
		if(index < 0 || index > size)
			throw new ArrayIndexOutOfBoundsException(index);
	}
	
	private void checkOutOfBoundsWhenSearch(int index)
	{
		if(index < 0 || index >= size)
			throw new NoSuchElementException();
	}
	public int size() {
		return this.size;
	}
	public boolean isEmpty() {
		return this.head.next == null;
	}
	public boolean contains(Object obj) {
		Node node = head.next;
		while(node != null)
		{
			if(node.data.equals(obj))
				return true;
		}
		return false;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		Node p = head.next;
		while(p != null) {
			sb.append(p.data+", ");
			p = p.next;
		}
		if(!this.isEmpty())
			sb.delete(sb.lastIndexOf(","), sb.length());
		sb.append(']');
		return sb.toString();
	}
}
