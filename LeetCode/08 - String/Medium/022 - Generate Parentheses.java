/**
 *
 * 022. Generate Parentheses
 *     Given n pairs of parentheses, write a function to generate all combinations of 
 *     well-formed parentheses.
 *     
 *     For example, given n = 3, a solution set is:
 *     
 *     [
 *       "((()))",
 *       "(()())",
 *       "(())()",
 *       "()(())",
 *       "()()()"
 *     ]
 *     
 *
 */
import java.util.*;

public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> combinations = new ArrayList<String>();
		StringBuilder parentheses = new StringBuilder(n * 2);
		generateParenthesis(combinations, n, parentheses, 0, 0);
		return combinations;
	}
	
	public void generateParenthesis(List<String> combinations, int n, StringBuilder parentheses, int opened, int closed) {
		if (opened == n && closed == n) {
			combinations.add(parentheses.toString());
		} else if (opened == n) {
			parentheses.append(')');
			generateParenthesis(combinations, n, parentheses, opened, closed + 1);
		} else if (opened <= closed) {
			parentheses.append('(');
			generateParenthesis(combinations, n, parentheses, opened + 1, closed);
		} else {
			StringBuilder parentheses2 = new StringBuilder(n * 2);
			parentheses2.append(parentheses);
			parentheses.append('(');
			parentheses2.append(')');
			
			generateParenthesis(combinations, n, parentheses, opened + 1, closed);
			generateParenthesis(combinations, n, parentheses2, opened, closed + 1);
		}
	}
}