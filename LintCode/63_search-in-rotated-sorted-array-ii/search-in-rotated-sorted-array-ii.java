/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 17-05-29 22:06
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        return search(A, target, 0, A.length - 1);
    }
    
    public boolean search(int[] A, int target, int begin, int end) {
        if (begin > end) {
            return false;
        }
        
        int mid = (begin + end) >> 1;
        if (A[mid] == target) {
            return true;
        }
        
        if (A[begin] == A[end]) {
            return search(A, target, begin, mid - 1) || search(A, target, mid + 1, end);
        }
        
        // right side is normal
        if (A[mid] < A[end]) {
            if (A[mid] < target && target <= A[end]) {
                return search(A, target, mid + 1, end);
            } else {
                return search(A, target, begin, mid - 1);
            }
        } else { // left side is nomal
            if (A[begin] <= target && target < A[mid]) {
                return search(A, target, begin, mid - 1);
            } else {
                return search(A, target, mid + 1, end);
            }
        }
    }
}
