/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/powx-n
@Language: Java
@Datetime: 17-05-25 20:19
*/

public class Solution {
    /**
     * @param x the base number
     * @param n the power number
     * @return the result
     */
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        if (n == 0 || x == 1) {
            return 1;
        }
        
        if (n < 1) {
            x = 1 / x;
            n = -n;
        }
        double result = x;
        for (int i = 1; i < n; ++i) {
            result *= x;
        }
        return result;
    }
}