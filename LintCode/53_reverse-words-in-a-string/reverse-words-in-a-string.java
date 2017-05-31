/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/reverse-words-in-a-string
@Language: Java
@Datetime: 17-05-30 22:40
*/

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        if (words.length < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > -1; --i) {
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1).toString();
    }
}
