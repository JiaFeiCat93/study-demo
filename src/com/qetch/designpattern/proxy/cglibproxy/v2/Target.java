package com.qetch.designpattern.proxy.cglibproxy.v2;

public class Target implements TargetInterface {
	
	public void method1() {
		System.out.println("method1 running...");
	}
	
	public void method2() {
		System.out.println("method2 running...");
	}
	
	public int method3(Integer i) {
		System.out.println("method3 running...");
		return i;
	}
}
