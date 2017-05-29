/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/the-smallest-difference
@Language: Java
@Datetime: 17-05-29 02:33
*/

public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        if (A == null || B == null || A.length < 1 || B.length < 1) {
            return -1;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        int min = Math.abs(A[0] - B[0]);
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            min = Math.min(Math.abs(A[i] - B[j]), min);
            if (A[i] < B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return min;
    }
}
