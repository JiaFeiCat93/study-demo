package com.qetch.effectivejava.item11;

public class HashTable_V2 {
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
		
		// Recursively copy the linked list headed by this Entry
		Entry deepCopy() {
			return new Entry(key, value, next == null ? null : next.deepCopy());
		}
	}
	
	@Override
	public HashTable_V2 clone() {
		try {
			HashTable_V2 result = (HashTable_V2) super.clone();
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
