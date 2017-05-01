/**
 *
 *  415. Add Strings
 *    Given two non-negative integers num1 and num2 represented as string, return the sum 
 *    of num1 and num2.
 *    
 *    Note:
 *    
 *    The length of both num1 and num2 is < 5100.
 *    Both num1 and num2 contains only digits 0-9.
 *    Both num1 and num2 does not contain any leading zero.
 *    You must not use any built-in BigInteger library or convert the inputs to integer 
 *    directly.
 *
 */
import java.util.*;

public class Solution {
	public String addStrings(String num1, String num2) {
		if (num1.length() == 0 || num1.equals("0")) {
			return num2;
		} else if (num2.length() == 0 || num2.equals("0")) {
			return num1;
		}
		
		int index1 = num1.length() - 1;
		int index2 = num2.length() - 1;
		int index3 = Math.max(index1, index2) + 1;
		int carry = 0;
		int sum = 0;
		char[] result = new char[index3 + 1];
		
		while (index1 >= 0 || index2 >= 0 || carry != 0) {
			sum = carry;
			if (index1 >= 0) {
				char c1 = num1.charAt(index1);
				sum += (int)(c1 - '0');
			}
			if (index2 >= 0) {
				char c2 = num2.charAt(index2);
				sum += (int)(c2 - '0');
			}
			carry = sum / 10;
			sum %= 10;
			result[index3] = (char)(sum + '0');
			index1--;
			index2--;
			index3--;
		}
		return !Character.isDigit(result[0]) ? new String(result, 1, result.length - 1) : new String(result);
	}
}