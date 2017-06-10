/**
 *
 *  151. Reverse Words in a String
 *    Given an input string, reverse the string word by word.
 *    
 *    For example,
 *    Given s = "the sky is blue",
 *    return "blue is sky the".
 *
 */
import java.util.*;

public class Solution {
	public String reverseWords(String s) {
		if (s.length() < 1) {
			return "";
		}
		char[] str = s.toCharArray();
		int length = removeExtraSpace(str);
		if (length < 1) {
			return "";
		}
		reverse(str, 0, length - 1);
		int begin = 0;
		for (int i = 0; i < length; ++i) {
			if (str[i] == ' ') {
				reverse(str, begin, i - 1);
				begin = i + 1;
			}
		}
		reverse(str, begin, length - 1);
		String result = new String(str);
		return result.substring(0, length);
	}
	
	public void reverse(char[] str, int begin, int end) {
		while (begin < end) {
			char temp = str[begin];
			str[begin++] = str[end];
			str[end--] = temp;
		}
	}
	
	public int removeExtraSpace(char[] str) {
		int left = 0, right = 0;
		while (str[right] == ' ') {
			right++;
			if (right >= str.length) {
				return 0;
			}
		}
		
		while (right < str.length) {
			if (str[right] != ' ') {
				str[left++] = str[right];
			} else if (right + 1 < str.length && str[right + 1] != ' ') {
				str[left++] = str[right];
			} 
			right++;
		}
		return left++;
	}
}