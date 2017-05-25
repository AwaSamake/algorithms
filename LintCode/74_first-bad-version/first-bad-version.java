/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/first-bad-version
@Language: Java
@Datetime: 17-05-25 00:59
*/

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int lower = 1, upper = n, version = 0;
        while (lower <= upper) {
            version = lower + (upper - lower) / 2;
            if (SVNRepo.isBadVersion(version)) {
                upper = version - 1;
            } else {
                lower = version + 1;
            }
        }
        return lower;
    }
}
