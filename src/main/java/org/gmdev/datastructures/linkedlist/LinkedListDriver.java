package org.gmdev.datastructures.linkedlist;

import java.util.Arrays;

/**
 * Linked list
 * In a linked list data are not stored in a contiguous block of memory.
 * Average case access time complexity: O(n).
 * Insert an element at beginning, time complexity constant: O(1).
 * Insert an element at end, time complexity O(1) --> if i keep the reference to the end, otherwise it is O(n).
 * Insert Inserting an element at n position, time complexity: O(n) --> need to travel at that position.
 *
 * Deleting element at beginning --> O(1)
 * Deleting element at end --> O(n) --> need to traverse the list to unlink the last node from the node before it.
 * Deleting element at n position --> O(n)
 */
public class LinkedListDriver {
	
	public static void driver() {
		// create linked list
		var linkedList = new SLinkedList();
		// add
		linkedList.addFirst(4);
		linkedList.addFirst(5);
		linkedList.addFirst(800);
		linkedList.addLast(44);
		linkedList.addLast(42);
		linkedList.addLast(127);
		linkedList.addLast(100);
		linkedList.addLast(12);
		linkedList.addLast(59);
		linkedList.print();
		System.out.println("***");
		
		// index Of
		System.out.println(linkedList.indexOf(5));
		System.out.println("***");
		
		// is present
		System.out.println(linkedList.contains(44));
		System.out.println("***");
		
		// remove
		linkedList.removeFirst();
		linkedList.removeLast();
		linkedList.print();
		System.out.println("***");
		
		// size
		System.out.println("Size: " + linkedList.size());
		System.out.println("***");
		
		// to array
		int[] array = linkedList.toArray();
		System.out.println(Arrays.toString(array));
		System.out.println("***");
		
		// reverse
		linkedList.reverse();
		linkedList.print();
		System.out.println("***");
		
		// remove at index
		var linkedList2 = new SLinkedList();
		linkedList2.addFirst(4);
		linkedList2.addFirst(5);
		linkedList2.addFirst(800);
		linkedList2.print();
		System.out.println("***-***");
		
		linkedList2.removeAtIndex(linkedList2.indexOf(5));
		linkedList2.print();
	}
	
	
}
