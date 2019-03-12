package com.qetch.designpattern.singleton;

/**
 * 通过枚举来实现单例，推荐使用
 * @ClassName: Singleton_Enum
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月12日 下午11:18:02
 */
public enum Singleton_Enum {
	INSTANCE;
	
	public void method() {
		System.out.println("Singleton_Enum...");
	}
	
	public static void main(String[] args) {
		Singleton_Enum.INSTANCE.method();
	}
}
