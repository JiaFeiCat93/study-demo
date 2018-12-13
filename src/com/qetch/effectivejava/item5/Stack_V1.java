package com.qetch.effectivejava.item5;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack_V1 {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public Stack_V1() {
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
		return elements[--size];//����ջ�ж���󣬲�û�аѶ������������Ϊ�գ������������Ҳ���ᱻ���գ��������ջ����OOM
	}
	
	/**
	 * Ensure space for at least one more element, roughly
	 * doubling the capacity each time the array needs to grow.
	 */
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}