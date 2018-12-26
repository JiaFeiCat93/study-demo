package com.qetch.effectivejava.item11;

public class HashTable implements Cloneable {
	private Entry[] buckets = new Entry[] {};
	
	private static class Entry {
		final Object key;
		Object value;
		Entry next;
		
		Entry(Object key, Object value, Entry next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	
	// Broken - results in shared internal state!
	@Override
	public HashTable clone() {
		try {
			HashTable result = (HashTable) super.clone();
			result.buckets = buckets.clone();
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
	
	// Remainder omitted
}
