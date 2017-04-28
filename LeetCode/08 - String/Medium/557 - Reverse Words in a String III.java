/**
 *
 *  557. Reverse Words in a String III
 *    Given a string, you need to reverse the order of characters in each word within a 
 *    sentence while still preserving whitespace and initial word order.
 *    
 *    Example 1:
 *    Input: "Let's take LeetCode contest"
 *    Output: "s'teL ekat edoCteeL tsetnoc"
 *    Note: In the string, each word is separated by single space and there will not be 
 *    any extra space in the string.
 *
 */
import java.util.*;

class Solution {
	public String reverseWords(String s) {
		String[] words = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (String word: words) {
			sb.append(reverse(word));
			sb.append(" ");
		}
		return sb.substring(0, sb.length() - 1);
	}
	
	private String reverse(String word) {
		char[] chars = word.toCharArray();
		int left = 0, right = word.length() - 1;
		
		while (left < right) {
			char temp = chars[left];
			chars[left++] = chars[right];
			chars[right--] = temp;
		}
		return new String(chars);
	}
}