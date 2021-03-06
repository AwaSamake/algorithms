/**
 *
 * 058. Length of Last Word
 *     Given a string s consists of upper/lower-case alphabets and empty space characters 
 *     ' ', return the length of last word in the string. 
 *     If the last word does not exist, return 0. 
 *     Note: A word is defined as a character sequence consists of non-space characters 
 *     only. 
 *     For example, 
 *     Given s = "Hello World", return 5.
 * 
 */
import java.util.*;

public class Solution {
	public int lengthOfLastWord(String s) {
		int end = s.length() - 1;
		while (end >= 0 && s.charAt(end) == ' ') {
			--end;
		}
		if (end < 0) {
			return 0;
		}
		int i = end;
		while (i >= 0) {
			if (s.charAt(i) == ' ') {
				return end - i;
			}
			--i;
		}
		return end - i;
	}
}