/**
 *
 *  091. Decode Ways
 *    A message containing letters from A-Z is being encoded to numbers using the 
 *    following mapping:
 *    
 *    'A' -> 1
 *    'B' -> 2
 *    ...
 *    'Z' -> 26
 *    Given an encoded message containing digits, determine the total number of ways to 
 *    decode it.
 *    
 *    For example,
 *    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *    
 *    The number of ways decoding "12" is 2.
 *
 */
import java.util.*;

public class Solution {
	public int numDecodings(String s) {
		if (s.length() < 1 || s.charAt(0) == '0') {
			return 0;
		}
		int[] ways = new int[s.length()];
		for (int i = 0; i < ways.length; ++i) {
			ways[i] = -1;
		}
		return numDecodings(s, ways, 0);
	}
	
	private int numDecodings(String s, int[] ways, int index) {
		if (index > ways.length) {
			return 0;
		}
		if (index == ways.length) {
			return 1;
		}
		if (ways[index] != -1) {
			return ways[index];
		}
		
		int count = 0;
		int val = Integer.valueOf(s.substring(index, index + 1));
		if (val > 0) {
			count += numDecodings(s, ways, index + 1);
			if (index + 2 <= s.length()) {
				val = Integer.valueOf(s.substring(index, index + 2));
				if (val > 0 && val < 27) {
					count += numDecodings(s, ways, index + 2);
				}
			}
		}
		
		ways[index] = count;
		return count;
	}
}