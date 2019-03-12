package com.qetch.designpattern.proxy.cglibproxy.v2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy {
	
	public static <T> Object getProxy(T t) {
		Enhancer enhancer = new Enhancer();// 帮助我们生成代理对象
		enhancer.setSuperclass(t.getClass());// 设置要代理的目标类
		enhancer.setCallback(new MethodInterceptor() {// 代理要做什么
			
			@Override
			public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
				System.out.println("方法执行前...");
				// 调用原有方法
				Object invoke = methodProxy.invokeSuper(object, args);
//				Object invoke = methodProxy.invoke(object, args);// 作用等同上一行代码
				System.out.println("方法执行后...");
				return invoke;
			}
		});
		
		Object proxyObj = enhancer.create();// 生成代理对象
		return proxyObj;
	}
}
