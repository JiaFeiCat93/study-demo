package com.qetch.designpattern.facade;

/**
 * CPU子系统类
 * @author ZCW
 *
 */
public class CPU {
	
	public void start() {
		System.out.println("CPU is starting...");
	}
	
	public void shutdown() {
		System.out.println("CPU is shutdowning...");
	}
}
