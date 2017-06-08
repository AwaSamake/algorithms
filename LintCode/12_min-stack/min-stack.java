/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/min-stack
@Language: Java
@Datetime: 17-06-08 03:49
*/

public class MinStack {
	Stack<Integer> stack;
	Stack<Integer> min;
	
	public MinStack() {
		stack = new Stack<Integer>();
		min = new Stack<Integer>();
	}

	public void push(int number) {
		stack.push(number);
		if (min.isEmpty() || number <= min.peek()) {
			min.push(number);
		}
	}

	public int pop() {
		// CANNOT USE == HERE!!!
		// Integer == Integer will comparing address of them
		if (stack.peek().equals(min.peek())) {
			min.pop();
		}
		return stack.pop();
	}

	public int min() {
		return min.peek();
	}
}