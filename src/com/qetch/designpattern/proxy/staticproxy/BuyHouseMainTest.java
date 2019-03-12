package com.qetch.designpattern.proxy.staticproxy;

/**
 * 测试类
 * @author ZCW
 *
 */
public class BuyHouseMainTest {
	
	public static void main(String[] args) {
		BuyHouse buyHouse = new BuyHouseImpl();
		BuyHouse proxy = new BuyHouseProxy(buyHouse);
		proxy.buyHouse();
	}
}
