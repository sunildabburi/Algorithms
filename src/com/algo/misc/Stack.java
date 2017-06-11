package com.algo.misc;

import java.util.ArrayList;
import java.util.List;

public class Stack<T> {

	int top = -1;
	List<T> elements;
	
	public Stack() {
		elements = new ArrayList<T>();
	}
	
	public void push(T element) {
		elements.add(element);
		top++;
	}
	
	public T peek() {
		if(top >= 0)
			return elements.get(top);
		return null;
	}
	
	public T pop() {
		if(top >= 0)			
			return elements.remove(top--);
		return null;
	}
	
	public boolean isEmpty() {
		return top < 0;
	}
	
	@Override
	public String toString() {
		if(top >= 0)
			return elements.toString();
		else
			return new ArrayList<T>().toString();
	}
}
