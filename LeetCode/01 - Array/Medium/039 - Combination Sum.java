/**
 *
 * 039. Combination Sum
 *     Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
 *     find all unique combinations in C where the candidate numbers sums to T.
 *     
 *     The same repeated number may be chosen from C unlimited number of times.
 *     
 *     Note:
 *     All numbers (including target) will be positive integers.
 *     The solution set must not contain duplicate combinations.
 *     For example, given candidate set [2, 3, 6, 7] and target 7, 
 *     A solution set is: 
 *     [
 *       [7],
 *       [2, 2, 3]
 *     ]
 *
 */
import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> listOfCombinations = new ArrayList<List<Integer>>();
		List<Integer> combination = new ArrayList<Integer>();
		combinationsSum(listOfCombinations, combination, candidates, target, 0);
		return listOfCombinations;
	}
	
	public void combinationsSum(List<List<Integer>> listOfCombinations, List<Integer> combination, int[] candidates, int target, int index) {
		if (target < 0) {
			return;
		} else if (target == 0) {
			listOfCombinations.add(combination);
		}
		
		for (int i = index; i < candidates.length; ++i) {
			ArrayList<Integer> newCombination = new ArrayList<Integer>(combination);
			newCombination.add(candidates[i]);
			combinationsSum(listOfCombinations, newCombination, candidates, target - candidates[i], i);
		}
	}
}