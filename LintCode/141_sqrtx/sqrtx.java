/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/sqrtx
@Language: Java
@Datetime: 17-06-09 23:03
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
		if (x == 0 || x == 1) {
			return x;
		}
		int lower = 0;
		int upper = x;
		while (lower <= upper) {
			int mid = (lower + upper) >> 1;
			if (x / mid < mid) {
				upper = mid - 1;
			} else {
				if (x / (mid + 1) <= mid) {
					return mid;
				}
				lower = mid + 1;
			}
		}
		return lower;
	}
}