/**
 *
 * 067. Add Binary
 *     Given two binary strings, return their sum (also a binary string).
 *     For example,
 *         a = "11"
 *         b = "1"
 *         Return "100".
 * 
 */
import java.util.*;

public class Solution {
	public String addBinary(String a, String b) {
		if (a.equals("") || b.equals("")) {
			return a + b;
		}
		int aIndex = a.length() - 1;
		int bIndex = b.length() - 1;
		int val = 0;
		ArrayList<Character> result = new ArrayList<Character>();
		while (aIndex >= 0 || bIndex >= 0 || val != 0) {
			if (aIndex >= 0 && a.charAt(aIndex) == '1') {
				val++;
			}
			if (bIndex >= 0 && b.charAt(bIndex) == '1') {
				val++;
			}
			
			if (val % 2 == 0) {
				result.add('0');
			} else if (val % 2 == 1) {
				result.add('1');
			}
			
			val /= 2;
			aIndex--;
			bIndex--;
		}
		
		StringBuilder str = new StringBuilder(result.size());
		for (int i = result.size() - 1; i > -1; --i) {
			str.append(result.get(i));
		}
		int index = Math.max(str.indexOf("1"), 0);
		return str.substring(index).toString();
	}
}