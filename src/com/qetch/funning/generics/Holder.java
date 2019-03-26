package com.qetch.funning.generics;

public class Holder<T> {
	private T value;
	public Holder() { }
	public Holder(T val) { value = val; }
	public T getValue() { return value; }
	public void setValue(T value) { this.value = value; }
	@Override
	public boolean equals(Object obj) {
		return value.equals(obj);
	}
	
	public static void main(String[] args) {
		Holder<Apple> aHolder = new Holder<Apple>(new Apple());
		Apple apple = aHolder.getValue();
		aHolder.setValue(apple);
		
//		Holder<Fruit> fHolder = aHolder; // Cannot upcast
		Holder<? extends Fruit> fHolder2 = aHolder; // OK
		Fruit fruit = fHolder2.getValue();
		apple = (Apple) fHolder2.getValue(); // Returns 'Object'
		
		try {
			Orange orange = (Orange) fHolder2.getValue(); // No warning
		} catch (Exception e) {
			System.out.println(e);
		}
//		fHolder2.setValue(new Apple()); // Cannot call setValue()
//		fHolder2.setValue(new Fruit()); // Cannot call setValue()
		System.out.println(fHolder2.equals(apple)); // OK
		
		/**
		 * output:
		 * java.lang.ClassCastException: com.qetch.funning.generics.Apple cannot be cast to com.qetch.funning.generics.Orange
		 * true
		 */
	}
}