/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/rotate-string
@Language: Java
@Datetime: 17-06-04 22:40
*/

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
		if (str.length < 2) {
			return;
		}
		offset %= str.length;
		if (offset == 0) {
			return;
		}
		reverse(str, 0, str.length - 1);
		reverse(str, 0, offset - 1);
		reverse(str, offset, str.length - 1);
	}
	
	public void reverse(char[] str, int begin, int end) {
		while (begin < end) {
			char temp = str[begin];
			str[begin] = str[end];
			str[end] = temp;
			begin++;
			end--;
		}
	}
}