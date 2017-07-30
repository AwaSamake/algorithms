import java.util.*;

class Solution {
	public List<String> generateParenthesis(int n) {
		ArrayList<String> combinations = new ArrayList<String>();
		generateParenthesis(n, combinations, new LinkedList<Character>(), 0, 0);
		return combinations;
	}
	
	public void generateParenthesis(int n, List<String> combinations, LinkedList<Character> chars, int open, int close) {
		if (open > n || close > n || close > open) {
			return;
		}

		if (open == n && close == n) {
			StringBuilder sb = new StringBuilder(chars.size());
			for (char c : chars) {
				sb.append(c);
			}
			combinations.add(sb.toString());
			return;
		}
		chars.addLast('(');
		generateParenthesis(n, combinations, chars, open + 1, close);
		chars.removeLast();
		
		chars.addLast(')');
		generateParenthesis(n, combinations, chars, open, close + 1);
		chars.removeLast();
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.generateParenthesis(1));
	}
}