package org.gmdev.datastructures.queue;

import java.util.Arrays;

/**
 * Queue - array implementation
 */
public class ArrayQueue {
	
	private final int[] items;
	private int rear;
	private int front;
	private int count;
	
	public ArrayQueue(int length) {
		items = new int[length];
	}
	
	public void enqueue(int item) {
		if (isFull())
			throw new IllegalStateException("Queue is full");
		
		items[rear] = item;
		rear = (rear + 1) % items.length;
		count++;
	}
	
	public int dequeue() {
		if (isEmpty())
			throw new IllegalStateException("Queue is empty");
		
		var item = items[front];
		items[front] = 0;
		front = (front + 1) % items.length;
		count--;
		
		return item;
	}
	
	public int peek() {
		if (isEmpty())
			throw new IllegalStateException("Queue is empty");
		
		return items[front];
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
