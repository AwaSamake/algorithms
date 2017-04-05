/**
 *
 * 153. Find Minimum in Rotated Sorted Array
 *     Suppose an array sorted in ascending order is rotated at some pivot unknown to you 
 *     beforehand.
 *     
 *     (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *     
 *     Find the minimum element.
 *     
 *     You may assume no duplicate exists in the array.
 *
 */
import java.util.*;

public class Solution {
	public int findMin(int[] nums) {
		int lower = 0, upper = nums.length - 1;
		int min = nums[0];
		while (lower <= upper) {
			int mid = (lower + upper) / 2;
			if (nums[mid] < nums[upper]) {
				min = Math.min(min, nums[mid]);
				upper = mid - 1;
			} else {
				min = Math.min(min, nums[lower]);
				lower = mid + 1;
			}
		}
		return min;
	}
}