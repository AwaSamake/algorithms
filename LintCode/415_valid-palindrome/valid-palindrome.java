/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/valid-palindrome
@Language: Java
@Datetime: 17-06-04 20:58
*/

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			char c1 = s.charAt(i);
			while (i < j && !Character.isAlphabetic(c1) && !Character.isDigit(c1)) {
				c1 = s.charAt(++i);
			}
			char c2 = s.charAt(j);
			while (i < j && !Character.isAlphabetic(c2) && !Character.isDigit(c2)) {
				c2 = s.charAt(--j);
			}
			if (i < j && Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
				return false;
			}
			i++;
			j--;
		} 
		return true;
	}
}