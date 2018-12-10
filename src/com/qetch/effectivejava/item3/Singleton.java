package com.qetch.effectivejava.item3;

public class Singleton {
	public static final Singleton INSTANCE = new Singleton();
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if (INSTANCE == null) {
			return new Singleton();
		} else {
			return INSTANCE;
		}
	}
	
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
}
