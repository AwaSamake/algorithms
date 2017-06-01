/**
 *
 *  077. Combinations
 *    Given two integers n and k, return all possible combinations of k 
 *    numbers out of 1 ... n.
 *    
 *    For example,
 *    If n = 4 and k = 2, a solution is:
 *    
 *    [
 *      [2,4],
 *      [3,4],
 *      [2,3],
 *      [1,2],
 *      [1,3],
 *      [1,4],
 *    ]
 *
 */
import java.util.*;

public class Solution {
	public List<List<Integer>> combine(int n, int k) {
		boolean[] used = new boolean[n + 1];
		List<List<Integer>> combinations = new ArrayList<>();
		combine(combinations, new ArrayList<Integer>(), used, n, k, 1);
		return combinations;
	}
	
	private void combine(List<List<Integer>> combinations, List<Integer> combination, boolean[] used, int n, int k, int start) {
		if (combination.size() == k) {
			combinations.add(new ArrayList<Integer>(combination));
			return;
		}
		
		for (int i = start; i <= n; ++ i) {
			if (!used[i]) {
				combination.add(i);
				used[i] = true;
				combine(combinations, combination, used, n, k, i + 1);
				used[i] = false;
				combination.remove(combination.size() - 1);
			}
		}
	}
}