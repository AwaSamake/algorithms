/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/fibonacci
@Language: Java
@Datetime: 17-06-09 21:04
*/

class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    public int fibonacci(int n) {
        if (n <= 1) {
            return 0;
        }
        if (n <= 3) {
            return 1;
        }
        int num1 = 1;
        int num2 = 1;
        int num3 = 0;
        for (int i = 3; i < n; ++i) {
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }
}

