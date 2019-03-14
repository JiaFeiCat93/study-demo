package com.qetch.designpattern.facade;

/**
 * 测试类
 * @author ZCW
 *
 */
public class FacadeMainTest {
	
	public static void main(String[] args) {
		ComputerFacade facade = new ComputerFacade();
		facade.start();
		System.out.println("---------------");
		facade.shutdown();
	}
}
