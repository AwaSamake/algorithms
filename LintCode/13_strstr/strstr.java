/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Java
@Datetime: 17-06-06 00:47
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        if (source == null || target == null) {
            return -1;
        }
        if ("".equals(target) || source.equals(target)) {
            return 0;
        }
        int i = 0;
        int lastPossible = source.length() - target.length() + 1;
        while (i < lastPossible) {
            if (source.charAt(i) == target.charAt(0)) {
                boolean equal = true;
                for (int j = 0; j < target.length() && equal; ++j) {
                    if (source.charAt(i + j) != target.charAt(j)) {
                        equal = false;
                    }
                }
                if (equal) {
                    return i;
                }
            }
            ++i;
        }
        return -1;
    }
}