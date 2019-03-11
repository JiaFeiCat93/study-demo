package com.qetch.designpattern.singleton;

/**
 * 双重线程检查模式：
 * 优点：延迟加载，线程安全
 * 缺点：写法复杂，不简洁
 * @author ZCW
 *
 */
public class Singleton_DoubleCheck {
	private static volatile Singleton_DoubleCheck instance = null;// 这里添加了volatile修饰符
	
	private Singleton_DoubleCheck() {}
	
	public static Singleton_DoubleCheck getInstance() {
		Singleton_DoubleCheck inst = instance;
		if (null == inst) {
			synchronized (Singleton_DoubleCheck.class) {
				inst = instance;// 此行代码是否有必要？？？
				if (null == inst) {
					inst = new Singleton_DoubleCheck();
				}
			}
		}
		return inst;// 注意，此处返回的是临时变量
	}
	
	protected void method() {
		System.out.println("Singleton_DoubleCheck...");
	}
	
	public static void main(String[] args) {
		Singleton_DoubleCheck.getInstance().method();
	}
}
