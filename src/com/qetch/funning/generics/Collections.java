package com.qetch.funning.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
	
	public static void main(String[] args) {
		List<? super Apple> dest = new ArrayList<Apple>();
		List<? extends Apple> src = Arrays.asList(new Apple(), new HongFuShi());
		System.out.println(dest);
		System.out.println(src);
		System.out.println("----------------");
		copy(dest, src);
		System.out.println(dest);
		System.out.println(src);
	}
	
	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
		for (int i = 0; i < src.size(); i++) {
			dest.set(i, src.get(i));
		}
	}
}
