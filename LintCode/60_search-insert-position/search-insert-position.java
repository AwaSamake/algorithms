/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/search-insert-position
@Language: Java
@Datetime: 17-06-01 20:01
*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        int lower = 0, upper = A.length - 1;
        while (lower <= upper) {
            int mid = (lower + upper) >> 1;
            if (A[mid] < target) {
                lower = mid + 1;
            } else {
                upper = mid - 1;
            }
        }
        return lower;
    }
}
