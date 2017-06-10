/**
 *
 *  491. Increasing Subsequences
 *    Given an integer array, your task is to find all the different possible increasing 
 *    subsequences of the given array, and the length of an increasing subsequence should 
 *    be at least 2 .
 *    
 *    Example:
 *    Input: [4, 6, 7, 7]
 *    Output: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 *    Note:
 *    The length of the given array will not exceed 15.
 *    The range of integer in the given array is [-100,100].
 *    The given array may contain duplicates, and two equal integers should also be 
 *    considered as a special case of increasing sequence.
 *
 */
import java.util.*;

public class Solution {
	public List<List<Integer>> findSubsequences(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		findSubsequences(nums, results, 0, new ArrayList<Integer>());
		return results;
	}
	
	public void findSubsequences(int[] nums, List<List<Integer>> results, int index, List<Integer> subsequence) {
		if (index >= nums.length) {
			return;
		}
		
		List<Integer> newSequence1 = new ArrayList<>(subsequence);
		if (newSequence1.size() > 1) {
			results.add(newSequence1);
		}
		findSubsequences(nums, results, index + 1, newSequence1);
		
		List<Integer> newSequence2 = new ArrayList<>(subsequence);
		newSequence2.add(nums[index]);
		if (newSequence2.size() > 1) {
			results.add(newSequence2);
		}
		findSubsequences(nums, results, index + 1, newSequence2);
	}
}