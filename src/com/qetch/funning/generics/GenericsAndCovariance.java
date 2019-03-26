package com.qetch.funning.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
	
	public static void main(String[] args) {
		// Wildcards(通配符) allows covariance: 
		List<? extends Fruit> fruits = new ArrayList<Apple>();
		// Compiler Error:can't add any type of object
//		fruits.add(new Apple());
//		fruits.add(new Fruit());
//		fruits.add(new Orange());
		fruits.add(null); // Legal but uninteresting
		// We konw that it returns at least Fruit
		Fruit f = fruits.get(0);
	}
}
