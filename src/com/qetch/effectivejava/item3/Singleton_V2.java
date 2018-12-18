package com.qetch.effectivejava.item3;

public class Singleton_V2 {//懒汉式单例
	private static Singleton_V2 INSTANCE;
	
	private Singleton_V2() {}//构造器改为私有，可以防止外部调用创建对象
	
	public static synchronized Singleton_V2 getInstance() {//synchronized版本
		if (INSTANCE == null) {
			INSTANCE = new Singleton_V2();
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		Singleton_V2 s1 = Singleton_V2.getInstance();
		Singleton_V2 s2 = Singleton_V2.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
}
