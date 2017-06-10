/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/add-binary
@Language: Java
@Datetime: 17-06-09 21:35
*/

public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
		boolean carry = false;
		int i = a.length();
		int j = b.length();
		int k = Math.max(i--, j--);
		char[] result = new char[k + 1];
		while (k > 0) {
			int val = 0;
			val += (i >= 0 && a.charAt(i) == '1') ? 1 : 0;
			val += (j >= 0 && b.charAt(j) == '1') ? 1 : 0;
			val += carry ? 1 : 0;
			carry = val > 1;
			result[k] = (val == 1 || val == 3) ? '1' : '0';
			i--;
			j--;
			k--;
		}
		if (carry) {
			result[k] = '1';
			return new String(result);
		} else {
			return new String(result, 1, result.length - 1);
		}
	}
}