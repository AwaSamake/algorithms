import java.util.*;

class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> combinations = new ArrayList<>();
		combinationSum(candidates, target, combinations, new ArrayList<>(), 0);
		return combinations;
	}
	
	public void combinationSum(int[] candidates, int target, List<List<Integer>> combinations, List<Integer> combination, int index) {
		if (target < 0) {
			return;
		}
		if (target == 0) {
			combinations.add(new ArrayList<>(combination));
			return;
		}
		
		for (int i = index; i < candidates.length; ++i) {
			int candidate = candidates[i];
			combination.add(candidate);
			combinationSum(candidates, target - candidate, combinations, combination, i);
			combination.remove(combination.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.combinationSum(new int[] {2,3,6,7}, 7));
	}
}