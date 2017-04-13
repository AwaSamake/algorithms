/**
 *
 * 003. Longest Substring Without Repeating Characters
 *     Given a string, find the length of the longest substring without repeating 
 *     characters.
 *     
 *     Examples:
 *     
 *     Given "abcabcbb", the answer is "abc", which the length is 3.
 *     
 *     Given "bbbbb", the answer is "b", with the length of 1.
 *     
 *     Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer 
 *     must be a substring, "pwke" is a subsequence and not a substring.
 *     
 *
 */
import java.util.*;

public class Solution {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() < 2) {
			return s.length();
		}
		int begin = 0, end = 1, max = 0;
		HashMap<Character, Integer> charIndex = new HashMap<Character, Integer>();
		charIndex.put(s.charAt(begin), begin);
		while (end < s.length()) {
			if (charIndex.containsKey(s.charAt(end))) {
				begin = Math.max(charIndex.get(s.charAt(end)) + 1, begin);
			}
			charIndex.put(s.charAt(end), end);
			max = Math.max(max, end - begin + 1);
			++end;
		}
		return max;
	}
}