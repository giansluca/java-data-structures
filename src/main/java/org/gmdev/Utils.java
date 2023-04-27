package org.gmdev;

public class Utils {
	
	public static void swapIntInArray(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static boolean isPresent(int[] array, int element) {
		boolean isPresent = false;

		for (int j : array)
			if (j == element) {
				isPresent = true;
				break;
			}
			
		return isPresent;
	}
	
	public static void printIntArray(int[] array, int size) {
		for (int i = 0; i < size; i++)
			System.out.println(array[i]);
	}

}
