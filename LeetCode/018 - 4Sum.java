/**
 *
 * 018. 4Sum
 *     Given an array S of n integers, are there elements a, b, c, and d in S such 
 *     that a + b + c + d = target? Find all unique quadruplets in the array which 
 *     gives the sum of target.
 *     
 *     Note: The solution set must not contain duplicate quadruplets.
 *     
 *     For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 *     
 *     A solution set is:
 *     [
 *       [-1,  0, 0, 1],
 *       [-2, -1, 1, 2],
 *       [-2,  0, 0, 2]
 *     ]
 *
 */
import java.util.*;

public class Solution {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		List<List<Integer>> listOfCombinations = new ArrayList<List<Integer>>();
		if (nums.length < 4) {
			return listOfCombinations;
		}
		int i = 0, j = 1, k = 2, l = nums.length - 1, length = nums.length;
		while (i < length - 3) {
			while (j < length - 2) {
				while (k < l) {
					int sum = nums[i] + nums[j] + nums[k] + nums[l];
					if (sum == target) {
						List<Integer> combination = new ArrayList<Integer>();
						combination.add(nums[i]);
						combination.add(nums[j]);
						combination.add(nums[k]);
						combination.add(nums[l]);
						listOfCombinations.add(combination);
						++k;
						while (k < l && nums[k] == nums[k - 1]) {
							++k;
						}
						--l;
						while (k < l && nums[l] == nums[l + 1]) {
							--l;
						}
					} else if (sum < target) {
						++k;
						while (k < l && nums[k] == nums[k - 1]) {
							++k;
						}
					} else {
						--l;
						while (k < l && nums[l] == nums[l + 1]) {
							--l;
						}
					}
				}
				++j;
				while (j < k && nums[j] == nums[j - 1]) {
					++j;
				}
				k = j + 1;
				l = nums.length - 1;
			}
			++i;
			while (i < j && nums[i] == nums[i - 1]) {
				++i;
			}
			j = i + 1;
			k = j + 1;
			l = nums.length - 1;
		}
		return listOfCombinations;
	}
}