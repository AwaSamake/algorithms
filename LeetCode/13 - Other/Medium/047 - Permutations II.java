/**
 *
 *  047. Permutations II
 *    Given a collection of numbers that might contain duplicates, return all 
 *    possible unique permutations.
 *    
 *    For example,
 *    [1,1,2] have the following unique permutations:
 *    [
 *      [1,1,2],
 *      [1,2,1],
 *      [2,1,1]
 *    ]
 *
 */
import java.util.*;

public class Solution {
	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> permutations = new ArrayList<>();
		HashMap<Integer, Integer> freqCount = new HashMap<>();
		for (int num: nums) {
			freqCount.put(num, freqCount.getOrDefault(num, 0) + 1);
		}
		
		permuteUnique(permutations, freqCount, new ArrayList<Integer>(), nums);
		return permutations;
	}
	
	private void permuteUnique(List<List<Integer>> permutations, HashMap<Integer, Integer> freqCount, List<Integer> permutation, int[] nums) {
		if (permutation.size() == nums.length) {
			permutations.add(new ArrayList<Integer>(permutation));
			return;
		}
		
		for (int i = 0; i < nums.length; ++i) {
			if (freqCount.get(nums[i]) > 0) {
				permutation.add(nums[i]);
				freqCount.put(nums[i], freqCount.get(nums[i]) - 1);
				permuteUnique(permutations, freqCount, permutation, nums);
				permutation.remove(permutation.size() - 1);
				freqCount.put(nums[i], freqCount.get(nums[i]) + 1);
			}
			
			while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
				++i;
			}
		}
	}
}