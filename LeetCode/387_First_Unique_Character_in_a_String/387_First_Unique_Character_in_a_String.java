/**
 *
 *  387. First Unique Character in a String
 *    Given a string, find the first non-repeating character in it and return it's index. 
 *    If it doesn't exist, return -1.
 *    
 *    Examples:
 *    
 *    s = "leetcode"
 *    return 0.
 *    
 *    s = "loveleetcode",
 *    return 2.
 *
 */
import java.util.*;

public class Solution {
	public int firstUniqChar(String s) {
		int[] counts = new int[26];
		
		for (char c: s.toCharArray()) {
			counts[(int)(c - 'a')]++;
		}
		
		int i = 0;
		for (char c: s.toCharArray()) {
			if (counts[(int)(c - 'a')] == 1) {
				return i;
			}
			++i;
		}
		return -1;
	}
}