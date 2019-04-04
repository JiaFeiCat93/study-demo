package com.qetch.funning.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JDK8MainTest {

	public static void main(String[] args) {
		List<String> names1 = new ArrayList<>();
		names1.add("Google");
		names1.add("Runoob");
		names1.add("Taobao");
		names1.add("Baidu");
		names1.add("Sina");
		List<String> names2 = new ArrayList<>();
		names2.add("Google");
		names2.add("Runoob");
		names2.add("Taobao");
		names2.add("Baidu");
		names2.add("Sina");
		
		JDK8MainTest test = new JDK8MainTest();
		
		System.out.println("使用Java 7语法");
		test.sortUsingJava7(names1);
		System.out.println(names1);
		
		System.out.println("使用Java 8语法");
		test.sortUsingJava8(names2);
		System.out.println(names2);
	}
	
	private void sortUsingJava7(List<String> names) {
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
	}
	
	private void sortUsingJava8(List<String> names) {
		Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
	}
}
