/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/first-missing-positive
@Language: Java
@Datetime: 17-05-28 01:08
*/

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; ++i) {
            while (A[i] > 0 && A[i] < A.length && A[i] != i + 1) {
                int value = A[A[i] - 1];
                if (value == A[i]) {
                    break;
                }
                A[A[i] - 1] = A[i];
                A[i] = value;
            }
        }
        
        for (int i = 0; i < n; ++i) {
            if (A[i] != i+1) {
                return i+1;
            }
        }
        return n + 1;
    }
}