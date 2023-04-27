package org.gmdev.datastructures.heap;

/**
 * Max Heap - heapify array
 */
public class MaxHeap {
	
	public static void heapify(int[] array) {
		int lastParentIndex = array.length / 2 - 1;
		
		for (var i = lastParentIndex; i >= 0; i--)
			heapify(array, i);
	}
	
	private static void heapify(int[] array, int index) {
		var largerIndex = index;
		
		var leftIndex = index * 2 + 1;
		if (leftIndex < array.length && 
				array[leftIndex] > array[largerIndex])
			largerIndex = leftIndex;
		
		var rightIndex = index * 2 + 2;
		if (rightIndex < array.length && 
				array[rightIndex] > largerIndex)
			largerIndex = rightIndex;
		
		if (index == largerIndex)
			return;
		
		swap(array, index, largerIndex);
		heapify(array, largerIndex);
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		
	}
	
	public static int getKthLargest(int[] array, int key) {
		if (key < 1 || key > array.length)
			throw new IllegalArgumentException();
		
		var heap = new Heap(10);
		for (var item : array)
			heap.insert(item);
		
		for (var i = 0; i < key - 1; i++)
			heap.remove(); 
		
		return heap.max();
	}
	
}
