/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/plus-one
@Language: Java
@Datetime: 17-06-04 05:37
*/

public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > -1; --i) {
            if (digits[i] != 9) {
                digits[i] += 1;
                for (int j = i + 1; j < digits.length; ++j) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}