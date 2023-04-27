package org.gmdev.datastructures.queue;

import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
	
	public static void reverser(Queue<Integer> queue) {
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty())
			stack.push(queue.poll());
		
		while (!stack.isEmpty())
			queue.add(stack.pop());
	}

}
