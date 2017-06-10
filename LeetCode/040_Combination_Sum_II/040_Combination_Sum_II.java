/**
 *
 * 040 Combination Sum II 
 *     Given a collection of candidate numbers (C) and a target number (T), find all 
 *     unique combinations in C where the candidate numbers sums to T.
 *     
 *     Each number in C may only be used once in the combination.
 *     
 *     Note:
 *     All numbers (including target) will be positive integers.
 *     The solution set must not contain duplicate combinations.
 *     For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 *     A solution set is: 
 *     [
 *       [1, 7],
 *       [1, 2, 5],
 *       [2, 6],
 *       [1, 1, 6]
 *     ]
 *
 */
import java.util.*;

class Solution {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> listOfCombinations = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		System.out.println(Arrays.toString(candidates));
		combinationSum2(listOfCombinations, new ArrayList<Integer>(), candidates, target, 0, 0);
		return listOfCombinations;
	}
	
	public void combinationSum2(List<List<Integer>> listOfCombinations, 
								List<Integer> combination,
								int[] candidates, int target, int index, int sum) 
	{
		if (sum == target) {
			listOfCombinations.add(combination);
			return;
		} else if (sum > target || index >= candidates.length) {
			return;
		}
		for (int i = index; i < candidates.length; i = nextGreater(candidates, i)) {
			ArrayList<Integer> newCombinationWith = new ArrayList<Integer>(combination);
			newCombinationWith.add(candidates[i]);
			combinationSum2(listOfCombinations, newCombinationWith, candidates, target, i + 1, sum + candidates[i]);
		}
	}
	
	public int nextGreater(int[] candidates, int index) {
		index++;
		while (index < candidates.length && candidates[index] == candidates[index - 1]) {
			index++;
		}
		return index;
	}
}