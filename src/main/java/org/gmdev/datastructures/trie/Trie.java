package org.gmdev.datastructures.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Trie implementation
 */
public class Trie {
	public static int ALPHABET_SIZE = 26;
	
	private static class Node {
		private final char value;
		private final HashMap<Character, Node> children = new HashMap<>();
		private boolean isEndOfWord;
		
		public Node(char value) {
			this.value = value;
		}
		
		public boolean hasChild(char ch) {
			return children.containsKey(ch);
		}
		
		public void addChild(char ch) {
			children.put(ch, new Node(ch));
		}
		
		public Node getChild(char ch) {
			return children.get(ch);
		}
		
		public Node[] getChildren() {
			return children.values().toArray(new Node[0]);
		}
		
		public boolean hasChildren() {
			return !children.isEmpty();
		}
		
		public void removeChild(char ch) {
			children.remove(ch);
		}
		
		@Override
		public String toString() {
			return "Value=" + value;
		}
	}
	
	private Node root = new Node(' ');
	
	public void insert(String word) {
		if (word == null)
			throw new IllegalStateException();
		
		var current = root; 
		
		for (char ch : word.toCharArray()) {
			if (!current.hasChild(ch))
				current.addChild(ch);
			
			current = current.getChild(ch);
		}
		
		current.isEndOfWord = true;
	}
	
	public boolean contains(String word) {
		if (word == null)
			return false;
		
		var current = root;
		for (char ch : word.toCharArray()) {
			if (!current.hasChild(ch))
				return false;
			current = current.getChild(ch);
		}
		
		return current.isEndOfWord;
	}
	
	public void traverse() {
		traverse(root);
	}
	
	private void traverse(Node root) {
		// Pre-order traversal: visit the root first
		//System.out.println(root.value);
		
		for (var child : root.getChildren())
			traverse(child);
		
		// Post-order traversal: visit root last
		System.out.println(root.value);	
	}
	
	public void remove(String word) {
		if (word == null) 
			return;
		remove(word, root, 0);
	}
	
	private void remove(String word, Node root, int index) {
		if (index == word.length()) {
			root.isEndOfWord = false;
			return;
		}
		var ch = word.charAt(index);
		var child = root.getChild(ch);
		if (child == null)
			return;
		
		remove(word, child, index + 1);
		
		if (!child.hasChildren() && !child.isEndOfWord)
			root.removeChild(ch);
	}
	
	public List<String> findWords(String prefix) {
		List<String> words = new ArrayList<>();
		var lastNode = findLastNodedOf(prefix);
		findWords(lastNode, prefix, words);
		
		return words;
	}
	
	private void findWords(Node root, String prefix, List<String> words) {
		if (root == null)
			return;
		
		if (root.isEndOfWord)
			words.add(prefix);
		
		for (var child : root.getChildren())
			findWords(child, prefix + child.value, words);		
	}
	
	private Node findLastNodedOf(String prefix) {
		if (prefix == null)
			return null;
		
		var current = root;
		for (var ch : prefix.toCharArray()) {
			var child = current.getChild(ch);
			if (child == null)
				return null;
			current = child;
		}
		
		return current;
	}

	
}

