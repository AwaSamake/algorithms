/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/longest-common-prefix
@Language: Java
@Datetime: 17-06-08 23:23
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: The longest common prefix
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) {
            return "";
        }
        Arrays.sort(strs);
        for (int i = 0; i < Math.min(strs[0].length(), strs[strs.length - 1].length()); ++i) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}