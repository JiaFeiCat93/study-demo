package com.qetch.funning.deadlock;

public class DeadLockTest2 {
	// 创建资源
	private static Object resourceA = new Object();
	private static Object resourceB = new Object();
	
	public static void main(String[] args) {
		Thread threadA = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (resourceA) {
					System.out.println(Thread.currentThread() + " get resourceA");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread() + " waiting get resourceB");
					synchronized (resourceB) {
						System.out.println(Thread.currentThread() + " get resourceB");
					}
				}
			}
		});
		
		Thread threadB = new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (resourceB) {
					System.out.println(Thread.currentThread() + " get resourceB");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread() + " waiting get resourceA");
					synchronized (resourceA) {
						System.out.println(Thread.currentThread() + " get resourceA");
					}
				}
			}
		});
		
		threadA.start();
		threadB.start();
	}
}
