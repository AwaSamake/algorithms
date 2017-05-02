/**
 *
 *  198. House Robber
 *    You are a professional robber planning to rob houses along a street. Each house has 
 *    a certain amount of money stashed, the only constraint stopping you from robbing 
 *    each of them is that adjacent houses have security system connected and it will 
 *    automatically contact the police if two adjacent houses were broken into on the 
 *    same night.
 *    
 *    Given a list of non-negative integers representing the amount of money of each 
 *    house, determine the maximum amount of money you can rob tonight without alerting 
 *    the police.
 *
 */
import java.util.*;

public class Solution {
	public int rob(int[] nums) {
		int[] cache = new int[nums.length];
		for (int i = 0; i < nums.length; ++i) {
			cache[i] = -1;
		}
		return rob(nums, cache, 0);
	}
	
	public int rob(int[] nums, int[] cache, int index) {
		if (index >= nums.length) {
			return 0;
		}
		if (cache[index] != -1) {
			return cache[index];
		}
		int one = rob(nums, cache, index + 1);
		int two = rob(nums, cache, index + 2) + nums[index];
		
		cache[index] = Math.max(one, two);
		return cache[index];
	}
}