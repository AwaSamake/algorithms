/**
 *
 *  069. Sqrt(x)
 *    Implement int sqrt(int x).
 *    
 *    Compute and return the square root of x.
 *    
 */
import java.util.*;

public class Solution {
	public int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}
		int lower = 1, upper = x;
		while (lower < upper) {
			int mid = lower + (upper - lower) / 2;
			if (x / mid == mid) {
				return mid;
			} else if (x / mid > mid) {
				if (x / (mid + 1) < (mid + 1)) {
					return mid;
				}
				lower = mid + 1;
			} else {
				upper = mid - 1;
			}
		}
		return lower;
	}
}