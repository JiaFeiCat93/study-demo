package com.qetch.designpattern.facade;

/**
 * Disk子系统类
 * @author ZCW
 *
 */
public class Disk {
	
	public void start() {
		System.out.println("Disk is starting...");
	}
	
	public void shutdown() {
		System.out.println("Disk is shutdowning...");
	}
}
