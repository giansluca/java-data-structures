package org.gmdev.datastructures.stack;

/**
 * Stack
 * All operations time complexity are O(1)
 */
public class StackDriver {
	
	public static void driver() {
		int length = 5;
		
		// create stack
		ArrayStack stack = new ArrayStack(length);
		
		// push
		stack.push(45);
		stack.push(34);
		stack.push(2);
		stack.push(65);
		
		//pop
		System.out.println(stack.pop());
		System.out.println("***");
		System.out.println(stack);
		
		// peek
		System.out.println(stack.peek());
		System.out.println("***");
		System.out.println(StringReverser.reverse("hello yes"));
		System.out.println("***");
		String expression = "(< 1 + 2 {u} >)[66]";
		
		ExpressionBalance exp = new ExpressionBalance();
		var isBalanced = exp.isBalanced(expression);
		System.out.println("is balanced: "+ isBalanced);
	}

}
