package com.qetch.designpattern.facade;

/**
 * Memory子系统类
 * @author ZCW
 *
 */
public class Memory {

	public void start() {
		System.out.println("Memory is starting...");
	}
	
	public void shutdown() {
		System.out.println("Memory is shutdowning...");
	}
}
