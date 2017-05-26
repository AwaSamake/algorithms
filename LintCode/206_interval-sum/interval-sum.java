/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/interval-sum
@Language: Java
@Datetime: 17-05-26 05:16
*/

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        
        ArrayList<Long> result = new ArrayList<Long>();
        long[] sum = new long[A.length];
        if (A.length < 1 || queries.size() < 1) {
            return result;
        }
        
        sum[0] = A[0];
        for (int i = 1; i < A.length; ++i) {
            sum[i] = sum[i - 1] + A[i];
        }
        for (Interval query : queries) {
            if (query.start == 0) {
                result.add(sum[query.end]);
            } else {
                result.add(sum[query.end] - sum[query.start - 1]);
            }
        }
        return result;
    }
}
