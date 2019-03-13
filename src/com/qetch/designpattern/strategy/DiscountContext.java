package com.qetch.designpattern.strategy;

public class DiscountContext {
	private Discount discount;
	
	public DiscountContext(Discount discount) {
		this.discount = discount;
	}
	
	public double calculate(double price) {
		return discount.calculate(price);
	} 
}
