package com.qetch.designpattern.strategy;

public class StrategyMainTest {
	
	public static void main(String[] args) {
		MovieTicket movieTicket = new MovieTicket();
		double originalPrice = 60.0;
		double currentPrice = originalPrice;
		movieTicket.setPrice(originalPrice);
		System.out.println("原始票价：" + originalPrice);
		
	}
}
