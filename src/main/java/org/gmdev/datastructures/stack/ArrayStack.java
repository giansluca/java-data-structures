package org.gmdev.datastructures.stack;

import java.util.Arrays;

/**
 * Stack - array implementation
 */
public class ArrayStack {
	
	private final int[] items;
	private int count;
	
	public ArrayStack(int length) {
		items = new int[length];
	}
	
	public void push(int value) {
		if (isFull())
			throw new StackOverflowError("Stack is full");
		
		items[count] = value;
		count++;
	}
	
	public int pop() {
		if (isEmpty())
			throw new IllegalStateException("Stack is empty");
		
		count--;
		return items[count];
	}
	
	public int peek() {
		if (isEmpty())
			throw new IllegalStateException("Stack is empty");
		
		return items[count - 1];
	}
	
	public boolean isFull() {
		return count == items.length;
	}
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	@Override
	public String toString() {
		int[] copy = Arrays.copyOfRange(items, 0, count);
		
		return Arrays.toString(copy);
	}
	

}
