package com.qetch.designpattern.factory.factorymethod;

/**
 * 测试类
 * @author ZCW
 *
 */
public class MoveableFactoryMainTest {
	
	public static void main(String[] args) {
		VehicleFactory planeFactory = new PlaneFactory();
		Moveable plane = planeFactory.create();
		plane.run();
		
		VehicleFactory broomFactory = new BroomFactory();
		Moveable broom = broomFactory.create();
		broom.run();
	}
}
