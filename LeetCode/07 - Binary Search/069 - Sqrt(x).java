/**
 *
 * 069. Sqrt(x)
 *     Implement int sqrt(int x). 
 *     Compute and return the square root of x.
 * 
 */
import java.util.*;

public class Solution {
	public int mySqrt(int x) {
		int root = x;
		while (root * root > x) {
			root >>= 1;
		}
		return root;
	}
}