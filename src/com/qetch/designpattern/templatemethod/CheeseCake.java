package com.qetch.designpattern.templatemethod;

/**
 * 芝士蛋糕
 * @author ZCW
 *
 */
public class CheeseCake extends AbstractCake {

	@Override
	protected void shape() {
		System.out.println("芝士蛋糕造型...");
	}

	@Override
	protected void spread() {
		System.out.println("芝士蛋糕涂抹...");
	}

	@Override
	protected void bake() {
		System.out.println("芝士蛋糕烘焙...");
	}
}
