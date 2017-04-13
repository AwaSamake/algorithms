/**
 *
 * 080. Remove Duplicates from Sorted Array II
 *     Follow up for "Remove Duplicates":
 *     What if duplicates are allowed at most twice?
 *     
 *     For example,
 *     Given sorted array nums = [1,1,1,2,2,3],
 *     
 *     Your function should return length = 5, with the first five elements of nums being 
 *     1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 *     
 *
 */
import java.util.*;

public class Solution {
	public int removeDuplicates(int[] nums) {
		int slow = 1, fast = 1;
		boolean repeated = false;
		while (fast < nums.length) {
			if (nums[slow - 1] == nums[fast] && !repeated) {
				repeated = true;
				nums[slow++] = nums[fast++];
			} else if (nums[slow - 1] == nums[fast]) {
				fast++;
			} else {
				nums[slow++] = nums[fast++];
				repeated = false;
			}
		}
		return slow;
	}
}