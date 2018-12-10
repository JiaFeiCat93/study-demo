package com.qetch.effectivejava.item3;

public enum Singleton_V7 {
	INSTANCE;
	
	public void fun1() {}
}

class Test {
	public static void main(String[] args) {
		Singleton_V7.INSTANCE.fun1();
	}
}
