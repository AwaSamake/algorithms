import java.util.*;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		subsets(nums, subsets, new ArrayList<Integer>(), 0);
		return subsets;
	}
	
	public void subsets(int[] nums, List<List<Integer>> subsets, List<Integer> subset, int index) {
		if (index > nums.length) {
			return;
		}
		
		subsets.add(new ArrayList<>(subset));
		
		for (int i = index; i < nums.length; ++i) {
			subset.add(nums[i]);
			subsets(nums, subsets, subset, i + 1);
			subset.remove(subset.size() - 1);
		}
	}
}