/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/single-number
@Language: Java
@Datetime: 17-06-03 19:18
*/

public class Solution {
    /**
      *@param A : an integer array
      *return : a integer 
      */
    public int singleNumber(int[] A) {
        int temp = 0;
        for (int a : A) {
            temp ^= a;
        }
        return temp;
    }
}