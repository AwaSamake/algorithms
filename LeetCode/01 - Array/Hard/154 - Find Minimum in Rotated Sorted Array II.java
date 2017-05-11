/**
 *
 *  154. Find Minimum in Rotated Sorted Array II
 *    Suppose an array sorted in ascending order is rotated at some pivot 
 *    unknown to you beforehand.
 *    
 *    (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *    
 *    Find the minimum element.
 *    
 *    The array may contain duplicates.
 *    
 */
import java.util.*;

public class Solution {
	public int findMin(int[] nums) {
		return findMin(nums, 0, nums.length - 1, Integer.MAX_VALUE);
	}
	
	public int findMin(int[] nums, int lower, int upper, int min) {
		if (lower > upper) {
			return min;
		}
		int mid = (lower + upper) / 2;
		min = Math.min(min, nums[mid]);
		if (nums[mid] < nums[upper]) {
			return findMin(nums, lower, mid - 1, min);
		} else if (nums[lower] < nums[mid]) {
			min = Math.min(min, nums[lower]);
			return findMin(nums, mid + 1, upper, min);
		}
		return Math.min(min, Math.min(findMin(nums, lower, mid - 1, min), findMin(nums, mid + 1, upper, min)));
	}
}