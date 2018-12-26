package com.qetch.funning.primenumber;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 多线程版 
 * 100以内素数: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 57 61 67 71 73 79 83 89 97
 */
public class ConcurrentSieve {
	private static final int MAX = 10000_0000;
	
	public static void main(String[] args) {
		final Queue<Integer> baseSieve = baseSieve((int) Math.sqrt(MAX));
		final boolean[] bitSet = new boolean[MAX + 1];
		bitSet[0] = bitSet[1] = true;
		int threadNum = Runtime.getRuntime().availableProcessors() - 3; // CPU线程数
		final CountDownLatch latch = new CountDownLatch(threadNum); // 控制住线程等待子线程
		ExecutorService exec = Executors.newFixedThreadPool(threadNum); // 创建线程池
		long t3 = System.currentTimeMillis();
		for (int i = 0; i < threadNum; i++) {
			exec.execute(new Runnable() { // 创建子线程任务
				@Override
				public void run() {
					findSieve(bitSet, baseSieve, MAX);
					latch.countDown();
				}
			});
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long t4 = System.currentTimeMillis();
		Integer[] sieveArr = getSieveArr(bitSet, MAX);
		System.out.printf("多线程版->%n耗时:%dms %n个数:%d%n", t4 - t3, sieveArr.length);
		exec.shutdown();
		
		/**
		 * 多线程版->
		 * 耗时:1392ms 
		 * 个数:5761455
		 */
	}
	
	/**
	 * 利用boolean数组过滤出素数 
	 */
	private static void findSieve(boolean[] bitSet, Queue<Integer> baseSieve, int max) {
		Integer m = 2;
		int k = 2;
		while ((m = baseSieve.poll()) != null) {
			k = m; // 防止for循环时自动拆箱
			for (int i = k << 1; i <= max; i+=k) {
				bitSet[i] = true;
			}
		}
	}
	
	/**
	 * 转成素数数组 
	 */
	private static Integer[] getSieveArr(boolean[] bitSet, int max) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < bitSet.length; i++) {
			if (!bitSet[i]) {
				list.add(i);
			}
		}
		return list.toArray(new Integer[list.size()]);
	}
	
	/**
	 * 生成基础素数队列 
	 */
	private static Queue<Integer> baseSieve(int base) {
		BitSet baseBitSet = new BitSet();
		int k = 2; // 素数
		int sqrt = (int) Math.sqrt(base);
		while (k <= sqrt) {
			for (int i = k << 1; i <= base; i+=k) {
				baseBitSet.set(i, true);
			}
			for (int i = ++k; i <= base; i++) {
				if (!baseBitSet.get(i)) {
					k = i;
					break;
				}
			}
		}
		LinkedBlockingQueue<Integer> baseSieve = new LinkedBlockingQueue<>();
		for (int i = 2; i < baseBitSet.length(); i++) {
			if (!baseBitSet.get(i)) {
				baseSieve.offer(i);
			}
		}
		return baseSieve;
	}
}
