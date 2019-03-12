package com.qetch.designpattern.proxy.dynamicproxy.v2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * JDK动态代理：
 * JDK的Proxy方式实现的动态代理，目标对象必须有接口，没有接口不能实现JDK版动态代理。
 * @ClassName: DynamicProxy
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月12日 下午10:45:12
 */
public class DynamicProxy {
	
	public static <T> Object getProxy(T t) {
		Object object = Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), new InvocationHandler() {
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// proxy就是目标对象，method	就是调用目标对象的方法，args就是调用目标对象中方法的参数。
				// 比如说：代理对象.method1()，这时proxy就是目标类，method1就是method，args就是method1方法参数。
				System.out.println("执行方法前...");
				System.out.println("method=" + method.getName() + ",args=" + Arrays.toString(args));
				Object invoke = method.invoke(t, args);
				System.out.println("执行方法后...");
				return invoke;
			}
		});
		
		return object;
	}
}
