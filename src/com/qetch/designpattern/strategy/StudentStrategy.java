package com.qetch.designpattern.strategy;

public class StudentStrategy implements Discount {

	@Override
	public double calculate(double price) {
		System.out.println("学生票：");
		return price * 0.8;
	}

}
