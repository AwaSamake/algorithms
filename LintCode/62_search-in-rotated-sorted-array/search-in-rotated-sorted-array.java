/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Java
@Datetime: 17-06-02 04:18
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        int lower = 0;
        int upper = A.length - 1;
        
        while (lower <= upper) {
            int mid = (lower + upper) >> 1;
            if (target == A[mid]) {
                return mid;
            }
            if (A[mid] < A[upper]) {
                // right side is normal
                if (A[mid] < target && target <= A[upper]) {
                    lower = mid + 1;
                } else {
                    upper = mid - 1;
                }
            } else {
                // left side is normal
                if (A[lower] <= target && target < A[mid]) {
                    upper = mid - 1;
                } else {
                    lower = mid + 1;
                }
            }
        }
        return -1;
    }
}
