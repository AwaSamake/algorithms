/**
 *
 * 066 Plus One
 * Given a non-negative integer represented as a non-empty array of digits, plus one to 
 * the integer. You may assume the integer do not contain any leading zero, except the 
 * number 0 itself. The digits are stored such that the most significant digit is at the 
 * head of the list.
 * 
 *
 */ 

import java.util.*;

public class Solution {
	public int[] plusOne(int[] digits) {
		int index = digits.length - 1;
		int carry = 1;
		while (index >= 0 && carry != 0) {
			if (digits[index] == 9) {
				digits[index--] = 0;
			} else {
				digits[index] += carry;
				carry = 0;
			}
		}
		if (carry == 0) {
			return digits;
		}
		int result[] = new int[digits.length + 1];
		result[0] = 1;
		return result;
	}
}