package com.qetch.designpattern.templatemethod.v2;

/**
 * 子类1
 * @ClassName: ConcreteClass1
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月15日 上午12:15:24
 */
public class ConcreteClass1 extends AbstractClass {
	private boolean isHook = true;
	
	public void setHook(boolean isHook) {
		this.isHook = isHook;
	}

	@Override
	protected boolean hasHook() {
		return this.isHook;
	}
	
	@Override
	protected void abstractMethod1() {
		System.out.println("子类ConcreteClass1，方法1，做了很多事情");
	}

	@Override
	protected void abstractMethod2() {
		System.out.println("子类ConcreteClass1，方法2，做了很多事情");
	}
}
