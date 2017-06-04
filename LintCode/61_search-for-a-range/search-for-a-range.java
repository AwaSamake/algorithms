/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Java
@Datetime: 17-06-04 03:57
*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
	public int[] searchRange(int[] A, int target) {
		int lower = 0;
		int upper = A.length - 1;
		if (upper < 0) {
			return new int[] {-1,-1};
		}
		while (lower <= upper) {
			int mid = (lower + upper) >> 1;
			if (target <= A[mid]) {
				upper = mid - 1;
			} else {
				lower = mid + 1;
			}
		}
		if (lower >= A.length || A[lower] != target) {
			return new int[] {-1, -1};
		}
		int[] range = new int[] {lower, lower};
		lower = 0;
		upper = A.length - 1;
		while (lower <= upper) {
			int mid = (lower + upper) >> 1;
			if (target < A[mid]) {
				upper = mid - 1;
			} else {
				lower = mid + 1;
			}
		}
		range[1] = upper;
		return range;
	}
}
