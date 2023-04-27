package org.gmdev.datastructures.linkedlist;

import java.util.NoSuchElementException;

/**
 * Singly linked list
 */
public class SLinkedList {
	
	private static class Node {
		private final int value;
		private Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	
	private Node first;
	private Node last;
	private int size;
	
	public void addFirst(int item) {
		var node = new Node(item);
		
		if (isEmpty()) 
			first = last = node;
		else {
			node.next = first;
			first = node;
		}
		size++;
	}
	
	public void addLast(int item) {
		var node = new Node(item);
		
		if (isEmpty()) 
			first = last = node;
		else {
			last.next = node;
			last = node;
		}
		size++;
	}
	
	public int indexOf(int item) {
		int index = 0;
		Node node = first;
		
		while (node != null) {
			if (node.value == item) return index;
			index++;
			node = node.next;
		}
		
		return -1;
	}
	
	public boolean contains(int item) {
		return indexOf(item) != -1;
	}
	
	public void removeFirst() {
		if (isEmpty())
			throw new NoSuchElementException();
		
		if (first == last) 
			first = last = null;
		else {
			var temp = first.next;
			first.next = null;
			first = temp;
		}
		size--;
	}
	
	public void removeLast() {
		if (isEmpty())
			throw new NoSuchElementException();
		
		if (first == last)
			first = last = null;
		else {
			var previous = getPrevious(last);
			last = previous;
			last.next = null;
		}
		size--;
	}
	
	void removeAtIndex(int index) {
		if (index >= size || index < 0)
			throw new IllegalStateException();
		
		if (isEmpty())
			throw new NoSuchElementException();
		
		if (first == last)
			first = last = null;
		else if (index == 0) {
			var temp = first.next;
			first.next = null;
			first = temp;
		} else {
			var temp1 = first;
			for (int i=0; i<index-1; i++)
				temp1 = temp1.next;
			
			var temp2 = temp1.next;
			temp1.next = temp2.next;	
			temp2.next = null;
		}
	}
	
	public int size() {
		return size;
	}
	
	public int[] toArray() {
		int[] array = new int[size];
		var current = first;
		var index = 0;
		
		while (current != null) {
			array[index] = current.value;
			current = current.next;
			index++;
		}
		
		return array;
	}
	
	public void reverse() {
		if (isEmpty()) return;
		
		var previous = first;
		var current = first.next;
		
		while (current != null) {
			var next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		last = first;
		last.next = null;
		first = previous;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void print() {
		Node node = first;
		
		while (node != null) {
			System.out.println(node.value);
			node = node.next;
		}
	}
	
	public Node getFirst() {
		return first;
	}
	
	public Node getLast() {
		return last;
	}
	
	private Node getPrevious(Node node) {
		var current = first;
		
		while (current != null) {
			if (current.next == node)
				return current;
			current = current.next;
		}
		
		return null;
	}

	
}
