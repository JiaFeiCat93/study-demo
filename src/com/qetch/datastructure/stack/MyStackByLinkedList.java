package com.qetch.datastructure.stack;

public class MyStackByLinkedList<E> {
	Node<E> top = null;
	private int size = 0;
	
	class Node<E> {
		Node<E> next = null;
		E data;
		public Node(E data) {
			this.data = data;
		}
	}
	
	public boolean isEmpty() {
		return top == null;
	}
	
	public void push(E data) {
		Node<E> newNode = new Node<E>(data);
		newNode.next = top;
		top = newNode;
	}
	
	public E pop() {
		if (this.isEmpty()) {
			return null;
		}
		E data = top.data;
		top = top.next;
		return data;
	}
	
	public E peek() {
		if (isEmpty()) {
			return null;
		}
		return top.data;
	}
	
	public int length() {
		Node<E> node = top;
		while (node != null) {
			node = node.next;
			size++;
		}
		return size;
	}
	
	public static void main(String[] args) {
		MyStackByLinkedList<Integer> stack = new MyStackByLinkedList<>();
		stack.push(1);
		stack.push(3);
		stack.push(2);
		System.out.println("栈中元素个数：" + stack.length());
		System.out.println("栈顶元素为：" + stack.pop());
		System.out.println("栈顶元素为：" + stack.pop());
		System.out.println("栈顶元素为：" + stack.pop());
	}
}
