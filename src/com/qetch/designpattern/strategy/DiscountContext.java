package com.qetch.designpattern.strategy;

/**
 * 策略模式上下文
 * @ClassName: DiscountContext
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月14日 上午12:03:08
 */
public class DiscountContext {
	private Discount discount;
	
	public DiscountContext(Discount discount) {
		this.discount = discount;
	}
	
	public double calculate(double price) {
		return discount.calculate(price);
	} 
}
