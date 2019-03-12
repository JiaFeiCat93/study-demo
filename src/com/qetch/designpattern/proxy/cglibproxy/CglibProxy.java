package com.qetch.designpattern.proxy.cglibproxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * CGLIB代理类
 * CHLIB创建的动态代理对象，比JDK创建的动态代理对象的性能更高，但是CGLIB创建代理对象时所花费的时间却比JDK多得多。
 * 所以对于单例的对象，因为无需频繁创建对象，用CGLIB合适，反之使用JDK方式更为合适一些。
 * 同时由于CGLIB是采用动态创建子类的方法，对于final修饰的方法无法进行代理。
 * @author ZCW
 *
 */
public class CglibProxy implements MethodInterceptor {
	private Object target;
	
	public Object getInstance(final Object target) {
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		Object result = methodProxy.invokeSuper(object, args);
		return result;
	}
}
