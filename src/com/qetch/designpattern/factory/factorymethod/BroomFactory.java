package com.qetch.designpattern.factory.factorymethod;

/**
 * 具体工厂类
 * @author ZCW
 *
 */
public class BroomFactory extends VehicleFactory {

	@Override
	Moveable create() {
		return new Broom();
	}
}
