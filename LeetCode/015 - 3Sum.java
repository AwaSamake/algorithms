/**
 *
 * 015. 3Sum
 *     Given an array S of n integers, are there elements a, b, c in S such that 
 *     a + b + c = 0? Find all unique triplets in the array which gives the sum of 
 *     zero.
 *     
 *     Note: The solution set must not contain duplicate triplets.
 *     
 *     For example, given array S = [-1, 0, 1, 2, -1, -4],
 *     
 *     A solution set is:
 *     [
 *       [-1, 0, 1],
 *       [-1, -1, 2]
 *     ]
 *
 */
import java.util.*;

public class Solution {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> listOfCombinations = new ArrayList<List<Integer>>();
		if (nums.length < 3 || nums[nums.length - 1] < 0) {
			return listOfCombinations;
		}
		
		int i = 0, j = 1, k = nums.length - 1, sum = 0;
		
		while (nums[i] <= 0) {
			while (j < k) {
				sum = nums[i] + nums[j] + nums[k];
				if (sum <= 0) {
					if (sum == 0) {
						List<Integer> combination = new ArrayList<Integer>();
						combination.add(nums[i]);
						combination.add(nums[j]);
						combination.add(nums[k]);
						listOfCombinations.add(combination);
					}
					++j;
					while (j < k && nums[j - 1] == nums[j]) {
						++j;
					}
				} else {
					--k;
					while (j < k && nums[k + 1] == nums[k]) {
						--k;
					}
				}
			}
			++i;
			while (nums[i - 1] == nums[i]) {
				if (i > nums.length - 3) {
					return listOfCombinations;
				}
				++i;
			}
			j = i + 1;
			if (nums[i] + nums[j] > 0) {
				return listOfCombinations;
			}
			k = nums.length - 1;
		}
		return listOfCombinations;
	}
}