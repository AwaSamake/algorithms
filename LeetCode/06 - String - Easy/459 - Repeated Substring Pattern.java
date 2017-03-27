/**
 *
 * 459. Repeated Substring Pattern
 *     Given a non-empty string check if it can be constructed by taking a substring of 
 *     it and appending multiple copies of the substring together. You may assume the 
 *     given string consists of lowercase English letters only and its length will not 
 *     exceed 10000. 
 *     Example 1: 
 *         Input: "abab" 
 *         Output: True 
 *         Explanation: It's the substring "ab" twice. 
 *     Example 2: 
 *         Input: "aba" 
 *         Output: False 
 *     Example 3: 
 *         Input: "abcabcabcabc" 
 *         Output: True 
 *         Explanation: It's the substring "abc" four times. (And the substring "abcabc" 
 *         twice.)
 * 
 */
import java.util.*;

public class Solution {
	public boolean repeatedSubstringPattern(String s) {
		int length = 1;
		while (length <= s.length() / 2) {
			if (s.length() % length == 0) {
				int time = s.length() / length;
				StringBuilder result = new StringBuilder(s.length());
				String pattern = s.substring(0, length);
				for (int i = 0; i < time; ++i) {
					result.append(pattern);
				}
				if (result.toString().equals(s)) {
					return true;
				}
			}
			++length;
		}
		return false;
	}
}