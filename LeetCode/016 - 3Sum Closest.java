/**
 *
 * 016. 3Sum Closest
 *     Given an array S of n integers, find three integers in S such that the sum is 
 *     closest to a given number, target. Return the sum of the three integers. You 
 *     may assume that each input would have exactly one solution.
 *     
 *         For example, given array S = {-1 2 1 -4}, and target = 1.
 *     
 *         The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */
import java.util.*;

public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int length = nums.length, closest = 0, diff = Integer.MAX_VALUE;
		for (int i = 0; i < length - 2; ++i) {
			int j = i + 1, k = length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum < target) {
					++j;
				} else {
					--k;
				}
				
				if (Math.abs(sum - target) < diff) {
					diff = Math.abs(sum - target);
					closest = sum;
					System.out.println(sum);
				}
			}
		}
		return closest;
	}
}