package com.qetch.effectivejava.item3;

public class Singleton_V6 {
	private static class SingletonHolder {
		private static final Singleton_V6 INSTANCE = new Singleton_V6();
	}
	
	private Singleton_V6() {}
	
	public static final Singleton_V6 getInstance() {
		return SingletonHolder.INSTANCE;
	}
	
	public static void main(String[] args) {
		Singleton_V6 s1 = Singleton_V6.getInstance();
		Singleton_V6 s2 = Singleton_V6.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
}