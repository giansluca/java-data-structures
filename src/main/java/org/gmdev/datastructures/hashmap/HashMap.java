package org.gmdev.datastructures.hashmap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * HashMap implementation
 */
public class HashMap {
	
	private final LinkedList<Entry>[] entries;
	
	@SuppressWarnings("unchecked")
	public HashMap(int capacity) {
		entries = new LinkedList[capacity];
	}
	
	public void put(int key, String value) {
		var entry = getEntry(key);
		
		if (entry != null) {
			entry.value = value;
			return;
		}
			
		getOrCreateBucket(key).add(new Entry(key, value));
	}
	
	public String get(int key) {
		var entry = getEntry(key);	
		
		return entry == null ? null : entry.getValue();
	}
	
	public void remove(int key) {
		var entry = getEntry(key);
		
		if (entry == null)
			throw new IllegalStateException();
		
		getBucket(key).remove(entry);
	}
	
	private LinkedList<Entry> getBucket(int key) {
		return entries[hash(key)];
	}
	
	private LinkedList<Entry> getOrCreateBucket(int key) {
		int index = hash(key);
		var bucket = entries[index];
		
		if (bucket == null)
			entries[index] = new LinkedList<Entry>();
		
		return entries[index];
	}
	
	private Entry getEntry(int key) {
		var bucket = getBucket(key);
		
		if (getBucket(key) != null)
			return bucket.stream()
					.filter(e -> e.getKey() == key)
					.findFirst()
					.orElse(null);
		
		return null;
	}
	
	private int hash(int key) {
		return key % entries.length;
	}
	
	public LinkedList<Entry>[] getEntries() {
		return entries;
	}
	
	public void print() {
		Arrays.stream(entries)
			.filter(Objects::nonNull)
			.flatMap(List<Entry>::stream)
			.forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue()));
	
	}

	/**
	 * Entry class for the linked list (Chaining)
	 */
	private static class Entry {
		private final int key;
		private String value;
		
		public Entry(int key, String value) {
			this.key = key;
			this.value = value;
		}
		
		public int getKey() {
			return key;
		}

		public String getValue() {
			return value;
		}
	}
}
