/**
 *
 * 001 - Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to 
 * a specific target. You may assume that each input would have exactly one solution, and 
 * you may not use the same element twice.
 *
 */
import java.util.*;

class Solution {
	public int[] twoSum(int[] nums, int target) {
		int[] pair = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(nums[0], 0);
		int wanted;
		for (int i = 1; i < nums.length; ++i) {
			wanted = target - nums[i];
			if (map.containsKey(wanted)) {
				pair[0] = map.get(wanted);
				pair[1] = i;
				return pair;
			} else {
				map.put(nums[i], i);
			}
		}
		return pair;
	}
}