/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/longest-increasing-continuous-subsequence
@Language: Java
@Datetime: 17-06-03 04:02
*/

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
	public int longestIncreasingContinuousSubsequence(int[] A) {
	    if (A.length < 1) {
	        return 0;
	    }
		int[] counts = new int[A.length];
		int max = 1;
		counts[0] = 1;
		for (int i = 1; i < A.length; ++i) {
			if (A[i] > A[i - 1]) {
				counts[i] = counts[i - 1] + 1;
				if (counts[i] > max) {
					max = counts[i];
				}
			} else {
				counts[i] = 1;
			}
		}
		for (int i = A.length - 2; i > -1; --i) {
			if (A[i] > A[i + 1]) {
				counts[i] = counts[i + 1] + 1;
				if (counts[i] > max) {
					max = counts[i];
				}
			} else {
				counts[i] = 1;
			}
		}
		return max;
	}
}