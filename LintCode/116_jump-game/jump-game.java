/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/jump-game
@Language: Java
@Datetime: 17-06-09 23:42
*/

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        int step = 0;
        for (int i = A.length - 1; i > -1; --i) {
            if (A[i] >= step) {
                step = 0;
            }
            step++;
        }
        return step < 2;
    }
}
