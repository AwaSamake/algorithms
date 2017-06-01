/**
 *
 *  395. Longest Substring with At Least K Repeating Characters
 *    Find the length of the longest substring T of a given string (consists 
 *    of lowercase letters only) such that every character in T appears no 
 *    less than k times.
 *    
 *    Example 1:
 *    
 *    Input:
 *    s = "aaabb", k = 3
 *    
 *    Output:
 *    3
 *    
 *    The longest substring is "aaa", as 'a' is repeated 3 times.
 *    Example 2:
 *    
 *    Input:
 *    s = "ababbc", k = 2
 *    
 *    Output:
 *    5
 *    
 *    The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is 
 *    repeated 3 times.
 *
 */
import java.util.*;

public class Solution {
	public int longestSubstring(String s, int k) {
		HashMap<Character, ArrayList<Integer>> charMap = new HashMap<>();
		int i = 0;
		for (char c: s.toCharArray()) {
			charMap.put(c, charMap.getOrDefault(c, new ArrayList<Integer>).add(i++));
		}
		
		for (Map.Entry<Character, Integer> entry: charMap.entrySet()) {
			if (entry.getValue() >= k) {
				charSet.add(entry.getKey());
			}
		}
		int begin = 0, max = 0;
		for (int i = 0; i < s.length(); ++i) {
			if (charSet.contains(s.charAt(i))) {
				i++;
				max = Math.max(max, i - begin);
			} else {
				begin = i + 1;
			}
		}
		return max;
	}
}