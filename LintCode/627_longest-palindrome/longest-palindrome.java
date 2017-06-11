/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/longest-palindrome
@Language: Java
@Datetime: 17-06-10 22:26
*/

public class Solution {
    /**
     * @param s a string which consists of lowercase or uppercase letters
     * @return the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
		boolean odd = false;
		int[] counts = new int[256];
		for (char c : s.toCharArray()) {
			counts[c]++;
		}
		int sum = 0;
		for (int count : counts) {
			if ((count & 1) == 1) {
				odd = true;
			}
			sum += (count >> 1) << 1;
		}
		return odd ? sum + 1 : sum;
	}
}