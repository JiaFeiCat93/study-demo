package com.qetch.interview.multithreading.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的实现原理:
 * 提交一个任务到线程池中，线程池的处理流程如下：
 * 1、判断线程池里的核心线程是否都在执行任务，如果不是（核心线程空闲或者还有核心线程没有被创建）则创建一个新的工作线程来执行任务。
 * 如果核心线程都在执行任务，则进入下个流程。
 * 2、线程池判断工作队列是否已满，如果工作队列没有满，则将新提交的任务存储在这个工作队列里。如果工作队列满了，则进入下个流程。
 * 3、判断线程池里的线程是否都处于工作状态，如果没有，则创建一个新的工作线程来执行任务。如果已经满了，则交给饱和策略来处理这个任务。
 * @author ZCW
 *
 */
public class ThreadPoolTest implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		test1();
		test2();
	}
	
	private static void test1() {
		LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(5); // 存放任务的队列
		int corePoolSize = 5; // 线程池核心线程数量
		int maximumPoolSize = 10; // 线程池最大线程数量
		int keepAliveTime = 60; // 当活跃线程数大于核心线程数时，空闲的多余线程最大存活时间
		TimeUnit unit = TimeUnit.SECONDS; // 存活时间的单位
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		for (int i = 0; i < 16; i++) {
			threadPoolExecutor.execute(new Thread(new ThreadPoolTest(), "Thread".concat(i + "")));
			System.out.println("线程池中活跃的线程数：" + threadPoolExecutor.getPoolSize());
			if (workQueue.size() > 0) {
				System.out.println("**********队列中阻塞的线程数：" + workQueue.size());
			}
		}
		threadPoolExecutor.shutdown();
		
		/* 线程池中活跃的线程数：1
			线程池中活跃的线程数：2
			线程池中活跃的线程数：3
			线程池中活跃的线程数：4
			线程池中活跃的线程数：5
			线程池中活跃的线程数：5
			**********队列中阻塞的线程数：1
			线程池中活跃的线程数：5
			**********队列中阻塞的线程数：2
			线程池中活跃的线程数：5
			**********队列中阻塞的线程数：3
			线程池中活跃的线程数：5
			**********队列中阻塞的线程数：4
			线程池中活跃的线程数：5
			**********队列中阻塞的线程数：5
			线程池中活跃的线程数：6
			**********队列中阻塞的线程数：5
			线程池中活跃的线程数：7
			**********队列中阻塞的线程数：5
			线程池中活跃的线程数：8
			**********队列中阻塞的线程数：5
			线程池中活跃的线程数：9
			**********队列中阻塞的线程数：5
			线程池中活跃的线程数：10
			**********队列中阻塞的线程数：5
			Exception in thread "main" java.util.concurrent.RejectedExecutionException: Task Thread[Thread15,5,main] rejected from java.util.concurrent.ThreadPoolExecutor@7d4991ad[Running, pool size = 10, active threads = 10, queued tasks = 5, completed tasks = 0]
				at java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2063)
				at java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:830)
				at java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1379)
				at com.qetch.interview.multithreading.threadpool.ThreadPoolTest.main(ThreadPoolTest.java:26)
			 */
		/**
		 * Running, pool size = 10, active threads = 10, queued tasks = 5, completed tasks = 0
		 * 
		 * 从结果可以观察出：

			1、创建的线程池具体配置为：核心线程数量为5个；全部线程数量为10个；工作队列的长度为5。
			2、我们通过queue.size()的方法来获取工作队列中的任务数。
			3、运行原理：
			      刚开始都是在创建新的线程，达到核心线程数量5个后，新的任务进来后不再创建新的线程，而是将任务加入工作队列，任务队列到达上线5个后，
			      新的任务又会创建新的普通线程，直到达到线程池最大的线程数量10个，后面的任务则根据配置的饱和策略来处理。我们这里没有具体配置，
			      使用的是默认的配置AbortPolicy:直接抛出异常。
			　当然，为了达到我需要的效果，上述线程处理的任务都是利用休眠导致线程没有释放！！！
		 */
	}
	
	private static void test2() {
		int corePoolSize = 2; // 线程池核心线程数量
		int maximumPoolSize = 5; // 线程池最大线程数量
		int keepAliveTime = 60; // 当活跃线程数大于核心线程数时，空闲的多余线程最大存活时间
		TimeUnit unit = TimeUnit.SECONDS; // 存活时间的单位
		LinkedBlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(3); // 存放任务的队列
		/**
		 * RejectedExecutionHandler：饱和策略
		 * 当队列和线程池都满了，说明线程池处于饱和状态，那么必须对新提交的任务采用一种特殊的策略来进行处理。
		 * 这个策略默认配置是AbortPolicy，表示无法处理新的任务而抛出异常。JAVA提供了4中策略：
		 * 1、AbortPolicy：直接抛出异常
		 * 2、CallerRunsPolicy：只用调用所在的线程运行任务
		 * 3、DiscardOldestPolicy：丢弃队列里最近的一个任务，并执行当前任务
		 * 4、DiscardPolicy：不处理，丢弃掉
		 */
		RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy(); // 超出线程范围和队列容量的任务的处理程序
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
		for (int i = 0; i < 9; i++) {
			threadPoolExecutor.execute(new Thread(new ThreadPoolTest(), "Thread".concat(i + "")));
			System.out.println("线程池中活跃的线程数：" + threadPoolExecutor.getPoolSize());
			if (workQueue.size() > 0) {
				System.out.println("**********队列中阻塞的线程数：" + workQueue.size());
			}
		}
		
		/*  线程池中活跃的线程数：1
			线程池中活跃的线程数：2
			线程池中活跃的线程数：2
			**********队列中阻塞的线程数：1
			线程池中活跃的线程数：2
			**********队列中阻塞的线程数：2
			线程池中活跃的线程数：2
			**********队列中阻塞的线程数：3
			线程池中活跃的线程数：3
			**********队列中阻塞的线程数：3
			线程池中活跃的线程数：4
			**********队列中阻塞的线程数：3
			线程池中活跃的线程数：5
			**********队列中阻塞的线程数：3
			线程池中活跃的线程数：5
			**********队列中阻塞的线程数：3
			*/
		/**
		 * 这里采用了丢弃策略后，就没有再抛出异常，而是直接丢弃。在某些重要的场景下，可以采用记录日志或者存储到数据库中，而不应该直接丢弃
		 */
	}
}
