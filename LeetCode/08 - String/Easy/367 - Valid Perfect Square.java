/**
 *
 *  367. Valid Perfect Square
 *    Given a positive integer num, write a function which returns True if 
 *    num is a perfect square else False.
 *    
 *    Note: Do not use any built-in library function such as sqrt.
 *    
 *    Example 1:
 *    
 *    Input: 16
 *    Returns: True
 *    Example 2:
 *    
 *    Input: 14
 *    Returns: False
 *    
 */
import java.util.*;

public class Solution {
	public boolean isPerfectSquare(int num) {
		long lower = 1;
		long higher = num;
		
		while (lower <= higher) {
			long mid = (lower + higher) / 2;
			long square = mid * mid;
			if (square == num) {
				return true;
			} else if (square < num) {
				lower = mid + 1;
			} else {
				higher = mid - 1;
			}
		}
		return false;
	}
}