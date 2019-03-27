package com.qetch.interview.multithreading.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class CallableThreadTest implements Callable<String> {

	@Override
	public String call() throws Exception {
		System.out.println("进入call方法，开始休眠，休眠时间为：" + System.currentTimeMillis());
		Thread.sleep(10000);
		return "今天停电";
	}
	
	public static void main2(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<String> callable = new CallableThreadTest();
		Future<String> future = executorService.submit(callable);
		executorService.shutdown();
		Thread.sleep(5000);
		System.out.println("主线程休眠5秒，当前时间" + System.currentTimeMillis());
		String str = future.get();
		System.out.println("Future已拿到数据，str=" + str + "，当前时间为：" + System.currentTimeMillis());
		
		/*	进入call方法，开始休眠，休眠时间为：1553684659421
			主线程休眠5秒，当前时间1553684664437
			Future已拿到数据，str=今天停电，当前时间为：1553684669431
		 */
		/**
		 * 这里的future是直接扔到线程池里面去执行的。由于要打印任务的执行结果，所以从执行结果来看，主线程虽然休眠了5s，
		 * 但是从Call方法执行到拿到任务的结果，这中间的时间差正好是10s，说明get方法会阻塞当前线程直到任务完成。
		 */
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		Callable<String> callable = new CallableThreadTest();
		FutureTask<String> futureTask = new FutureTask<>(callable);
		executorService.submit(futureTask);
		executorService.shutdown();
		Thread.sleep(5000);
		System.out.println("主线程休眠5秒，当前时间" + System.currentTimeMillis());
		String str = futureTask.get();
		System.out.println("Future已拿到数据，str=" + str + "，当前时间为：" + System.currentTimeMillis());
		
		/*	进入call方法，开始休眠，休眠时间为：1553685024758
			主线程休眠5秒，当前时间1553685029759
			Future已拿到数据，str=今天停电，当前时间为：1553685034759
		*/
	}
	
	/**
	 * 	以上的组合可以给我们带来这样的一些变化：
		如有一种场景中，方法A返回一个数据需要10s,A方法后面的代码运行需要20s，但是这20s的执行过程中，只有后面10s依赖于方法A执行的结果。如果与以往一样采用同步的方式，势必会有10s的时间被浪费，如果采用前面两种组合，则效率会提高：
		1、先把A方法的内容放到Callable实现类的call()方法中
		2、在主线程中通过线程池执行A任务
		3、执行后面方法中10秒不依赖方法A运行结果的代码
		4、获取方法A的运行结果，执行后面方法中10秒依赖方法A运行结果的代码
		这样代码执行效率一下子就提高了，程序不必卡在A方法处。
	 */
}
