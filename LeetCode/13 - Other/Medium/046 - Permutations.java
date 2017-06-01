/**
 *
 *  046. Permutations
 *    Given a collection of distinct numbers, return all possible 
 *    permutations.
 *    
 *    For example,
 *    [1,2,3] have the following permutations:
 *    [
 *      [1,2,3],
 *      [1,3,2],
 *      [2,1,3],
 *      [2,3,1],
 *      [3,1,2],
 *      [3,2,1]
 *    ]
 *
 */
import java.util.*;

public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> listOfPermutations = new ArrayList<List<Integer>>();
		permute(listOfPermutations, new ArrayList<Integer>(), nums);
		return listOfPermutations;
	}
	
	public void permute(List<List<Integer>> listOfPermutations, List<Integer> permutation, int[] nums) {
		if (permutation.size() == nums.length) {
			listOfPermutations.add(new ArrayList<Integer>(permutation));
		}
		
		for (int num: nums) {
			if (!permutation.contains(num)) {
				permutation.add(num);
				permute(listOfPermutations, permutation, nums);
				permutation.remove(permutation.size() - 1);
			}
		}
	}
}