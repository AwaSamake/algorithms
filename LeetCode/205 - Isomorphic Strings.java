/**
 *
 * 205. Isomorphic Strings
 * Given two strings s and t, determine if they are isomorphic. Two strings are 
 * isomorphic if the characters in s can be replaced to get t. All occurrences of a 
 * character must be replaced with another character while preserving the order of 
 * characters. No two characters may map to the same character but a character may map to 
 * itself. 
 * For example,
 *     Given "egg", "add", return true.
 *     Given "foo", "bar", return false.
 *     Given "paper", "title", return true.
 * Note:
 *     You may assume both s and t have the same length.
 *
 */
import java.util.*;

public class Solution {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		
		HashMap<Character, Character> hashmap = new HashMap<Character, Character>();
		char[] charS = s.toCharArray();
		char[] charT = t.toCharArray();
		
		for (int i = 0; i < charS.length; ++i) {
			if (hashmap.containsKey(charS[i]) && hashmap.get(charS[i]) != charT[i]) {
				return false;
			}
			hashmap.put(charS[i], charT[i]);
		}
		hashmap.clear();
		
		for (int i = 0; i < charS.length; ++i) {
			if (hashmap.containsKey(charT[i]) && hashmap.get(charT[i]) != charS[i]) {
				return false;
			}
			hashmap.put(charT[i], charS[i]);
		}
		return true;
	}
}