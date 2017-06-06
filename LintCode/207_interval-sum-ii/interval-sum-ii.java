/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/interval-sum-ii
@Language: Java
@Datetime: 17-06-05 21:54
*/

public class Solution {
    /* you may need to use some attributes here */
	long[] sum;
	int[] dup;
	/**
	 * @param A: An integer array
	 */
	public Solution(int[] A) {
		int n = A.length;
		sum = new long[n];
		dup = new int[n];
		if (n < 1) {
			return;
		}
		sum[0] = A[0];
		dup[0] = A[0];
		for (int i = 1; i  < n; ++i) {
			sum[i] = sum[i - 1] + A[i];
			dup[i] = A[i];
		}
	}
	
	/**
	 * @param start, end: Indices
	 * @return: The sum from start to end
	 */
	public long query(int start, int end) {
		if (start == 0) {
			return sum[end];
		} else {
			return sum[end] - sum[start - 1];
		}
	}
	
	/**
	 * @param index, value: modify A[index] to value.
	 */
	public void modify(int index, int value) {
		if (index < 0 || index > dup.length) {
			return;
		}
		int diff = value - dup[index];
		dup[index] = value;
		for (int i = index; i < dup.length; ++i) {
			sum[i] += diff;
		}
	}
}
