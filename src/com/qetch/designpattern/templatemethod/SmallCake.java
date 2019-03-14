package com.qetch.designpattern.templatemethod;

/**
 * 小蛋糕
 * @author ZCW
 *
 */
public class SmallCake extends AbstractCake {
	private boolean flag = false;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	protected boolean shouldSpread() {
		return this.flag;
	}
	
	@Override
	protected void shape() {
		System.out.println("小蛋糕造型...");
	}

	@Override
	protected void spread() {
		System.out.println("小蛋糕涂抹...");
	}

	@Override
	protected void bake() {
		System.out.println("小蛋糕烘焙...");
	}
}
