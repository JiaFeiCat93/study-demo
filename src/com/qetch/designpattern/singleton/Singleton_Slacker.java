package com.qetch.designpattern.singleton;

/**
 * 单例模式（懒汉式）：保证一个类仅有一个实例，并提供一个访问它的全局访问点。
 * 优点：延迟加载（需要使用的时候才去加载），适合单线程操作。
 * 缺点：线程不安全，在多线程中很容易出现不同步的情况，如在数据库对象进行的频繁读写操作时。
 * @author ZCW
 *
 */
public class Singleton_Slacker {
	
	/**
	 * 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载
	 */
	private static Singleton_Slacker instance = null;
	
	/**
	 * 私有构造方法，防止被实例化
	 */
	private Singleton_Slacker() {}
	
	/**
	 * 1：懒汉式，静态工厂方法，创建实例
	 * @return
	 */
	public static Singleton_Slacker getInstance() {
		if (null == instance) {
			instance = new Singleton_Slacker();
		}
		return instance;
	}
	
	protected void method() {
		System.out.println("Singleton_Slacker...");
	}
	
	public static void main(String[] args) {
		/**
		 * 调用示例
		 */
		Singleton_Slacker.getInstance().method();
	}
}
