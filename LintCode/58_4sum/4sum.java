/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/4sum
@Language: Java
@Datetime: 17-06-08 04:46
*/

public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {
		ArrayList<ArrayList<Integer>> results = new ArrayList<>();
		if (nums.length < 4) {
			return results;
		}
		Arrays.sort(nums);
		int i = 0, j, k, l;
		while (i < nums.length - 3) {
			l = nums.length - 1;
			while (l > i + 2) {
				j = i + 1;
				k = l - 1;
				int twoSum = nums[i] + nums[l];
				while (j < k) {
					int fourSum = twoSum + nums[j] + nums[k];
					if (fourSum == target) {
						ArrayList<Integer> result = new ArrayList<>();
						result.add(nums[i]);
						result.add(nums[j]);
						result.add(nums[k]);
						result.add(nums[l]);
						results.add(result);
						j = increment(nums, j);
					} else if (fourSum < target) {
						j = increment(nums, j);
					} else {
						k = decrement(nums, k);
					}
				}
				l = decrement(nums, l);
			}
			i = increment(nums, i);
		}
		return results;
	}

	private int decrement(int[] nums, int i) {
		while (i > 1 && nums[i] == nums[i - 1]) {
			--i;
		}
		return i - 1;
	}
	
	private int increment(int[] nums, int i) {
		while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
			++i;
		}
		return i + 1;
	}
}