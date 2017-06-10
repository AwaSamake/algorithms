/**
 *
 *  013. Roman to Integer
 *    Given a roman numeral, convert it to an integer.
 *    
 *    Input is guaranteed to be within the range from 1 to 3999.
 *
 */
import java.util.*;

public class Solution {
	private static final char[] roman = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	private static final int[] value = new int[] {1, 5, 10, 50, 100, 500, 1000};
	
	public int romanToInt(String s) {
		int num = 0;
		if (s.length() == 0) {
			return num;
		}
		HashMap<Character, Integer> romanToNum = new HashMap<>();
		
		for (int i = 0; i < 7; ++i) {
			romanToNum.put(roman[i], value[i]);
		}
		
		int pre = Integer.MAX_VALUE;
		for (char c: s.toCharArray()) {
			int value = romanToNum.get(c);
			if (pre < value) {
				num += (value - pre * 2);
			} else {
				num += value;
			}
			pre = value;
		}
		return num;
	}
}