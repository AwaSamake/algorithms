/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/reverse-pairs
@Language: Java
@Datetime: 17-06-11 05:50
*/

public class Solution {
    /**
     * @param A an array
     * @return total of reverse pairs
     */
    public long reversePairs(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = i + 1; j < A.length; ++j) {
                count += A[j] < A[i] ? 1 : 0;
            }
        }
        return count;
    }
}