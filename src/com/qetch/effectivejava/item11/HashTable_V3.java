package com.qetch.effectivejava.item11;

public class HashTable_V3 {
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
		
		// Iteratively copy the linked list headed by this Entry
		Entry deepCopy() {
			Entry result = new Entry(key, value, next);
			for (Entry p = result; p.next != null; p = p.next) {
				p.next = new Entry(p.key, p.value, p.next);
			}
			return result;
		}
	}
	
	@Override
	public HashTable_V3 clone() {
		try {
			HashTable_V3 result = (HashTable_V3) super.clone();
			result.buckets = new Entry[buckets.length];
			for (int i = 0; i < buckets.length; i++) {
				if (buckets[i] != null) {
					result.buckets[i] = buckets[i].deepCopy();
				}
			}
			return result;
		} catch (CloneNotSupportedException e) {
			throw new AssertionError();
		}
	}
	
	// Remainder omitted
}
