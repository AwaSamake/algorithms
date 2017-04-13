/**
 *
 * 078. Subsets
 *     Given a set of distinct integers, nums, return all possible subsets.
 *     
 *     Note: The solution set must not contain duplicate subsets.
 *     
 *     For example,
 *     If nums = [1,2,3], a solution is:
 *     
 *     [
 *       [3],
 *       [1],
 *       [2],
 *       [1,2,3],
 *       [1,3],
 *       [2,3],
 *       [1,2],
 *       []
 *     ]
 *
 */
import java.util.*;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		for (int num: nums) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(num);
			subsets.add(list);
		}
		subsets(nums, subsets, 1);
		return subsets;
	}
	
	public void subsets(int[] nums, List<List<Integer>> subsets, int index) {
		if (index >= nums.length) {
			subsets.add(new ArrayList<Integer>());
			return;
		}
		List<List<Integer>> newSubsets = new ArrayList<List<Integer>>();
		for (List<Integer> list : subsets) {
			List<Integer> newList = new ArrayList<Integer>(list);
			list.add(nums[index]);
			newSubsets.add(list);
		}
		subsets.addAll(newSubsets);
		subsets(nums, subsets, index + 1);
	}
}