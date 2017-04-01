/**
 *
 * 075. Sort Colors
 *    Given an array with n objects colored red, white or blue, sort them so that objects 
 *    of the same color are adjacent, with the colors in the order red, white and blue.
 *    
 *    Here, we will use the integers 0, 1, and 2 to represent the color red, white, and 
 *    blue respectively.
 *    
 *    Note:
 *    You are not suppose to use the library's sort function for this problem.
 *
 */
import java.util.*;

public class Solution {
	public void sortColors(int[] nums) {
		if (nums.length < 2) {
			return;
		}
		int color = 0;
		int slow = 0, fast = 0;
		while (color < 3 && slow < nums.length) {
			if (nums[fast] == color) {
			    int temp = nums[slow];
				nums[slow++] = nums[fast];
				nums[fast++] = temp;
				
			} else {
				fast++;
			}
			if (fast == nums.length) {
				color++;
				fast = slow;
			}
		}
	}
}