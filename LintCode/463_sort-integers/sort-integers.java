/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/sort-integers
@Language: Java
@Datetime: 17-05-29 20:22
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers(int[] A) {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 1; i < A.length; ++i) {
                if (A[i] < A[i - 1]) {
                    int temp = A[i];
                    A[i] = A[i - 1];
                    A[i - 1] = temp;
                    swap = true;
                }
            }
        }
    }
}