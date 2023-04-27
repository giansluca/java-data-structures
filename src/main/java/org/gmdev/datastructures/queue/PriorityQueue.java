package org.gmdev.datastructures.queue;

import java.util.Arrays;

/**
 * Priority queue - array implementation
 */
public class PriorityQueue {
	
	private final int[] items;
	private int count;
	
	public PriorityQueue(int length) {
		items = new int[length];
	}
	
	public void add(int item) {
		// if queue if full throw an exception, but i can eventually resize the array and make it dynamic
		if (isFull())
			throw new IllegalStateException("Queue is full");
		
		int i = shiftItemsToInsert(item);
		items[i] = item;
		count++;
	}
	
	private int shiftItemsToInsert(int item) {
		int i;
		for (i = count - 1; i >= 0; i--) {
			if (items[i] > item)
				items[i + 1] = items[i]; 
			else
				break;
		}
		return i + 1;
	}
	
	public int remove() {
		if (isEmpty())
			throw new IllegalStateException();
		
		return items[--count];
	}
	
	public boolean isFull() {
		return count == items.length;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(items);
	}

}
