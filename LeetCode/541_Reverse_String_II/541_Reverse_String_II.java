/**
 *
 * 541. Reverse String II
 *     Given a string and an integer k, you need to reverse the first k characters for 
 *     every 2k characters counting from the start of the string. 
 *     If there are less than k characters left, reverse all of them. 
 *     If there are less than 2k but greater than or equal to k characters, then reverse 
 *     the first k characters and left the other as original. 
 *
 *     Example: 
 *         Input: s = "abcdefg", k = 2 
 *         Output: "bacdfeg" 
 *     Restrictions: 
 *         1. The string consists of lower English letters only. 
 *         2. Length of the given string and k will in the range [1, 10000]
 * 
 */
import java.util.*;

public class Solution {
	public String reverseStr(String s, int k) {
		int begin = 0, end = k;
		char[] str = s.toCharArray();
		while (begin <= s.length()) {
			end = Math.min(end, s.length());
			reverseStr(str, begin, end);
			begin += k << 1;
			end = begin + k;
		}
		return new String(str);
	}
	
	public void reverseStr(char[] str, int begin, int end) {
		--end;
		while (begin < end) {
			char temp = str[begin];
			str[begin] = str[end];
			str[end] = temp;
			begin++;
			end--;
		}
	}
}

class test {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println(s.reverseStr("abcdefg", 8));
	}
}