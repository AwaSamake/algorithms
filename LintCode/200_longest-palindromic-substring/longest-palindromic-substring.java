/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/longest-palindromic-substring
@Language: Java
@Datetime: 17-06-01 01:53
*/

public class Solution {
    class Palindrome {
        public int start;
        public int end;
        public Palindrome(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int length() {
            return end - start + 1;
        }
    }
    
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        Palindrome longest = new Palindrome(0, 0);
        for (int i = 0; i < str.length; ++i) {
            longest = max(longest, longestPalindrome(str, i, i + 1), longestPalindrome(str, i, i + 2));
        }
        return s.substring(longest.start, longest.end + 1);
    }
    
    public Palindrome longestPalindrome(char[] str, int i, int j) {
        if (j >= str.length) {
            return new Palindrome(i, i);
        }
        while (i > -1 && j < str.length && str[i] == str[j]) {
            i--;
            j++;
        }
        return new Palindrome(i + 1, j - 1);
    }
    
    public Palindrome max(Palindrome p1, Palindrome p2, Palindrome p3) {
        int l1 = p1.length();
        int l2 = p2.length();
        int l3 = p3.length();
        if (l1 >= l2 && l1 >= l3) {
            return p1;
        }
        if (l2 >= l1 && l2 >= l3) {
            return p2;
        }
        return p3;
    }
}