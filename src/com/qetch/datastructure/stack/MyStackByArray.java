package com.qetch.datastructure.stack;

import java.util.Arrays;

public class MyStackByArray<E> {
	private Object[] stack;
	private int size;// 数组中存储元素的个数
	public MyStackByArray() {
		stack = new Object[10];// 初始化长度为10
	}
	
	/**
	 * 判断堆栈是否为空
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * 获取栈顶元素（不出栈）
	 */
	@SuppressWarnings("unchecked")
	public E peek() {
		if (isEmpty()) {
			return null;
		} else {
			return (E) stack[size - 1];
		}
	}
	
	/**
	 * 出栈
	 */
	public E pop() {
		E e = peek();
		stack[size - 1] = null;
		size--;
		return e;
	}
	
	/**
	 * 入栈 
	 */
	public E push(E item) {
		ensureCapacity(size + 1);// 检查容量
		stack[size++] = item;
		return item;
	}
	
	/**
	 * 判断数组器是否已满，若已满，则扩充数组空间
	 */
	private void ensureCapacity(int size) {
		int len = stack.length;
		if (size > len) {// 数组已满
			int newLen = 10;// 每次数组扩充的容量
			stack = Arrays.copyOf(stack, newLen);
		}
	}
	
	public static void main(String[] args) {
		MyStackByArray<Integer> stack = new MyStackByArray<>();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		System.out.println("栈中元素个数：" + stack.size);
		System.out.println("栈顶元素为：" + stack.pop());
		System.out.println("栈顶元素为：" + stack.pop());
	}
}
