/**
 *
 * 216. Combination Sum III
 *    Find all possible combinations of k numbers that add up to a number n, given that 
 *    only numbers from 1 to 9 can be used and each combination should be a unique set of 
 *    numbers.
 *    
 *    
 *    Example 1:
 *    
 *    Input: k = 3, n = 7
 *    
 *    Output:
 *    
 *    [[1,2,4]]
 *    
 *    Example 2:
 *    
 *    Input: k = 3, n = 9
 *    
 *    Output:
 *    
 *    [[1,2,6], [1,3,5], [2,3,4]]
 *     
 *
 */
import java.util.*;

class Solution1 {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		combinationSum3(combinations, new ArrayList<Integer>(), k, n, 0, 1);
		return combinations;
	}
	
	public void combinationSum3(List<List<Integer>> combinations, List<Integer> combination, int k, int n, int sum, int begin) {
		if (k == 0 && sum == n) {
			combinations.add(combination);
		}
		if (k <= 0) {
			return;
		}
		for (int i = begin; i < 10; ++i) {
			List<Integer> newCombination = new ArrayList<Integer>(combination);
			newCombination.add(i);
			combinationSum3(combinations, newCombination, k - 1, n, sum + i, i + 1);
		}
	}
}

class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		boolean[] used = new boolean[10];
		combinationSum3(combinations, new ArrayList<Integer>(), k, n, 1, used);
		return combinations;
	}
	
	public void combinationSum3(List<List<Integer>> combinations, List<Integer> combination, int k, int n, int begin, boolean[] used) {
		if (k == 1 && n > 0 && n < 10 && n > combination.get(combination.size() - 1) && !used[n]) {
			combination.add(n);
			combinations.add(combination);
			return;
		}
		if (k <= 0) {
			return;
		}
		for (int i = begin; i < 10; ++i) {
			if (i > n) {
				return;
			}
			List<Integer> newCombination = new ArrayList<Integer>(combination);
			newCombination.add(i);
			used[i] = true;
			combinationSum3(combinations, newCombination, k - 1, n - i, i + 1, used);
			used[i] = false;
		}
	}
}

class test {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.combinationSum3(3, 15));
	}
}




