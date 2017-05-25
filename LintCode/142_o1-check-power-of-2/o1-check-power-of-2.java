/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/o1-check-power-of-2
@Language: Java
@Datetime: 17-05-25 00:45
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
};