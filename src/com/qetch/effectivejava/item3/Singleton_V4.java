package com.qetch.effectivejava.item3;

public class Singleton_V4 {
	private static volatile Singleton_V4 INSTANCE;
	
	private Singleton_V4() {}
	
	public static Singleton_V4 getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton_V4.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton_V4();
				}
			}
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		Singleton_V4 s1 = Singleton_V4.getInstance();
		Singleton_V4 s2 = Singleton_V4.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
}
