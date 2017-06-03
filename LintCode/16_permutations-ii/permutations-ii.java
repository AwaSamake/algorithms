/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Java
@Datetime: 17-06-02 21:46
*/

class Solution {
	/**
	 * @param nums: A list of integers.
	 * @return: A list of unique permutations.
	 */
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> permutations = new ArrayList<>();
		List<Integer> permutation = new ArrayList<Integer>();
		boolean[] used = new boolean[nums.length];
		permuteUnique(nums, permutations, permutation, used);
		return permutations;
	}
	
	private void permuteUnique(int[] nums, List<List<Integer>> permutations, List<Integer> permutation, boolean[] used) {
		if (permutation.size() == nums.length) {
			permutations.add(new ArrayList<Integer>(permutation));
			return;
		}
		Integer prev = null;
		for (int i = 0; i < nums.length; i++) {
			if (!used[i] && (prev == null || nums[i] != prev)) {
				prev = nums[i];
				used[i] = true;
				permutation.add(nums[i]);
				permuteUnique(nums, permutations, permutation, used);
				permutation.remove(permutation.size() - 1);
				used[i] = false;
			}
		}
	}
}