package com.qetch.funning.fibonacci;

// Calculate fibonacci sequence by recursion
public class Fibonacci_Recursion {
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int index = 50;
		for (int i = 1; i <= index; i++) {
			long result = recursion(i);
			System.out.print(result + " "); 
		}
		
		// index=10: 1 1 2 3 5 8 13 21 34 55
		
		// index=50: 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 28657 46368 75025 121393 196418 317811 514229 832040 1346269 2178309 3524578 5702887 9227465 14930352 24157817 39088169 63245986 102334155 165580141 267914296 433494437 701408733 1134903170 1836311903 2971215073 4807526976 7778742049 12586269025 
		// cost times: 96224ms
		System.out.println(System.currentTimeMillis() - startTime);
	}
	
	private static long recursion(int index) {
		if (index == 1 || index == 2) {
			return 1;
		} else {
			return recursion(index - 1) + recursion(index - 2);
		}
	}
}
