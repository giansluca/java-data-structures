package org.gmdev.datastructures.tree;

/**
 * Tree 
 * Average time complexity is O(log n) if the tree is balanced
 */
public class TreeDriver {
	
	public static void driver() {
		BinarySearchTree bstTree = new BinarySearchTree();
		bstTree.insert(7);
		bstTree.insert(4);
		bstTree.insert(9);
		bstTree.insert(1);
		bstTree.insert(6);
		bstTree.insert(8);
		bstTree.insert(10);
		System.out.println("Done");
		System.out.println("***");
		System.out.println(bstTree.find(5));
		System.out.println("***");
		
		bstTree.traverseInOrder();
		System.out.println("\n***");
		
		bstTree.delete(9);
		bstTree.traverseInOrder();
		System.out.println("\n***");
		
		bstTree.traversePreOrder();
		System.out.println("\n***");
		
		bstTree.traversePostOrder();
		System.out.println("***");
		System.out.println("Height: " + bstTree.height());
		System.out.println("***");
		System.out.println("Min: " + bstTree.min());
		System.out.println("\n***");
		
		BinarySearchTree bstTree2 = new BinarySearchTree();
		bstTree2.insert(7);
		bstTree2.insert(4);
		bstTree2.insert(9);
		bstTree2.insert(1);
		bstTree2.insert(6);
		bstTree2.insert(8);
		bstTree2.insert(10);
		System.out.println("Equals: " + bstTree.equals(bstTree2));
		System.out.println("Valid: " + bstTree.isBinarySearchTree());
		System.out.println("***");
		
		var list = bstTree2.getNodesAtDistance(1);
		for (var item : list) 
			System.out.println(item);
		
		System.out.println("***");
		
		bstTree.traverseLevelOrder();
		System.out.println("***");
		System.out.println("Size: " + bstTree.size());
		System.out.println("***");
		System.out.println("Leaves: " + bstTree.countLeaves());
		System.out.println("***");
		System.out.println("Max: " + bstTree.max());
		System.out.println("***");
		
		var avlTree = new AVLTree();
		avlTree.insert(10);
		avlTree.insert(20);
		avlTree.insert(30);
		avlTree.traverseInOrder();
	
	}
	

}
