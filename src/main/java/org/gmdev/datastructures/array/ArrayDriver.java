package org.gmdev.datastructures.array;

import org.gmdev.Utils;

/**
 * Dynamic Array
 * In arrays data are stored in a contiguous block of memory.
 * Access time complexity is constant: O(1).
 * Inserting an element at beginning, time complexity: O(n) --> because i need to shift all elements.
 * Inserting an element at end, time complexity: O(1),
 * but if array is full i need to copy all the values in the new array --> time complexity: O(n).
 * Insert Inserting an element at n position, time complexity: O(n) --> because of the shift.
 */
public class ArrayDriver {
	
	public static void driver() {
		int length = 3;
		
		// create array
		DynamicArray array = new DynamicArray(length);
		
		// insert
		array.insertItem(7);
		array.insertItem(2);
		array.insertItem(9);
		array.insertItem(12);
		array.insertItem(1);
		array.insertItem(120);
		array.insertItem(-70);
		array.print(); 
		System.out.println("***");
		
		// delete
		array.removeAt(0);
		array.print(); 
		System.out.println("***");
		
		// search
		System.out.println("index of searched item is: " + array.indexOf(120));
		System.out.println("***");
		
		// insert at
		array.insertAt(400, 1);
		array.print();
		System.out.println("***");
		
		// max
		int max = array.maxElement();
		System.out.println("Max is: " + max);
		System.out.println("***");
		
		// reverse
		array.reverseArray();
		array.print();
		System.out.println("***");
		
		// find commons elements
		int[] compareArray = {120, 2, 9, 32, 67, 2, 3, 4, 5, 6, 70, 1, 1, 1};
		int[] resultCount = {0};
		int[] resultArray = findCommonsElements(array.getItems(), compareArray, resultCount);
		Utils.printIntArray(resultArray, resultCount[0]);
	}
	
	public static int[] findCommonsElements(int[]items, int[] compareArray, int[] resultCount) {
		// create the result array 
		int[] resultCommon = new int[items.length];
		
		// loop over the arrays to find intersections
		for (int i=0; i < items.length; i++) {
			int element = items[i];
			for (int j = 0; j < compareArray.length; j++) {
				// compare elements
				if (compareArray[j] == element) {
					// if value is not already present
					if (!Utils.isPresent(resultCommon, element)) {
						resultCommon[resultCount[0]] = element;
						resultCount[0] += 1;
					}
				}
			}
		}
		return resultCommon;
	}
	

}
