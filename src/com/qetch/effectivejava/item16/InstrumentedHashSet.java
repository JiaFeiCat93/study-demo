package com.qetch.effectivejava.item16;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

// Broken - Inappropriate use of inheritance!
public class InstrumentedHashSet<E> extends HashSet<E> {
	// The number of attempted element insertions
	private int addCount = 0;
	
	public InstrumentedHashSet() {}
	
	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
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
		InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
		s.addAll(Arrays.asList("Snap", "Crakle", "Pop"));
		/*
		 * 此处输出6而不是3，是因为InstrumentedHashSet继承HashSet类后，重写了add()和addAll()方法，而addAll()方法内部实际上是执行的add()方法，所以addCount的值为3+3
		 */
		System.out.println(s.getAddCount());// 6   
	}
}
