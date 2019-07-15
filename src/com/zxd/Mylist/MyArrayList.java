package com.zxd.Mylist;

import java.util.Arrays;

/**
 * @author 章旭东
 *
 */
public class MyArrayList {
	private Object[] list = new Object[10];
	private int size = 0 ;
	public void add(Object obj) {
		add(size,obj);
	}
	public void add(int index , Object obj) {
		if(index < 0 || index > size)
			throw	new ArrayIndexOutOfBoundsException(index);
		if(size >= list.length)
			list = Arrays.copyOf(list, list.length * 2);
		System.arraycopy(list, index, list, index+1, size - index);
		list[index] = obj;
		size++;
	}
	public int size() {
		return this.size;
	}
	public Object remove(Object obj) {
		int dele = indexOf(obj);
		if(dele != -1)
			return remove(dele);
		return null;
	}
	public Object remove(int index) {
		checkIndex(index);
		Object oldelement = list[index];
		System.arraycopy(list, index+1, list, index, size - index - 1);
		size --;
		return oldelement;
	}
	public Object get(int index) {
		checkIndex(index);
			return list[index];
	}
	public Object set(int index, Object newobj) {
		checkIndex(index);
		Object old = list[index];
		list[index] = newobj;
		return old;
	}
	private void checkIndex(int index) {
		if(index <0	||	index >= size)
			throw	new ArrayIndexOutOfBoundsException();
	}
	public int indexOf(Object obj) {
		for(int i = 0 ; i < this.size ; i ++)
			if(list[i].equals(obj))
				return i;
		return -1;
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for(int i = 0 ; i < size ; i ++)
				str.append(list[i]+", ");
		if( ! this.isEmpty())
			str.delete(str.lastIndexOf(","),str.length());
		str.append(']');
		return str.toString();
	}
	public boolean contains(Object obj) {
		for(Object o : list)
		{
			if(obj.equals(o))
				return true;
		}
		return false;
	}
	public boolean isEmpty() {
		return this.size == 0;
	}
	
}
