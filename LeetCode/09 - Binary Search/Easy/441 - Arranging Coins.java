/**
 *
 *  441. Arranging Coins 
 *    You have a total of n coins that you want to form in a staircase shape, 
 *    where every k-th row must have exactly k coins.
 *    
 *    Given n, find the total number of full staircase rows that can be 
 *    formed.
 *    
 *    n is a non-negative integer and fits within the range of a 32-bit 
 *    signed integer.
 *    
 *    Example 1:
 *    
 *    n = 5
 *    
 *    The coins can form the following rows:
 *    ¤
 *    ¤ ¤
 *    ¤ ¤
 *    
 *    Because the 3rd row is incomplete, we return 2.
 *    Example 2:
 *    
 *    n = 8
 *    
 *    The coins can form the following rows:
 *    ¤
 *    ¤ ¤
 *    ¤ ¤ ¤
 *    ¤ ¤
 *    
 *    Because the 4th row is incomplete, we return 3.
 *    
 */
import java.util.*;

public class Solution {
	public int arrangeCoins(int n) {
		if (n <= 0) {
			return 0;
		}
		int lower = 1, higher = n;
		int mid = 1;
		while (lower <= higher) {
			mid = lower + (higher - lower) / 2;
			long coints = countCoins(mid);
			if (coints == n) {
				return mid;
			} else if (coints > n) {
				higher = mid - 1;
			} else {
				if (countCoins(mid + 1) > n) {
					return mid;
				}
				lower = mid + 1;
			}
		}
		return mid;
	}
	
	public long countCoins(long n) {
		return n * (n + 1) / 2;
	}
}