package com.qetch.effectivejava.item11;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack implements Cloneable {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop() {
		if (size == 0) {
			throw new EmptyStackException();
		}
		Object result = elements[--size];
		elements[size] = null;//Eliminate obsolete reference
		return result;
	}
	
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
	
	@Override
	public Stack clone() {
		try {
			Stack result = (Stack) super.clone();
			result.elements = elements.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
	
	public static void main(String[] args) {
		Stack s1 = new Stack();
		s1.push("123");
		s1.push("456");
		Stack s2 = s1.clone();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s2.pop()); // 456
	}
}
