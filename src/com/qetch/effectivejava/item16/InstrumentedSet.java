package com.qetch.effectivejava.item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// Wrapper class - uses composition in place of inheritance
public class InstrumentedSet<E> extends ForwardingSet<E> {
	private int addCount = 0;
	
	public InstrumentedSet(Set<E> s) {
		super(s);
	}
	
	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}
	
	public int getAddCount() {
		return addCount;
	}
	
	public static void main(String[] args) {
		InstrumentedSet<String> s = new InstrumentedSet<>(new TreeSet<>());
		s.addAll(Arrays.asList("Snap", "Crakle", "Pop"));
		System.out.println(s.getAddCount());// 3
		
//		Date cmp = new Date();
//		Set<Date> s1 = new InstrumentedSet<>(new TreeSet<>(cmp));
//		
//		int capacity = 0;
//		Set<E> s2 = new InstrumentedSet<>(new HashSet<>(capacity));
	}
	
	static void walk(Set<Dog> dogs) {
		InstrumentedSet<Dog> iDogs = new InstrumentedSet<>(dogs);
		// ... Within this method use iDogs instead of dogs
	}
}
