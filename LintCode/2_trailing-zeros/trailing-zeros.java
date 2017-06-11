/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/trailing-zeros
@Language: Java
@Datetime: 17-06-11 06:16
*/

class Solution {
    /*
     * param n: An desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
		long count = 0;
		while (n != 0) {
			count += n / 5;
			n /= 5;
		}
		return count;
	}
};
