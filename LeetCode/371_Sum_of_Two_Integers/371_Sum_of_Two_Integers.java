/**
 *
 *  371. Sum of Two Integers
 *    Calculate the sum of two integers a and b, but you are not allowed to use the 
 *    operator + and -.
 *    
 *    Example:
 *    Given a = 1 and b = 2, return 3.
 *
 */
import java.util.*;

class Solution {
	public int getSum(int a, int b) {
		int sum = a ^ b;
		int carry = a & b;
		
		while (carry != 0) {
			carry <<= 1;
			int temp = sum;
			sum ^= carry;
			carry &= temp;
		}
		return sum;
	}
}