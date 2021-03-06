package com.qetch.designpattern.templatemethod;

/**
 * 慕斯蛋糕
 * @author ZCW
 *
 */
public class MousseCake extends AbstractCake {

	@Override
	protected void shape() {
		System.out.println("慕斯蛋糕造型...");
	}

	@Override
	protected void spread() {
		System.out.println("慕斯蛋糕涂抹...");
	}

	@Override
	protected void bake() {
		System.out.println("慕斯蛋糕烘焙...");
	}
}
