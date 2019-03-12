package com.qetch.designpattern.proxy.staticproxy;

/**
 * 实际委托类
 * @author ZCW
 *
 */
public class BuyHouseImpl implements BuyHouse {

	@Override
	public void buyHouse() {
		System.out.println("我要买房...");
	}
}
