/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/reverse-integer
@Language: Java
@Datetime: 17-06-09 21:16
*/

public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        int reversed = 0;
        while (n != 0) {
            int temp = reversed;
            reversed = reversed * 10 + n % 10;
            if (reversed / 10 != temp) {
                return 0;
            }
            n /= 10;
        }
        return reversed;
    }
}