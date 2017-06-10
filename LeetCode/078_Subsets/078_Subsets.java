/**
 *
 * 078. Subsets
 *    Given a set of distinct integers, nums, return all possible subsets.
 *    
 *    Note: The solution set must not contain duplicate subsets.
 *    
 *    For example,
 *    If nums = [1,2,3], a solution is:
 *    
 *    [
 *      [3],
 *      [1],
 *      [2],
 *      [1,2,3],
 *      [1,3],
 *      [2,3],
 *      [1,2],
 *      []
 *    ]
 *    
 */
import java.util.*;

class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		subsets(subsets, new ArrayList<Integer>(), nums, 0);
		return subsets;
	}
	
	public void subsets(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int index) {
		subsets.add(subset);
		if (index >= nums.length) {
			return;
		}
		
		for (int i = index; i < nums.length; ++i) {
			List<Integer> newSubset = new ArrayList<Integer>(subset);
			newSubset.add(nums[i]);
			subsets(subsets, newSubset, nums, i + 1);
		}
	}
}