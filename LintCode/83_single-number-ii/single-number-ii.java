/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/single-number-ii
@Language: Java
@Datetime: 17-06-09 00:20
*/

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
		int one = 0;
		int two = 0;
		for (int a : A) {
			one = (one ^ a) & ~two;
			two = (two ^ a) & ~one;
		}
		return one;
	}
}