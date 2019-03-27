package com.qetch.interview.multithreading.threadpool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<Integer> callable = new MyCallableTask();
		FutureTask<Integer> futureTask = new FutureTask<>(callable);
		Thread thread = new Thread(futureTask);
		thread.start();
		Thread.sleep(100);
		// 尝试取消对此任务的执行
		futureTask.cancel(true);
		// 判断是否存在任务正常完成前
		System.out.println("future is cancel:" + futureTask.isCancelled());
		if (!futureTask.isCancelled()) {
			System.out.println("future is cancelled");
		}
		// 判断任务是否已完成
		System.out.println("future is done:" + futureTask.isDone());
		if (!futureTask.isDone()) {
			System.out.println("future get=" + futureTask.get());
		} else {
			// 任务已完成
			System.out.println("task is done");
		}
		
		/*  callable do something
			future is cancel:true
			future is done:true
			task is done
		*/
		/**
		 * 这个DEMO主要是通过调用FutureTask的状态设置的方法，演示了状态的变迁。
		 * 分析：
		 * 
		 * future.cancel(true);
		 * a、第11行，尝试取消对任务的执行，该方法如果由于任务已完成、已取消则返回false，如果能够取消还未完成的任务，则返回true，
		 * 该DEMO中由于任务还在休眠状态，所以可以取消成功。
		 * 
		 * System.out.println("future is cancel:" + future.isCancelled());
		 * b、第13行，判断任务取消是否成功：如果在任务正常完成前将其取消，则返回true
		 * 
		 * System.out.println("future is done:" + future.isDone());
		 * c、第19行，判断任务是否完成：如果任务完成，则返回true，以下几种情况都属于任务完成：正常终止、异常或者取消而完成。
    	 * 我们的DEMO中，任务是由于取消而导致完成。
    	 *
    	 * System.out.println("future get=" + future.get());
    	 * d、在第22行，获取异步线程执行的结果，我这个DEMO中没有执行到这里，需要注意的是，future.get方法会阻塞当前线程， 
    	 * 直到任务执行完成返回结果为止。
		 */
	}
}

class MyCallableTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		System.out.println("callable do something");
		Thread.sleep(5000);
		return new Random().nextInt(100);
	}
}