/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/climbing-stairs
@Language: Java
@Datetime: 17-06-10 00:26
*/

public class Solution {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n < 1) {
            return 1;
        }
        if (n < 2) {
            return n;
        }
        int preprev = 1;
        int prev = 2;
        for (int i = 2; i < n; ++i) {
            int current = prev + preprev;
            preprev = prev;
            prev = current;
        }
        return prev;
    }
}