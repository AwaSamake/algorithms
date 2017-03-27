/**
 *
 * 434. Number of Segments in a String
 *     Count the number of segments in a string, where a segment is defined to be a 
 *     contiguous sequence of non-space characters. 
 *     Please note that the string does not contain any non-printable characters. 
 *     Example: 
 *         Input: "Hello, my name is John"
 *         Output: 5
 * 
 */
import java.util.*;

public class Solution {
	public int countSegments(String s) {
		int count = 0;
		int index = nextNotSpace(s, 0);
		while (index != -1) {
			count++;
			index = nextSpace(s, index);
			if (index == -1) {
				return count;
			}
			index = nextNotSpace(s, index);
		}
		return count;
	}
	
	public int nextSpace(String s, int index) {
		while (index < s.length() && s.charAt(index) != ' ') {
			++index;
		}
		if (index >= s.length()) {
			return -1;
		}
		return index;
	}
	
	public int nextNotSpace(String s, int index) {
		while (index < s.length() && s.charAt(index) == ' ') {
			++index;
		}
		if (index >= s.length()) {
			return -1;
		}
		return index;
	}
}