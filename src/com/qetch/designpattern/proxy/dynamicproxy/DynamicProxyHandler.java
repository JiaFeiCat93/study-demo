package com.qetch.designpattern.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态处理器（通用）
 * 真正的代理对象是由JDK在运行时动态地创建
 * @author ZCW
 *
 */
public class DynamicProxyHandler implements InvocationHandler {
	private Object object;
	
	public DynamicProxyHandler(final Object object) {
		this.object = object;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(object, args);
		return result;
	}

}
