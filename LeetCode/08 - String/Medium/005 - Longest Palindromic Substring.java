/**
 *
 * 005. Longest Palindromic Substring
 *    Given a string s, find the longest palindromic substring in s. You may assume that 
 *    the maximum length of s is 1000.
 *    
 *    Example:
 *    
 *    Input: "babad"
 *    
 *    Output: "bab"
 *    
 *    Note: "aba" is also a valid answer.
 *    Example:
 *    
 *    Input: "cbbd"
 *    
 *    Output: "bb"
 *
 */
import java.util.*;

class Palindrome {
	public int begin, end;
	
	public Palindrome(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
	
	public int length() {
		return end - begin + 1;
	}
}

class Solution {
	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		
		Palindrome longest = new Palindrome(0, 0);
		for (int i = 0; i < s.length(); ++i) {
			Palindrome evenPalindrome = longestPalindrome(s, i, i + 1);
			Palindrome oddPalindrome = longestPalindrome(s, i - 1, i + 1);
			if (evenPalindrome.length() > longest.length()) {
				longest = evenPalindrome;
			}
			if (oddPalindrome.length() > longest.length()) {
				longest = oddPalindrome;
			}
		}
		return s.substring(longest.begin, longest.end + 1);
	}
	
	public Palindrome longestPalindrome(String s, int left, int right) {
		if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
			return new Palindrome(0, 0);
		}
		
		while (left > 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
			left--;
			right++;
		}
		return new Palindrome(left, right);
	}
}


class Solution2 {
	public String longestPalindrome(String s) {
		if (s.length() < 2) {
			return s;
		}
		
		String longest = s.substring(0, 1);
		for (int i = 0; i < s.length(); ++i) {
			String evenPalindrome = longestPalindrome(s, i, i + 1);
			String oddPalindrome = longestPalindrome(s, i - 1, i + 1);
			if (evenPalindrome.length() > longest.length()) {
				longest = evenPalindrome;
			}
			if (oddPalindrome.length() > longest.length()) {
				longest = oddPalindrome;
			}
		}
		return longest;
	}
	
	public String longestPalindrome(String s, int left, int right) {
		if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
			return "";
		}
		
		while (left > 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
			left--;
			right++;
		}
		return s.substring(left, right + 1);
	}
}