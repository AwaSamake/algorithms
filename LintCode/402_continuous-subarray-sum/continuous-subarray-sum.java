/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/continuous-subarray-sum
@Language: Java
@Datetime: 17-06-01 20:23
*/

public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (A.length < 1) {
            result.add(0);
            result.add(0);
            return result;
        }
        int maxBegin = 0;
        int maxEnd = 0;
        int max = A[0];
        int begin = 0;
        int end = 0;
        int sum = A[0];
        for (int i = 0; i < A.length; ++i) {
            if (sum + A[i] > 0) {
                end = i;
                sum += A[i];
                if (sum > max) {
                    max = sum;
                    maxBegin = begin;
                    maxEnd = end;
                }
            } else {
                if (A[i] > max) {
                    maxBegin = i;
                    maxEnd = i;
                    max = A[i];
                }
                sum = 0;
                begin = i+1;
            }
        }
        result.add(maxBegin);
        result.add(maxEnd);
        return result;
    }
}