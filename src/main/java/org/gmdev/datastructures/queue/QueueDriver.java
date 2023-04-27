package org.gmdev.datastructures.queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Queue
 * All operations time complexity are O(1)
 */
public class QueueDriver {
	
	public static void driver() {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		System.out.println(queue);
		
		QueueReverser.reverser(queue);
		System.out.println(queue);
		System.out.println("*****");
		
		var arrayQueue = new ArrayQueue(5);
		arrayQueue.enqueue(25);
		arrayQueue.enqueue(35);
		arrayQueue.enqueue(45);
		arrayQueue.dequeue();
		arrayQueue.dequeue();
		arrayQueue.enqueue(99);
		arrayQueue.enqueue(100);
		arrayQueue.enqueue(101);
		arrayQueue.enqueue(102);
		arrayQueue.dequeue();
		arrayQueue.enqueue(200);
		System.out.println(arrayQueue);
		System.out.println(arrayQueue.peek());
		System.out.println("*****");
		
		PriorityQueue pQueue = new PriorityQueue(5);
		pQueue.add(20);
		pQueue.add(30);
		pQueue.add(40);
		pQueue.add(25);
		pQueue.add(21);
		System.out.println(pQueue.toString());
		
		while (!pQueue.isEmpty())
			System.out.println(pQueue.remove());
	}

}
