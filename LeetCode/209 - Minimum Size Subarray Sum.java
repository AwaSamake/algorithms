/**
 *
 * 209. Minimum Size Subarray Sum
 *    Given an array of n positive integers and a positive integer s, find the minimal 
 *    length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 
 *    instead.
 *    
 *    For example, given the array [2,3,1,2,4,3] and s = 7,
 *    the subarray [4,3] has the minimal length under the problem constraint.
 *     
 *
 */
import java.util.*;

public class Solution {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int sum = nums[0], length = nums.length + 1;
		int left = 0, right = 0;
		while (right < nums.length || sum > s) {
			if (sum >= s) {
				length = Math.min(length, right - left + 1);
			}
			if (sum > s) {
				sum -= nums[left];
				left++;
			} else if (++right < nums.length) {
				sum += nums[right];
			}
		}
		return length == nums.length + 1 ? 0 : length;
	}
}