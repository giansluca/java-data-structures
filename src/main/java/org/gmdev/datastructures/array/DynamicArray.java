package org.gmdev.datastructures.array;

import org.gmdev.Utils;

/**
 * Dynamic array
 */
public class DynamicArray {
	
	private int[] items;
	private int count;
	
	public DynamicArray(int length) {
		items = new int[length];
		count = 0;
	}
	
	public void insertItem(int item) {
		if (count == items.length)
			extendItemsArray();
		
		items[count] = item;
		count++;
	}
	
	public void insertAt(int item, int index) {
		if (index < 0 || index >= count)
			throw new IllegalArgumentException();
		
		if (count == items.length)
			extendItemsArray();
		
		// shift elements to create the hole.
		for (int i = count - 1; i >= index; i--) {
			items[i + 1] = items[i];
		}
		
		items[index] = item;
		count++;
	}
	
	public void removeAt(int index) {
		if (index < 0 || index >= count)
			throw new IllegalArgumentException();
		
		for (int i = index; i < count - 1; i++) {
			items[i] = items[i + 1];
		}
		
		count--;
	}
	
	public int indexOf(int item) {
		for (int i = 0; i < count; i++) {
			if (items[i] == item) {
				return i;
			}
		}
		return -1;
	}
	
	public int maxElement() {
		int max = items[0];
		
		for (int i = 0; i < count; i++) {
			if (items[i] > max) {
				max = items[i];
			}
		}
		return max;
	}
	
	public void reverseArray() {
		int start = 0;
		int end = count - 1;
		
		while (start < end) {
			// swap start with end
			Utils.swapIntInArray(items, start, end);
			start++;
			end--;
		}
	}
	
	/**
	 * Extend the items array capacity
	 * new array capacity = count + array length (every extension will be the double)
	 */
	public void extendItemsArray() {
		int[] newItems = new int[count + items.length];
		
		for (int i = 0; i < count; i++) {
			newItems[i] = items[i];
		}
		
		items = newItems;
	}
	
	public int[] getItems() {
		return items;
	}
	
	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(items[i]);
		}
	}
	
}
