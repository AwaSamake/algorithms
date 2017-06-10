/**
 *
 * 238. Product of Array Except Self
 *     Given an array of n integers where n > 1, nums, return an array output such that 
 *     output[i] is equal to the product of all the elements of nums except nums[i].
 *     
 *     Solve it without division and in O(n).
 *     
 *     For example, given [1,2,3,4], return [24,12,8,6].
 *     
 *     Follow up:
 *     Could you solve it with constant space complexity? (Note: The output array does 
 *     not count as extra space for the purpose of space complexity analysis.)
 *     
 *
 */
import java.util.*;

public class Solution {
	public int[] productExceptSelf(int[] nums) {
		int[] products = new int[nums.length];
		int product = 1;
		boolean zero = false;
		int indexOfZero = -1;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] != 0) {
				product *= nums[i];
			} else {
				if (zero) {
					return products;
				}
				zero = true;
				indexOfZero = i;
			}
		}
		if (zero) {
			products[indexOfZero] = product;
			return products;
		}
		for (int i = 0; i < nums.length; ++i) {
			products[i] = product / nums[i];
		}
		return products;
	}
}