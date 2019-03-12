package com.qetch.designpattern.proxy.staticproxy;

/**
 * 代理类（静态代理）：
 * 优点：可以做到在符合开闭原则的情况下对目标对象进行功能扩展。
 * 缺点：需要给每一个服务创建代理类，工作量太大，不易管理。接口一旦发生变化，代理类也要响应修改。
 * @author ZCW
 *
 */
public class BuyHouseProxy implements BuyHouse {
	private BuyHouse buyHouse;
	
	public BuyHouseProxy(final BuyHouse buyHouse) {
		this.buyHouse = buyHouse;
	}
	
	@Override
	public void buyHouse() {
		buyHouse.buyHouse();
	}
}
