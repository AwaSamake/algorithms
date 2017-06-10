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
		String[] words = str.split(" ");
		if (pattern.length() != words.length) {
		    return false;
		}
		
		HashMap<Character, String> p2w = new HashMap<Character, String>();
		for (int i = 0; i < pattern.length(); ++i) {
			char p = pattern.charAt(i);
			if (p2w.containsKey(p) && !p2w.get(p).equals(words[i])) {
				return false;
			}
			p2w.put(p, words[i]);
		}
		
		HashMap<String, Character> w2p = new HashMap<String, Character>();
		for (int i = 0; i < pattern.length(); ++i) {
			if (w2p.containsKey(words[i]) && w2p.get(words[i]) != pattern.charAt(i)) {
				return false;
			}
			w2p.put(words[i], pattern.charAt(i));
		}
		return true;
	}
}