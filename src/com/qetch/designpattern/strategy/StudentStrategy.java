package com.qetch.designpattern.strategy;

/**
 * 具体策略类2
 * @author ZCW
 *
 */
public class StudentStrategy implements Discount {

	@Override
	public double calculate(double price) {
		System.out.println("学生票：");
		return price * 0.8;
	}

}
