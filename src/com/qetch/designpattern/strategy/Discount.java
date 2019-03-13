package com.qetch.designpattern.strategy;

/**
 * 抽象策略类
 * @ClassName: Discount
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zcw
 * @date: 2019年3月14日 上午12:03:26
 */
public interface Discount {
	double calculate(double price);
}
