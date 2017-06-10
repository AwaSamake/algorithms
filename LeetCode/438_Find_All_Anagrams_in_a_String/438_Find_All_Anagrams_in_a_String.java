/**
 *
 * 438. Find All Anagrams in a String
 *    Given a string s and a non-empty string p, find all the start indices of p's 
 *    anagrams in s.
 *    
 *    Strings consists of lowercase English letters only and the length of both strings s 
 *    and p will not be larger than 20,100.
 *    
 *    The order of output does not matter.
 *    
 *    Example 1:
 *    
 *    Input:
 *    s: "cbaebabacd" p: "abc"
 *    
 *    Output:
 *    [0, 6]
 *    
 *    Explanation:
 *    The substring with start index = 0 is "cba", which is an anagram of "abc".
 *    The substring with start index = 6 is "bac", which is an anagram of "abc".
 *    Example 2:
 *    
 *    Input:
 *    s: "abab" p: "ab"
 *    
 *    Output:
 *    [0, 1, 2]
 *    
 *    Explanation:
 *    The substring with start index = 0 is "ab", which is an anagram of "ab".
 *    The substring with start index = 1 is "ba", which is an anagram of "ab".
 *    The substring with start index = 2 is "ab", which is an anagram of "ab".
 *    
 */
import java.util.*;

class Solution {
	public List<Integer> findAnagrams(String s, String p) {
		HashMap<Character, Integer> charFreqs = new HashMap<Character, Integer>();
		for (char c : p.toCharArray()) {
			charFreqs.put(c, charFreqs.getOrDefault(c, 0) + 1);
		}
		
		int left = 0, right = 0, length = 0;
		List<Integer> result = new ArrayList<Integer>();
		while (right < s.length()) {
			char c = s.charAt(right);
			int freq = charFreqs.getOrDefault(c, 0);
			if (freq > 0) {
				length++;
			}
			if (charFreqs.containsKey(c)) {
				charFreqs.put(c, --freq);
			}
			right++;
			if (length == p.length()) {
				result.add(left);
			}
			if (right - left == p.length()) {
				char remove = s.charAt(left);
				if (charFreqs.containsKey(remove)) {
					charFreqs.put(remove, charFreqs.get(remove) + 1);
					if (charFreqs.get(remove) > 0) {
						length--;
					}
				}
				left++;
			}
		}
		return result;
	}
}