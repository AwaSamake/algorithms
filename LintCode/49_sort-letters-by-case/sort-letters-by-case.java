/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/sort-letters-by-case
@Language: Java
@Datetime: 17-05-28 00:06
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        int lower = 0, upper = chars.length - 1;
        while (lower < upper) {
            while (lower < chars.length && chars[lower] >= 'a') {
                lower++;
            }
            while (upper > -1 && chars[upper] <= 'Z') {
                upper--;
            }
            if (lower >= upper) {
                return;
            }
            char temp = chars[lower];
            chars[lower] = chars[upper];
            chars[upper] = temp;
        }
    }
}
