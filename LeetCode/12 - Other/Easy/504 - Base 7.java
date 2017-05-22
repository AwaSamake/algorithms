/**
 *
 *  504. Base 7
 *    Given an integer, return its base 7 string representation.
 *    
 *    Example 1:
 *    Input: 100
 *    Output: "202"
 *    Example 2:
 *    Input: -7
 *    Output: "-10"
 *
 */
import java.util.*;

class Solution {
	public String convertToBase7(int num) {
		if (num == 0) {
			return "0";
		}
		Stack<Character> stack = new Stack<>();
		boolean negative = false;
		if (num < 0) {
			num = -num;
			negative = true;
		}
		while (num != 0) {
			int remainder = num % 7;
			stack.push((char)('0' + remainder));
			num /= 7;
		}
		StringBuilder sb = new StringBuilder();
		if (negative) {
			sb.append('-');
		}
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}
}

class test {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.convertToBase7(-100));

	}
}




















