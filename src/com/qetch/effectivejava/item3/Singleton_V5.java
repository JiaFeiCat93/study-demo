package com.qetch.effectivejava.item3;

public class Singleton_V5 {
	private static final Singleton_V5 INSTANCE = new Singleton_V5();
	
	private Singleton_V5() {}
	
	public static Singleton_V5 getInstance() {
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		Singleton_V5 s1 = Singleton_V5.getInstance();
		Singleton_V5 s2 = Singleton_V5.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
}
