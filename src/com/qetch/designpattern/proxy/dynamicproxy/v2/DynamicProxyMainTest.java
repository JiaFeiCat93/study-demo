package com.qetch.designpattern.proxy.dynamicproxy.v2;

public class DynamicProxyMainTest {

	public static void main(String[] args) {
		Target target = new Target();
		TargetInterface proxy = (TargetInterface) DynamicProxy.getProxy(target);
		proxy.method1();
		proxy.method2();
		System.out.println(proxy.method3(1));
	}
}
