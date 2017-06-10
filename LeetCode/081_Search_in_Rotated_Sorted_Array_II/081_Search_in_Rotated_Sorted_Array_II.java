/**
 *
 * 081. Search in Rotated Sorted Array II
 *     Suppose an array sorted in ascending order is rotated at some pivot unknown to you 
 *     beforehand.
 *     
 *     (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *     
 *     Write a function to determine if a given target is in the array.
 *     
 *     The array may contain duplicates.
 *     
 *
 */
import java.util.*;

public class Solution {
	public boolean search(int[] nums, int target) {
		int low = 0, high = nums.length - 1;
		return search(nums, target, 0, nums.length - 1);
	}
	
	public boolean search(int[] nums, int target, int low, int high) {
	    while(low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] == target) {
				return true;
			}
			if (nums[mid] == nums[high]) {
			    return search(nums, target, low, mid - 1) || search(nums, target, mid + 1, high);
			} else if (nums[mid] < nums[high]) {
				// right side normal
				if (nums[mid] < target && target <= nums[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			} else {
				// left side normal
				if (nums[low] <= target && target < nums[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
		}
		return false;
	}
}