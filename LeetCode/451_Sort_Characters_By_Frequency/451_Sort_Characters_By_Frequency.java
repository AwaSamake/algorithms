/**
 *
 * 451. Sort Characters By Frequency
 *     Given a string, sort it in decreasing order based on the frequency of characters.
 *     
 *     Example 1:
 *     
 *     Input:
 *     "tree"
 *     
 *     Output:
 *     "eert"
 *     
 *     Explanation:
 *     'e' appears twice while 'r' and 't' both appear once.
 *     So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid 
 *     answer.
 *     Example 2:
 *     
 *     Input:
 *     "cccaaa"
 *     
 *     Output:
 *     "cccaaa"
 *     
 *     Explanation:
 *     Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 *     Note that "cacaca" is incorrect, as the same characters must be together.
 *     Example 3:
 *     
 *     Input:
 *     "Aabb"
 *     
 *     Output:
 *     "bbAa"
 *     
 *     Explanation:
 *     "bbaA" is also a valid answer, but "Aabb" is incorrect.
 *     Note that 'A' and 'a' are treated as two different characters.
 *
 */
import java.util.*;

class Node implements Comparable<Node> {
	public int count;
	public char character;
	
	public Node(char character, int count) {
		this.character = character;
		this.count = count;
	}
	
	@Override
	public int compareTo(Node other){
		return other.count - this.count;
	}
}

public class Solution {
	public String frequencySort(String s) {
		HashMap<Character, Integer> freq = new HashMap<Character, Integer>();
		
		for (char c : s.toCharArray()) {
			freq.put(c, freq.getOrDefault(c, 0) + 1);
		}
		
		Node[] nodes = new Node[freq.size()];
		int i = 0;
		for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
			nodes[i++] = new Node(entry.getKey(), entry.getValue());
		}
		Arrays.sort(nodes);
		return buildString(nodes);
	}
	
	public String buildString(Node[] nodes) {
		StringBuilder sb = new StringBuilder();
		for (Node node: nodes) {
			
			for (int i = 0; i < node.count; ++i) {
				sb.append(node.character);
			}
		}
		return sb.toString();
	}
}











