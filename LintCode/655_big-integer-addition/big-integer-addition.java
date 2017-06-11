/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/big-integer-addition
@Language: Java
@Datetime: 17-06-10 23:04
*/

public class Solution {
    /**
     * @param num1 a non-negative integers
     * @param num2 a non-negative integers
     * @return return sum of num1 and num2
     */
    public String addStrings(String num1, String num2) {
		int[] a = convert(num1);
		int[] b = convert(num2);
		int[] sum = new int[Math.max(a.length, b.length) + 1];
		int carry = 0;
		int index = sum.length - 1;
		int i = 0;
		int j = 0;
		while (index >= 0) {
			if (i < a.length) {
				carry += a[i++];
			}
			if (j < b.length) {
				carry += b[j++];
			}
			sum[index--] = carry % 10;
			carry /= 10;
		}
		StringBuilder sb = new StringBuilder(sum.length);
		for (i = (sum[0] == 0? 1 : 0); i < sum.length; ++i) {
			sb.append(sum[i]);
		}
		return sb.toString();
	}
	
	private int[] convert(String num) {
		char[] digits = num.toCharArray();
		int[] number = new int[digits.length];
		int index = number.length - 1;
		for (char digit : digits) {
			number[index--] = digit - '0';
		}
		return number;
	}
}