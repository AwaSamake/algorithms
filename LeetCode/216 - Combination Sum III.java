/**
 *
 * 216. Combination Sum III
 *     Find all possible combinations of k numbers that add up to a number n, given that 
 *     only numbers from 1 to 9 can be used and each combination should be a unique set 
 *     of numbers.
 *     
 *     Example 1:
 *     Input: k = 3, n = 7
 *     Output:
 *     [[1,2,4]]
 *     
 *     Example 2:
 *     Input: k = 3, n = 9
 *     Output:
 *     [[1,2,6], [1,3,5], [2,3,4]]
 *     
 *
 */
import java.util.*;

public class Solution {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		combinationSum3(combinations, new ArrayList<Integer>(), k, n);
		return combinations;
	}
	
	public void combinationSum3(List<List<Integer>> combinations, List<Integer> list, int k, int n) {
		if (k == 1 && n < 10) {
			list.add(n);
			combinations.add(list);
		} else if (k > 1) {
			System.out.println(list.toString() + " => ");
			for (int i = 1; i < 10; ++i) {
				ArrayList combination = new ArrayList<Integer>(list);
				list.add(i);
				System.out.println(combination.toString() + " => ");
				combinationSum3(combinations, combination, k - 1, n - i);
			}
		}
	}
}