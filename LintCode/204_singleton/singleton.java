/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/singleton
@Language: Java
@Datetime: 17-06-10 23:55
*/

class Solution {
    private static Solution solution;
    /**
     * @return: The same instance of this class every time
     */
    public static Solution getInstance() {
        if (solution == null) {
            solution = new Solution();
        }
        return solution;
    }
};