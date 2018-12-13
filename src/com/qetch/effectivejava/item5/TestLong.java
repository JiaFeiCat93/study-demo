package com.qetch.effectivejava.item5;

public class TestLong {
	
	public static void main(String[] args) {
//		TestLong.testLong1();
		TestLong.testLong2();
	}
	
	private static void testLong1() {
		long startTime = System.currentTimeMillis();
		Long sum = 0L;
		for (long i = 0L; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(System.currentTimeMillis() - startTime);//9533ms
	}
	
	private static void testLong2() {
		long startTime = System.currentTimeMillis();
		long sum = 0L;
		for (long i = 0L; i < Integer.MAX_VALUE; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(System.currentTimeMillis() - startTime);//1205ms
	}
}
