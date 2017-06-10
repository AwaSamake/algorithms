/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/longest-words
@Language: Java
@Datetime: 17-06-10 01:23
*/

class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        ArrayList<String> list = new ArrayList<String>();
        int longest = 0;
        for (String str : dictionary) {
            int length = str.length();
            if (length > longest) {
                longest = length;
                list.clear();
            }
            if (length == longest) {
                list.add(str);
            }
        }
        return list;
    }
};