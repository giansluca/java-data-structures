package org.gmdev.datastructures.hashmap;

/**
 * HashMap
 * All operations run in constant time O(1);
 */
public class HashMapDriver {
	
	public static void driver() {
		HashMap hashMap = new HashMap(5);
		hashMap.put(1, "gians1");
		hashMap.put(3, "gians2");
		hashMap.put(5, "franz");
		hashMap.put(12, "terence");
		hashMap.put(8, "tom");
		
		hashMap.print();
		System.out.println("***");
		String value = hashMap.get(37);
		System.out.println("Value: " + value);
		
		hashMap.remove(8);
		hashMap.print();
	}
}
