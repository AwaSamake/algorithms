/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/longest-substring-without-repeating-characters
@Language: Java
@Datetime: 17-05-24 21:07
*/

public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        // save the index of each char appears in the string
        HashMap<Character, Integer> charIndex = new HashMap<>();
        int begin = 0;
        int max = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (charIndex.containsKey(s.charAt(i))) {
                // the new begining of Substring should be the char after char's
                // previous appearance if previous begin is before begin.
                begin = Math.max(charIndex.get(s.charAt(i)) + 1, begin);
            }
            charIndex.put(s.charAt(i), i);
            max = Math.max(max, i - begin + 1);
        }
        return max;
    }
}
