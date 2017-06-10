/**
 *
 * 394. Decode String
 *    Given an encoded string, return it's decoded string.
 *    
 *    The encoding rule is: k[encoded_string], where the encoded_string inside the square 
 *    brackets is being repeated exactly k times. Note that k is guaranteed to be a 
 *    positive integer.
 *    
 *    You may assume that the input string is always valid; No extra white spaces, square 
 *    brackets are well-formed, etc.
 *    
 *    Furthermore, you may assume that the original data does not contain any digits and 
 *    that digits are only for those repeat numbers, k. For example, there won't be input 
 *    like 3a or 2[4].
 *    
 *    Examples:
 *    
 *    s = "3[a]2[bc]", return "aaabcbc".
 *    s = "3[a2[c]]", return "accaccacc".
 *    s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 */
import java.util.*;

class Solution {
	public String decodeString(String s) {
		Stack<Integer> repeats = new Stack<Integer>();
		Stack<StringBuilder> strings = new Stack<StringBuilder>();
		StringBuilder num = new StringBuilder();
		strings.push(new StringBuilder());
		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);
			if (c == '[') {
				strings.push(new StringBuilder());
				repeats.push(Integer.valueOf(num.toString()));
				num = new StringBuilder();
			} else if (c == ']') {
				int times = 0;
				if (num.length() > 0) {
					times = Integer.valueOf(num.toString());
					num = new StringBuilder();
				} else {
					times = repeats.pop();
				}
				StringBuilder top = strings.pop();
				strings.peek().append(makeCopy(top, times));
			} else if (Character.isAlphabetic(c)) {
				strings.peek().append(c);
			} else if (Character.isDigit(c)) {
				num.append(c);
			}
		}
		
		return strings.pop().toString();
	}
	
	private StringBuilder makeCopy(StringBuilder str, int times) {
		StringBuilder sb = new StringBuilder();
		while (times-- > 0) {
			sb.append(str);
		}
		return sb;
	}
}