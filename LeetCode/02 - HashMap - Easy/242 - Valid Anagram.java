/**
 *
 * 242. Valid Anagram
 * Given two strings s and t, write a function to determine if t is an anagram of s. 
 * For example,
 *     s = "anagram", t = "nagaram", return true.
 *     s = "rat", t = "car", return false.
 * Note:
 *     You may assume the string contains only lowercase alphabets.
 * Follow up:
 *     What if the inputs contain unicode characters? How would you adapt your solution 
 *     to such case? 
 *
 */
import java.util.*;

public class Solution {
	public boolean isAnagram(String s, String t) {
		return sort(s).equals(sort(t));
	}
	
	public String sort(String s) {
		char[] chars = s.toCharArray();
		Arrays.sort(chars);
		return Arrays.toString(chars);
	}
}