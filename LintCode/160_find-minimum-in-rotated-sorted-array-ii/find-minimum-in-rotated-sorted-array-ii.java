/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 17-05-29 22:30
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        return findMin(num, Integer.MAX_VALUE, 0, num.length - 1);
    }
    
    public int findMin(int[] num, int min, int begin, int end) {
        if (begin > end) {
            return min;
        }
        
        int mid = (begin + end) >> 1;
        min = Math.min(min, num[mid]);
        if (num[begin] == num[mid] && num[end] == num[mid]) {
            return Math.min(findMin(num, min, begin, mid - 1), findMin(num, min, mid + 1, end));
        }
        
        if (num[mid] <= num[end]) {
            return findMin(num, min, begin, mid - 1);
        } else {
            return findMin(num, min, mid + 1, end);
        }
    }

}