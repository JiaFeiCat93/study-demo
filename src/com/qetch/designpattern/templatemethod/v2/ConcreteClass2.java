package com.qetch.designpattern.templatemethod.v2;

/**
 * 子类2
 * @ClassName: ConcreteClass2
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月15日 上午12:16:03
 */
public class ConcreteClass2 extends AbstractClass {

	@Override
	protected void abstractMethod1() {
		System.out.println("子类ConcreteClass2，方法1，做了很多事情");
	}

	@Override
	protected void abstractMethod2() {
		System.out.println("子类ConcreteClass2，方法2，做了很多事情");
	}
	
	@Override
	protected void hook() {
		System.out.println("子类ConcreteClass2，钩子方法，增加一些附加功能");
	}
}
