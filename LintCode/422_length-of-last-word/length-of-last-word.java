/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/length-of-last-word
@Language: Java
@Datetime: 17-06-09 20:38
*/

public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        int length = 0;
        int lastWord = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (length != 0) {
                    lastWord = length;
                    length = 0;
                }
            } else {
                length++;
            }
        }
        return length == 0 ? lastWord : length;
    }
}