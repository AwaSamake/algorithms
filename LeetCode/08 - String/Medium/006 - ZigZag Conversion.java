/**
 *
 * 006. ZigZag Conversion
 *     The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of 
 *     rows like this: (you may want to display this pattern in a fixed font for better 
 *     legibility)
 *     
 *     P   A   H   N
 *     A P L S I I G
 *     Y   I   R
 *     And then read line by line: "PAHNAPLSIIGYIR"
 *     Write the code that will take a string and make this conversion given a number of 
 *     rows:
 *     
 *     string convert(string text, int nRows);
 *     convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *     
 *
 */
import java.util.*;

public class Solution {
	public String convert(String s, int numRows) {
		if (s.length() < 1 || numRows < 1) {
			return "";
		} else if (numRows == 1) {
		    return s;
		}
		
		StringBuilder[] strings = new StringBuilder[numRows];
		int incrementOrDecrement = 1;
		int index = 0;
		for (char c : s.toCharArray()) {
			if (strings[index] == null) {
				strings[index] = new StringBuilder();
			}
			strings[index].append(c);
			if (index + incrementOrDecrement >= numRows || index + incrementOrDecrement < 0) {
				incrementOrDecrement = -incrementOrDecrement;
			}
			index += incrementOrDecrement;
		}
		for (int i = 1; i < strings.length && strings[i] != null; ++i) {
			strings[0].append(strings[i].toString());
		}
		return strings[0].toString();
	}
}