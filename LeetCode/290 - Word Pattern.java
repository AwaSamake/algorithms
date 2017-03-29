/**
 *
 * 290. Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern. Here follow 
 * means a full match, such that there is a bijection between a letter in pattern and a 
 * non-empty word in str.
 * Examples:
 *     pattern = "abba", str = "dog cat cat dog" should return true.
 *     pattern = "abba", str = "dog cat cat fish" should return false.
 *     pattern = "aaaa", str = "dog cat cat dog" should return false.
 *     pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 *     You may assume pattern contains only lowercase letters, and str contains lowercase 
 *     letters separated by a single space. 
 *
 */
import java.util.*;

public class Solution {
	public boolean wordPattern(String pattern, String str) {
		String[] parts = str.split(" ");
		if (pattern.length() != parts.length) {
		    return false;
		}
		HashMap<Character, Integer> p2i = new HashMap<Character, Integer>();
		HashMap<String, Integer> w2i = new HashMap<String, Integer>();
		for (int i = 0; i < pattern.length(); ++i) {
			if (p2i.get(pattern.charAt(i)) != w2i.get(parts[i])) {
				return false;
			}
			p2i.put(pattern.charAt(i), i+1);
			w2i.put(parts[i], i+1);
		}
		return true;
	}
}