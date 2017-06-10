/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/valid-parentheses
@Language: Java
@Datetime: 17-06-10 01:39
*/

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
		Stack<Character> stack = new Stack<>();
		
		for (char c: s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else {
			    if (stack.isEmpty()) {
			        return false;
			    }
				char c2 = stack.pop();
				if (c == ')' && c2 == '(') {
					continue;
				}
				if (c == ']' && c2 == '[') {
					continue;
				}				
				if (c == '}' && c2 == '{') {
					continue;
				}
				return false;
			}
		}
		return stack.isEmpty();
	}
}