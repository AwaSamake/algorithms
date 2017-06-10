/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/house-robber
@Language: Java
@Datetime: 17-06-09 21:13
*/

public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        if (A.length < 1) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        long[] max = new long[A.length];
        max[0] = A[0];
        max[1] = Math.max(A[1], A[0]);
        for (int i = 2; i < A.length; ++i) {
            max[i] = Math.max(max[i - 1], max[i - 2] + A[i]);
        }
        return max[max.length - 1];
    }
}