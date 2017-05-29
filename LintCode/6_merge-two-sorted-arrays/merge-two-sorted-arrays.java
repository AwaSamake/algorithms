/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 17-05-29 23:08
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] merged = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;
        while (k < merged.length) {
            int a = i < A.length ? A[i] : Integer.MAX_VALUE;
            int b = j < B.length ? B[j] : Integer.MAX_VALUE;
            merged[k++] = a < b ? A[i++] : B[j++];
        }
        return merged;
    }
}