/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Java
@Datetime: 17-06-08 05:14
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
		int index = m-- + n-- - 1;
		while (index > -1) {
			if (m > -1 && n > -1) {
				if (A[m] > B[n]) {
					A[index--] = A[m--];
				} else {
					A[index--] = B[n--];
				}
			} else {
				A[index--] = m > -1 ? A[m--] : B[n--];
			}
		}
	}
}