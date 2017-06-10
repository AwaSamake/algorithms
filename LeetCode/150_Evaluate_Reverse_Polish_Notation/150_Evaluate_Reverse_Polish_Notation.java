/**
 *
 * 150. Evaluate Reverse Polish Notation
 *     Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *     
 *     Valid operators are +, -, *, /. Each operand may be an integer or another 
 *     expression.
 *     
 *     Some examples:
 *       ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *       ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */
import java.util.*;

public class Solution {
	public int evalRPN(String[] tokens) {
		Stack<Integer> operands = new Stack<Integer>();
		for (String token : tokens) {
			if (token.equals("+")) {
				int op1 = operands.pop();
				int op2 = operands.pop();
				operands.push(op2 + op1);
			} else if (token.equals("-")) {
				int op1 = operands.pop();
				int op2 = operands.pop();
				operands.push(op2 - op1);
			} else if (token.equals("*")) {
				int op1 = operands.pop();
				int op2 = operands.pop();
				operands.push(op2 * op1);
			} else if (token.equals("/")) {
				int op1 = operands.pop();
				int op2 = operands.pop();
				operands.push(op2 / op1);
			} else {
				operands.push(Integer.valueOf(token));
			}
		}
		return operands.pop();
	}
}