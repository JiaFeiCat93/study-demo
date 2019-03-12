package com.qetch.designpattern.proxy.cglibproxy.v2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Cglib代理：
 * 第三方代理技术，cglib代理。可以对任何类生成代理，代理的原理是可以对目标对象接口实现代理，也可以进行继承代理。
 * 需要引入cglib的jar文件（也需要asm.x.jar），但是Spring的核心包中已经包括了cglib功能，所以可以直接引入spring-core包。
 * @ClassName: CglibProxy
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月12日 下午10:23:55
 */
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
