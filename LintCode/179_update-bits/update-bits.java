/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/update-bits
@Language: Java
@Datetime: 17-06-06 22:46
*/

class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
		long mask = ((long)1 << (j + 1)) - 1;
		long mask2 = (1 << i) - 1;
		mask = mask ^ mask2;
		n &= ~mask;
		n |= (m << i);
		return n;
	}
	
}
