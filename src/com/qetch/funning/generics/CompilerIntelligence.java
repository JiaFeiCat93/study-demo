package com.qetch.funning.generics;

import java.util.Arrays;
import java.util.List;

public class CompilerIntelligence {

	public static void main(String[] args) {
		List<? extends Fruit> fruits = Arrays.asList(new Apple());
		Apple apple = (Apple) fruits.get(0); // No Warning
		boolean contains = fruits.contains(apple); // Argument is 'Object'
		int indexOf = fruits.indexOf(apple); // Argument is 'Object'
		System.out.println(contains); // true
		System.out.println(indexOf); // 0
		
//		fruits.add(new Apple()); // 无法编译
	}
}
