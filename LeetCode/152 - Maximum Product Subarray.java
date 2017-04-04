/**
 *
 * 152. Maximum Product Subarray
 *     Find the contiguous subarray within an array (containing at least one number) 
 *     which has the largest product.
 *     
 *     For example, given the array [2,3,-2,4],
 *     the contiguous subarray [2,3] has the largest product = 6.
 *     
 *
 */
import java.util.*;

public class Solution {
	public int maxProduct(int[] nums) {
		int minNeg = 0;
		int product = 1;
		for (int num: nums) {
			product *= num;
			if (num < 0) {
				minNeg = minNeg < num ? minNeg : num;
			}
		}
		if (product < 0) {
			return product / minNeg;
		} else {
			product;
		}
	}
}