package com.qetch.effectivejava.item3;

public class Singleton_V9 {
	private static volatile Singleton_V9 INSTANCE;
	
	private String name;
	
	private Singleton_V9() {}
	
	public static Singleton_V9 getInstance() {
		if (INSTANCE == null) {
			synchronized (Singleton_V9.class) {
				if (INSTANCE == null) {
					INSTANCE = new Singleton_V9();
				}
			}
		}
		return INSTANCE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void printInfo() {
		System.out.println("the name is " + name);
	}
	
	public static void main(String[] args) {
		Singleton_V9 s1 = Singleton_V9.getInstance(); 
		s1.setName("aa");
		Singleton_V9 s2 = Singleton_V9.getInstance();
		s2.setName("bb");
		
		s1.printInfo();
		s2.printInfo();
		
		if (s1 == s2) {
			System.out.println("创建的是同一个实例");
		} else {
			System.out.println("创建的不是同一个实例");
		}
	}
}
