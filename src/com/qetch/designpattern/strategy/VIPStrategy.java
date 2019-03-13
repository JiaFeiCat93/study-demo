package com.qetch.designpattern.strategy;

/**
 * 具体策略类3
 * @ClassName: VIPStrategy
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月14日 上午12:03:53
 */
public class VIPStrategy implements Discount {

	@Override
	public double calculate(double price) {
		System.out.println("VIP票：");
		System.out.println("增加积分！");
		return price * 0.5;
	}
}
