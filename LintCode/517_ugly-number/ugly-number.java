/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/ugly-number
@Language: Java
@Datetime: 17-06-10 22:00
*/

public class Solution {
    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    public boolean isUgly(int num) {
        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
                continue;
            } else if (num % 3 == 0) {
                num /= 3;
                continue;
            } else if (num % 5 == 0) {
                num /= 5;
                continue;
            } else {
                return false;
            }
        }
        return num == 1;
    }
}