package com.qetch.designpattern.templatemethod;

/**
 * 做蛋糕的抽象模型
 * @author ZCW
 *
 */
public abstract class AbstractCake {
	protected boolean shouldSpread() {
		return true;
	}
	protected abstract void shape();
	protected abstract void spread();
	protected abstract void bake();
	
	public final void makeCake() {// 钩子方法 
		this.shape();
		if (shouldSpread()) {
			this.spread();
		}
		this.bake();
	}
}
