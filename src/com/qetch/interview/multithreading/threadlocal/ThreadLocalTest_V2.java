package com.qetch.interview.multithreading.threadlocal;

public class ThreadLocalTest_V2 {
	ThreadLocal<Long> longLocal = new ThreadLocal<>();
	ThreadLocal<String> stringLocal = new ThreadLocal<>();
	
	public void set() {
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
	}
	
	public long getLong() {
		return longLocal.get();
	}
	
	public String getString() {
		return stringLocal.get();
	}
	
	public static void main(String[] args) throws InterruptedException {
		final ThreadLocalTest_V1 threadLocalTest = new ThreadLocalTest_V1();
		
//		threadLocalTest.set();// 在main线程中，没有先set，直接get的话，运行时会报空指针异常java.lang.NullPointerException。
		System.out.println(threadLocalTest.getLong());
		System.out.println(threadLocalTest.getString());
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				threadLocalTest.set();
				System.out.println(threadLocalTest.getLong());
				System.out.println(threadLocalTest.getString());
			}
		};
		
		thread.start();
		thread.join();
		
		System.out.println(threadLocalTest.getLong());
		System.out.println(threadLocalTest.getString());
	}
}
