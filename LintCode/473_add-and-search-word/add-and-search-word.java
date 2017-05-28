/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/add-and-search-word
@Language: Java
@Datetime: 17-05-27 23:30
*/

import java.util.*;

class Node {
	public boolean hasWord;
	public Node[] children;
	
	public Node() {
		children = new Node[26];
		hasWord = false;
	}
}

class WordDictionary {
	private Node root = new Node();
	
	// Adds a word into the data structure.
	public void addWord(String word) {
		int[] indexes = toIndexArray(word);
		Node walker = root;
		for (int index : indexes) {
			// System.out.println("go to" + index);
			if (walker.children[index] == null) {
				walker.children[index] = new Node();
			}
			walker = walker.children[index];
		}
		walker.hasWord = true;
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		int[] indexes = toIndexArray(word);
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(root);
		int dot = (int)('.' - 'a');
		for (int index : indexes) {
			LinkedList<Node> next = new LinkedList<Node>();
			if (index == dot) {
				while (!queue.isEmpty()) {
					Node node = queue.remove();
					for (int i = 0; i < 26; ++i) {
						if (node.children[i] != null) {
							next.add(node.children[i]);
						}
					}
				}
			} else {
				while (!queue.isEmpty()) {
					Node node = queue.remove();
					if (node.children[index] != null) {
						next.add(node.children[index]);
					}
				}
			}
			queue = next;
		}
		while (!queue.isEmpty()) {
			if (queue.remove().hasWord) {
				return true;
			}
		}
		return false;
	}
	
	private int[] toIndexArray(String word) {
		int[] indexes = new int[word.length()];
		for (int i = 0; i < indexes.length; ++i) {
			indexes[i] = (int) (word.charAt(i) - 'a');
		}
		return indexes;
	}
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");