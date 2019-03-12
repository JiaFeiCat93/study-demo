package com.qetch.designpattern.strategy;

public class ChildrenStrategy implements Discount {

	@Override
	public double calculate(double price) {
		System.out.println("儿童票：");
		return price - 10;
	}
}
