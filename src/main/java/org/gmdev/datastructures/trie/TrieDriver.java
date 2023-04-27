package org.gmdev.datastructures.trie;

/**
 * Trie
 * look up and insert run in O(L) time, where L is the length of the word
 */
public class TrieDriver {
	
	public static void driver() {
		var trie = new Trie();
		trie.insert("cat");
		trie.insert("canada");
		System.out.println("Done");
		System.out.println(trie.contains("canada"));
		
		trie.traverse();
		System.out.println("************");
		
		var trie2 = new Trie();
		trie2.insert("car");
		trie2.insert("care");
		trie2.remove("car");
		System.out.println(trie2.contains("car"));
		System.out.println(trie2.contains("care"));
		System.out.println("************");
		
		var trie3 = new Trie();
		trie3.insert("car");
		trie3.insert("card");
		trie3.insert("care");
		trie3.insert("carefull");
		trie3.insert("egg");
		
		var words = trie3.findWords("car");
		System.out.println(words);
	}
	

}
