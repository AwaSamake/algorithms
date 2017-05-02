/**
 *
 *  171. Excel Sheet Column Number
 *    Related to question Excel Sheet Column Title
 *    
 *    Given a column title as appear in an Excel sheet, return its corresponding column 
 *    number.
 *    
 *    For example:
 *    
 *        A -> 1
 *        B -> 2
 *        C -> 3
 *        ...
 *        Z -> 26
 *        AA -> 27
 *        AB -> 28 
 *
 */
import java.util.*;

public class Solution {
	public int titleToNumber(String s) {
		int index = 0;
		for (char c: s.toCharArray()) {
			index *= 26;
			index += (int)((c - 'A') + 1);
		}
		return index;
	}
}