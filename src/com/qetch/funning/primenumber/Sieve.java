package com.qetch.funning.primenumber;

import java.util.BitSet;

/**
 * 单线程版 
 * 100以内素数: 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 57 61 67 71 73 79 83 89 97
 */
public class Sieve {
	private static final int MAX = 50000_0000;
	
	public static void main(String[] args) {
		BitSet bitSet = new BitSet();
		bitSet.set(0, true);
		long t1 = System.currentTimeMillis();
		findSieve(bitSet, MAX);
		long t2 = System.currentTimeMillis();
		int[] sieveArr = getSieveArr(bitSet, MAX);
		System.out.printf("单线程版->%n耗时%dms %n个数:%d%n", t2 - t1, sieveArr.length);
		/**
		 * 单线程版->
		 * 耗时1002ms 
		 * 个数:5761455
		 */
	}
	
	/**
	 * 转成素数数组 
	 */
	private static int[] getSieveArr(BitSet bitSet, int max) {
		int[] sieveArr = new int[max - bitSet.cardinality()];
		int n = 0;
		for (int i = 2; i <= max; i++) {
			if (!bitSet.get(i)) {
				sieveArr[n++] = i;
			}
		}
		return sieveArr;
	}
	
	/**
	 * 过滤出素数 
	 */
	private static void findSieve(BitSet bitSet, int max) {
		int k = 2;
		int sqrt = (int) Math.sqrt(max);
		while (k <= sqrt) {
			for (int i = k << 1; i <= max; i+=k) {
				bitSet.set(i, true);
			}
			for (int i = ++k; i <= max; i++) {
				if (!bitSet.get(i)) {
					k = i;
					break;
				}
			}
		}
	}
}
