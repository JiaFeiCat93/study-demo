package com.qetch.designpattern.facade;

/**
 * 门面类
 * @author ZCW
 *
 */
public class ComputerFacade {
	private CPU cpu;
	private Disk disk;
	private Memory memory;
	
	public ComputerFacade() {
		cpu = new CPU();
		disk = new Disk();
		memory = new Memory();
	}
	
	public void start() {
		System.out.println("Computer start begin...");
		cpu.start();
		disk.start();
		memory.start();
		System.out.println("Computer start end...");
	}
	
	public void shutdown() {
		System.out.println("Computer shutdown begin...");
		cpu.shutdown();
		disk.shutdown();
		memory.shutdown();
		System.out.println("Computer shutdown end...");
	}
}
