/**
 *
 * 009. Palindrome Number
 *    Determine whether an integer is a palindrome. Do this without extra space.
 *
 */

import java.util.*;

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int x2 = 0;

        while (x > x2) {
            x2 = x2 * 10 + x % 10;
            x /= 10;
        }
        return x == x2 || x2 / 10 == x;
    }
}