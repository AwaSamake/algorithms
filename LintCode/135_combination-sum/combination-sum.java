/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Java
@Datetime: 17-06-02 04:49
*/

public class Solution {
	/**
	 * @param candidates: A list of integers
	 * @param target:An integer
	 * @return: A list of lists of integers
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> combinations = new ArrayList<>();
		List<Integer> combination = new ArrayList<>();
		Arrays.sort(candidates);
		combinationSum(candidates, target, 0, combinations, combination);
		return combinations;
	}
	
	public void combinationSum(int[] candidates, int target, int index, List<List<Integer>> combinations, List<Integer> combination) {
		 if (target < 0) {
		     return;
		 }
		if (target == 0) {
			combinations.add(new ArrayList<Integer>(combination));
		}
		for (int i = index; i < candidates.length; i = increment(candidates, i)) {
			combination.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, combinations, combination);
			combination.remove(combination.size() - 1);
		}
	}
	
	private int increment(int[] candidates, int i) {
		while (i + 1 < candidates.length && candidates[i + 1] == candidates[i]) {
			++i;
		}
		return i + 1;
	}
}