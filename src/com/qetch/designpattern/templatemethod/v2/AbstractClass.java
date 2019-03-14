package com.qetch.designpattern.templatemethod.v2;

/**
 * 抽象类
 * @ClassName: AbstractClass
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月15日 上午12:02:21
 */
public abstract class AbstractClass {
	protected abstract void abstractMethod1();// 抽象方法1
	protected abstract void abstractMethod2();// 抽象方法2
	public void init() {
		System.out.println("这是父类一个初始化init方法，需要做很多事情");
	}
	
	public void doSomething() {
		System.out.println("做很多事情");
	}

	public void destroy() {
		System.out.println("这是父类一个初始化destroy方法，需要做很多事情");
	}
	
	// 定义为保护类型，对外不可见
	protected void hook() {
		// 空实现，给子类留有可扩展的余地
	}
	
	// 声明为final类型，不让子类覆盖掉这个方法
	// 父类定义程序执行模板	
	public final void templateMethod() {
		init();
		abstractMethod1();// 可以是任何位置
		doSomething();
		abstractMethod2();// 可以是任何位置
		destroy();
		if (hasHook()) {
			hook();
		}
	}
	
	protected boolean hasHook() {
		return false;
	}
}
