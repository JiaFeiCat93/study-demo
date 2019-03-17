package com.qetch.interview.multithreading.threadlocal;

public class ThreadLocalTest_V3 {
	ThreadLocal<Long> longLocal = new ThreadLocal<Long>() {
		@Override
		protected Long initialValue() {// 重写initialValue()方法
			return Thread.currentThread().getId();
		}
	};
	
	ThreadLocal<String> stringLocal = new ThreadLocal<String>() {
		@Override
		protected String initialValue() {
			return Thread.currentThread().getName();
		}
	};
	
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
		final ThreadLocalTest_V3 threadLocalTest = new ThreadLocalTest_V3();
		
//		threadLocalTest.set();// 可以直接不用先set，而可以直接调用get
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
		
//		1
//		main
//		11
//		Thread-0
//		1
//		main
	}
}
