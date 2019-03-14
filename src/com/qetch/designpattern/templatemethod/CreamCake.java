package com.qetch.designpattern.templatemethod;

/**
 * 奶油蛋糕
 * @author ZCW
 *
 */
public class CreamCake extends AbstractCake {

	@Override
	protected void shape() {
		System.out.println("奶油蛋糕造型...");
	}

	@Override
	protected void spread() {
		System.out.println("奶油蛋糕涂抹...");
	}

	@Override
	protected void bake() {
		System.out.println("奶油蛋糕烘焙...");
	}
}
