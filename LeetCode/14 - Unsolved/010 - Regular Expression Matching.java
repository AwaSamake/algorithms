/**
 *
 * 010. Regular Expression Matching
 *    Implement regular expression matching with support for '.' and '*'.
 *    
 *    '.' Matches any single character.
 *    '*' Matches zero or more of the preceding element.
 *    
 *    The matching should cover the entire input string (not partial).
 *    
 *    The function prototype should be:
 *    bool isMatch(const char *s, const char *p)
 *    
 *    Some examples:
 *    isMatch("aa","a") → false
 *    isMatch("aa","aa") → true
 *    isMatch("aaa","aa") → false
 *    isMatch("aa", "a*") → true
 *    isMatch("aa", ".*") → true
 *    isMatch("ab", ".*") → true
 *    isMatch("aab", "c*a*b") → true
 *
 */
import java.util.*;

class Solution {
	public boolean isMatch(String s, String p) {
		System.out.println("matching:" + s + " - " + p);
		if (s.equals(p)) {
			return true;
		}
		int index = 0;
		int sIndex = 0, pIndex = 0;
		while (index < p.length() && pIndex < p.length()) {
			char c = p.charAt(pIndex);
			if (c == '.') {
				sIndex++;
				pIndex++;
			} else if (c == '*') {
				pIndex++;
				for (int i = sIndex; i <= s.length(); ++i) {
					if (isMatch(s.substring(i, s.length()), p.substring(pIndex, p.length())) && pIndex == p.length() - 1) {
						return true;
					}
				}
				sIndex = 0;
				pIndex = ++index;
			} else if (sIndex >= s.length() || c != s.charAt(sIndex)) {
				sIndex = 0;
				pIndex = ++index;
			} else {
				sIndex++;
				pIndex++;
			}
		}
		System.out.println("return:" + sIndex + " = " + s.length() + " && " + pIndex + " = " + p.length());
		return sIndex == s.length() && pIndex == p.length();
	}
}



class test {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isMatch("aabc", "c*a*b"));

	}
}












































