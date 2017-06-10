/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/count-and-say
@Language: Java
@Datetime: 17-06-09 20:56
*/

public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		for (int i = 1; i < n; ++i) {
			StringBuilder str = sb;
			sb = new StringBuilder();
			int index = 0;
			while (index < str.length()) {
				char c = str.charAt(index);
				int nextIndex = firstNot(str, index);
				sb.append(nextIndex - index);
				sb.append(c);
				index = nextIndex;
			}
		}
		return sb.toString();
	}
	
	private int firstNot(StringBuilder str, int index) {
		while (index + 1 < str.length() && str.charAt(index) == str.charAt(index + 1)) {
			index++;
		}
		return index + 1;
	}
}