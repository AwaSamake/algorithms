/**
 *
 * 229. Majority Element II
 *     Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ 
 *     times. The algorithm should run in linear time and in O(1) space.
 *     
 *
 */
import java.util.*;

public class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums.length == 0) {
			return result;
		} else if (nums.length == 1) {
			result.add(nums[0]);
			return result;
		} else if (nums.length == 2) {
			result.add(nums[0]);
			if (nums[0] != nums[1]) {
				result.add(nums[1]);
			}
			return result;
		}
		Arrays.sort(nums);
		int oneThird = nums.length / 3;
		int twoThird = nums.length / 3 * 2;
		
		result.add(nums[oneThird]);
		if (nums[oneThird] != nums[twoThird]) {
			result.add(twoThird);
		}
		return result;
	}
}