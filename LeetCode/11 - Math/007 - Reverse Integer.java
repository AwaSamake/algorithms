/**
 *
 * 007. Reverse Integer
 *    Reverse digits of an integer.
 *
 *    Example1: x = 123, return 321
 *    Example2: x = -123, return -321
 *
 */

import java.util.*;

public class Solution {
    public int reverse(int x) {
        int reversedX = 0;
        while (x != 0) {
            int temp = reversedX;
            int lastDigit = x % 10;
            x /= 10;
            reversedX = reversedX * 10 + lastDigit;
            if (reversedX / 10 != temp) {
                return 0;
            }
        }
        return reversedX;
    }
}