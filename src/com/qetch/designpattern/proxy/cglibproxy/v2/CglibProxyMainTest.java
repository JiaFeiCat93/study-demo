package com.qetch.designpattern.proxy.cglibproxy.v2;

public class CglibProxyMainTest {
	
	public static void main(String[] args) {
		Target target = new Target();
		TargetInterface proxy = (TargetInterface) CglibProxy.getProxy(target);
		proxy.method1();
		proxy.method2();
		System.out.println(proxy.method3(1));
	}
}
