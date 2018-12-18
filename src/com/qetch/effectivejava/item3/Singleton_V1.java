package com.qetch.effectivejava.item3;

public class Singleton_V1 {//懒汉式单例
	private static Singleton_V1 INSTANCE;
	
	private Singleton_V1() {}//构造器改为私有，可以防止外部调用创建对象
	
	public static Singleton_V1 getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton_V1();
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		Singleton_V1 s1 = Singleton_V1.getInstance();
		Singleton_V1 s2 = Singleton_V1.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
}
