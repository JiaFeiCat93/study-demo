package com.qetch.interview.multithreading.threadlocal;

public class ThreadLocalTest_V1 {
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
		
		threadLocalTest.set();
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
		
		/**
		 * 返回结果：
		 */
//		1
//		main
//		11
//		Thread-0
//		1
//		main
		
		// 从这段代码的输出结果可以看出，在main线程中和thread线程中，longLocal保存的副本值和stringLocal保存的副本值都不一样。
		// 最后一次在main线程再次打印副本值是为了证明在main线程中和thread线程中的副本值确实是不同的。
		/**
		 * 总结一下：
		 * 		1.实际通过ThreadLocal创建的副本是存储在每个线程自己的threadLocals中的；
		 * 		2.为何threadLocals类型ThreadLocalMap的键值为ThreadLocal对象，因为每个线程中可以有多个threadLocal变量，就像上面代码中的longLocal和stringLocal；
		 * 		3.在进行get之前，必须先set，否则会报空指针异常；
		 * 		如果想在get之前不需要调用set就能正常访问的话，就必须重写initValue()方法。
		 * 		因为在上面的代码（ThreadLocal源码）分析过程中，我们发现如果没有先set的话，即在map中查找不到对应的存储，则会通过调用setInitialValue方法返回，而在setInitialValue方法中，
		 * 		有一个语句是T value = initialValue();而默认情况下，initialValue方法返回的是null。
		 */
	}
}
