package org.gmdev.datastructures.heap;

import java.util.Arrays;

/**
 * Heap
 * Time complexity for insert and remove is O(log n)
 * no look up operation is supported
 */
public class HeapDriver {
	
	public static void driver() {
		Heap heap = new Heap(10); 
		heap.insert(10);
		heap.insert(5);
		heap.insert(17);
		heap.insert(4);
		heap.insert(22);
		heap.remove();
		System.out.println("Done");
	
		// sort array in descending order
		int[] numbers = {33, 5, 23, -1, 10};
		Heap heap2 = new Heap(10); 
		for (var number : numbers)
			heap2.insert(number);
		
		for (var i = 0; i < numbers.length; i++)
			numbers[i] = heap2.remove();
		
		System.out.println(Arrays.toString(numbers));
		
		// sort array in ascending order
		int[] array = {33, 5, 23, -1, 10};
		Heap heap3 = new Heap(10);
		for (var number : array)
			heap3.insert(number);
		
		for (var i = array.length - 1; i >= 0; i--)
			array[i] = heap3.remove();
		
		System.out.println(Arrays.toString(array));
		
		int[] arr = {5, 3, 8, 4, 1, 2};
		MaxHeap.heapify(arr);
		System.out.println(Arrays.toString(arr));
		
		int[] arr2 = {5, 3, 8, 4, 1, 2};
		System.out.println(MaxHeap.getKthLargest(arr2, 2));
	}

}
