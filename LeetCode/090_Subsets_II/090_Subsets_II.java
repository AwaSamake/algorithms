/**
 *
 * 090. Subsets II
 *     Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 *     
 *     Note: The solution set must not contain duplicate subsets.
 *     
 *     For example,
 *     If nums = [1,2,2], a solution is:
 *     
 *     [
 *       [2],
 *       [1],
 *       [1,2,2],
 *       [2,2],
 *       [1,2],
 *       []
 *     ]
 *
 */
import java.util.*;

class Solution {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		if (nums.length < 1) {
			subsets.add(new ArrayList<Integer>());
		}
		Arrays.sort(nums);
		subsetsWithDup(subsets, new ArrayList<Integer>(), nums, 0);
		return subsets;
	}
	
	private void subsetsWithDup(List<List<Integer>> subsets, List<Integer> subset, int[] nums, int index) {
		subsets.add(subset);
		if (index > nums.length) {
			return;
		}
		for (int i = index; i < nums.length; ) {
			List<Integer> newSubset = new ArrayList<Integer>(subset);
			newSubset.add(nums[i]);
			subsetsWithDup(subsets, newSubset, nums, i + 1);
			i = next(nums, i);
		}
	}
	
	private int next(int[] nums, int index) {
		++index;
		while (index < nums.length && nums[index] == nums[index - 1]) {
			++index;
		}
		return index;
	}
}