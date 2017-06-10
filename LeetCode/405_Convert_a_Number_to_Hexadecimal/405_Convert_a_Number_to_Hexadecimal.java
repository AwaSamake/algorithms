/**
 *
 *  405. Convert a Number to Hexadecimal
 *    Given an integer, write an algorithm to convert it to hexadecimal. For negative 
 *    integer, two’s complement method is used.
 *    
 *    Note:
 *    
 *    All letters in hexadecimal (a-f) must be in lowercase.
 *    The hexadecimal string must not contain extra leading 0s. If the number is zero, 
 *    it is represented by a single zero character '0'; otherwise, the first character 
 *    in the hexadecimal string will not be the zero character.
 *    The given number is guaranteed to fit within the range of a 32-bit signed integer.
 *    You must not use any method provided by the library which converts/formats the 
 *    number to hex directly.
 *    Example 1:
 *    
 *    Input:
 *    26
 *    
 *    Output:
 *    "1a"
 *    Example 2:
 *    
 *    Input:
 *    -1
 *    
 *    Output:
 *    "ffffffff"
 *    
 */
import java.util.*;

public class Solution {
	public String toHex(int num) {
		if (num == 0) {
			return "0";
		}
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> chars = new Stack<Character>();
		while (num != 0) {
			int sum = 0;
			sum += num & 1;
			sum += num & 2;
			sum += num & 4;
			sum += num & 8;
			if (sum < 10) {
				chars.push((char)('0' + sum));
			} else {
				sum -= 10;
				chars.push((char)('a' + sum));
			}
			num >>>= 4;
		}
		while (!chars.isEmpty()) {
			sb.append(chars.pop());
		}
		return sb.toString();
	}
}