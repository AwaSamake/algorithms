/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/a-b-problem
@Language: Java
@Datetime: 17-06-08 03:29
*/

class Solution {
    /*
     * param a: The first integer
     * param b: The second integer
     * return: The sum of a and b
     */
    public int aplusb(int a, int b) {
        int carry = (a & b) << 1;
        int sum = a ^ b;
        while (carry != 0) {
            int temp = carry;
            carry = sum & temp;
            sum = sum ^ temp;
            carry <<= 1;
        }
        return sum;
    }
};