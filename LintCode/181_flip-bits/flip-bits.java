/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/flip-bits
@Language: Java
@Datetime: 17-05-24 21:37
*/

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int diff = a ^ b;
        int count = 0;
        for (int i = 0; i < 32 && diff != 0; ++i) {
            count += diff & 1;
            diff >>= 1;
        }
        return count;
    }
};
