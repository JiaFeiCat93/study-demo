package com.qetch.designpattern.strategy;

public class StrategyMainTest {
	
	public static void main(String[] args) {
		MovieTicket movieTicket = new MovieTicket();
		double originalPrice = 60.0;
		double currentPrice = originalPrice;
		movieTicket.setPrice(originalPrice);
		System.out.println("原始票价：" + originalPrice);
//		DiscountContext context = new DiscountContext(new ChildrenStrategy());
//		DiscountContext context = new DiscountContext(new StudentStrategy());
		DiscountContext context = new DiscountContext(new VIPStrategy());
		currentPrice = context.calculate(originalPrice);
		System.out.println("当前票价：" + currentPrice);
	}
}
