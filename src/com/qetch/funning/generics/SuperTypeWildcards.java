package com.qetch.funning.generics;

import java.util.ArrayList;
import java.util.List;

public class SuperTypeWildcards {
	
	public static void main(String[] args) {
		List<? super Apple> apples = new ArrayList<Apple>();
		writeTo(apples);
		System.out.println(apples);
		
		/**
		 * output:
		 * [com.qetch.funning.generics.Apple@7852e922, com.qetch.funning.generics.HongFuShi@4e25154f]
		 */
	}
	
	static void writeTo(List<? super Apple> apples) {
		apples.add(new Apple());
		apples.add(new HongFuShi());
//		apples.add(new Fruit()); // Compiler Error
	}
}
