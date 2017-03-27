/**
 *
 * 020. Valid Parentheses
 *     Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 *     determine if the input string is valid. The brackets must close in the correct 
 *     order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 */
import java.util.*;

public class Solution {
	public boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<Character>();
		HashMap<Character, Character> pair = new HashMap<Character, Character>();
		pair.put(')', '(');
		pair.put('}', '{');
		pair.put(']', '[');
		
		for (char c: s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.addLast(c);
			} else if (!stack.isEmpty()) {
				char removed = stack.removeLast();
				if (removed != pair.get(c)) {
					return false;
				}
			} else {
				return false;
			}
		}
		return stack.isEmpty();
	}
}