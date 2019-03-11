package com.qetch.designpattern.singleton;

/**
 * 单例模式（饿汉式）
 * @author ZCW
 *
 */
public class Singleton_Hungry {
	
	/**
	 * 此处直接赋值，以后调用时可以直接使用，为“饿汉式”。
	 */
	private static Singleton_Hungry instance = new Singleton_Hungry();
	
	private Singleton_Hungry() {}
	
	public static Singleton_Hungry getInstance() {
		return instance;
	}
	
	protected void method() {
		System.out.println("Singleton_Hungry...");
	}
	
	public static void main(String[] args) {
		Singleton_Hungry.getInstance().method();
	}
}
