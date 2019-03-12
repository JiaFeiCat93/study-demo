package com.qetch.designpattern.proxy.dynamicproxy;

import java.lang.reflect.Proxy;

import com.qetch.designpattern.proxy.staticproxy.BuyHouse;
import com.qetch.designpattern.proxy.staticproxy.BuyHouseImpl;

/**
 * 动态代理测试类
 * @author ZCW
 *
 */
public class DynamicProxyMainTest {
	
	public static void main(String[] args) {
		BuyHouse buyHouse = new BuyHouseImpl();
		BuyHouse buyHouseProxy = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new Class[] {BuyHouse.class}, new DynamicProxyHandler(buyHouse));
		buyHouseProxy.buyHouse();
	}
}
