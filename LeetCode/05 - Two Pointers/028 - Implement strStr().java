/**
 *
 * 28. Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is 
 * not part of haystack.
 *
 */
import java.util.*;

public class Solution {
	public int strStr(String haystack, String needle) {
		if (haystack.equals(needle) || needle.equals("")) {
			return 0;
		} else if (haystack.length() < needle.length()) {
			return -1;
		}		
		for (int i = 0; i <= haystack.length() - needle.length(); ++i) {
			if (haystack.substring(i, i + needle.length()).equals(needle)) {
				return i;
			}
		}
		return -1;
	}
}