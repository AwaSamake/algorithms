/**
 *
 * 152. Maximum Product Subarray
 *     Find the contiguous subarray within an array (containing at least one number) 
 *     which has the largest product.
 *     
 *     For example, given the array [2,3,-2,4],
 *     the contiguous subarray [2,3] has the largest product = 6.
 *
 */
import java.util.*;

class Solution {
	public int maxProduct(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int result = nums[0];
		for (int i = 1, min = nums[0], max = nums[0]; i < nums.length; ++i) {
			if (nums[i] < 0) {
				int temp = min;
				min = max;
				max = temp;
			}
			
			min = Math.min(nums[i], nums[i] * min);
			max = Math.max(nums[i], nums[i] * max);
			
			result = Math.max(result, max);
		}
		return result;
	}
}