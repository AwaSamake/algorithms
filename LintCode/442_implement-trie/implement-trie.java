/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/implement-trie
@Language: Java
@Datetime: 17-06-05 22:36
*/

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
	TrieNode left, right;
	String word;
	// Initialize your data structure here.
	public TrieNode() {
		left = null;
		right = null;
		word = "";
	}
	
	public TrieNode(String word) {
		left = null;
		right = null;
		this.word = word;
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode walker = root;
		while (true) {
			if (word.compareTo(walker.word) == 0) {
				return;
			} else if (word.compareTo(walker.word) > 0) {
				if (walker.left == null) {
					walker.left = new TrieNode(word);
					return;
				} else {
					walker = walker.left;
				}
			} else {
				if (walker.right == null) {
					walker.right = new TrieNode(word);
					return;
				} else {
					walker = walker.right;
				}
			}
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode walker = root;
		while (walker != null) {
			if (word.compareTo(walker.word) == 0) {
				return true;
			} else if (word.compareTo(walker.word) > 0) {
				walker = walker.left;
			} else {
				walker = walker.right;
			}
		}
		return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		int length = prefix.length();
		TrieNode walker = root;
		while (walker != null) {
			if (walker.word.startsWith(prefix)) {
				return true;
			} else if (walker.word.compareTo(prefix) < 0) {
				walker = walker.left;
			} else {
				walker = walker.right;
			}
		}
		return false;
	}
}