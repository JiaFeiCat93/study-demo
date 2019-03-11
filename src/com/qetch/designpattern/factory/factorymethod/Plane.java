package com.qetch.designpattern.factory.factorymethod;

/**
 * 具体产品类
 * @author ZCW
 *
 */
public class Plane implements Moveable {

	@Override
	public void run() {
		System.out.println("plane...");
	}
}
