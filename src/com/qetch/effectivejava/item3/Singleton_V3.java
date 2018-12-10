package com.qetch.effectivejava.item3;

public class Singleton_V3 {//懒汉式单例
	private static Singleton_V3 INSTANCE;
	
	private Singleton_V3() {}//构造器改为私有，可以防止外部调用创建对象
	
	public static Singleton_V3 getInstance() {//双重检查（Double-Check）版本
		if (INSTANCE == null) {
			synchronized (Singleton_V3.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton_V3();
				}
			}
		}
		return INSTANCE;
	}
	
	public static void main(String[] args) {
		Singleton_V3 s1 = Singleton_V3.getInstance();
		Singleton_V3 s2 = Singleton_V3.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1 == s2);
	}
}
