/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/happy-number
@Language: Java
@Datetime: 17-06-11 05:33
*/

public class Solution {
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        HashSet<Integer> existed = new HashSet<>();
        while (n != 1) {
            if (existed.contains(n)) {
                return false;
            }
            existed.add(n);
            
            int n2 = 0;
            while (n != 0) {
                int last = n % 10;
                n2 += last * last;
                n /= 10;
            }
            n = n2;
        }
        return true;
    }
}