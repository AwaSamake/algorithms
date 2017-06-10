/**
 *
 * 168. Excel Sheet Column Title 
 *     Given a positive integer, return its corresponding column title as appear in an 
 *     Excel sheet.
 *     
 *     For example:
 *     
 *         1 -> A
 *         2 -> B
 *         3 -> C
 *         ...
 *         26 -> Z
 *         27 -> AA
 *         28 -> AB 
 *
 */
import java.util.*;

public class Solution {
	public String convertToTitle(int n) {
		Stack<Integer> values = new Stack<Integer>();
		while (n > 25) {
			int val = n % 26;
			n = n / 26;
			values.push(val);
		}
		values.push(n);
		
		StringBuilder sb = new StringBuilder();
		
		while (!values.isEmpty()) {
			sb.append((char)(values.pop() + (int)'A') - 1);
		}
		
		return sb.toString();
	}
}