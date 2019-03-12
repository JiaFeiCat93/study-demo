package com.qetch.designpattern.proxy.cglibproxy;

import com.qetch.designpattern.proxy.staticproxy.BuyHouse;
import com.qetch.designpattern.proxy.staticproxy.BuyHouseImpl;

public class CglibProxyMainTest {

	public static void main(String[] args) {
		BuyHouse buyHouse = new BuyHouseImpl();
		CglibProxy cglibProxy = new CglibProxy();
		BuyHouseImpl buyHouseCglibProxy = (BuyHouseImpl) cglibProxy.getInstance(buyHouse);
		buyHouseCglibProxy.buyHouse();
	}
}
