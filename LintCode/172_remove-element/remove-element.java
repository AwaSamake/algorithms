/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/remove-element
@Language: Java
@Datetime: 17-06-04 00:01
*/

public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        int i = 0;
        for (int j = 0; j < A.length; ++j) {
            if (A[j] != elem) {
                A[i++] = A[j];
            }
        }
        return i;
    }
}
