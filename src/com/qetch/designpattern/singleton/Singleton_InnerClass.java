package com.qetch.designpattern.singleton;

/**
 * 静态内部类模式：
 * 优点：延迟加载，线程安全（java中class加载是互斥的），也减少了内存消耗，推荐使用静态内部类的方式。
 * @author ZCW
 *
 */
public class Singleton_InnerClass {
	
	/**
	 * 内部类实现单例模式
	 * 延迟加载，减少内存开销
	 */
	private static class SingletonHolder {
		private static Singleton_InnerClass instance = new Singleton_InnerClass();
	}
	
	private Singleton_InnerClass() {}
	
	public static Singleton_InnerClass getInstance() {
		return SingletonHolder.instance;
	}
	
	protected void method() {
		System.out.println("Singleton_InnerClass...");
	}
	
	public static void main(String[] args) {
		Singleton_InnerClass.getInstance().method();
	}
}
