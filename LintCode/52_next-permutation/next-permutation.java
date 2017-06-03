/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/next-permutation
@Language: Java
@Datetime: 17-06-03 01:05
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: An array of integers that's next permuation
     */
    public int[] nextPermutation(int[] nums) {
		for (int i = nums.length - 1; i > 0; --i) {
			if (nums[i - 1] < nums[i]) {
				int min = nums[i];
				int pos = i;
				for (int j = i + 1; j < nums.length; ++j) {
					if (nums[j] > nums[i - 1] && nums[j] <= min) {
						min = nums[j];
						pos = j;
					}
				}
				swap(nums, pos, i - 1);
				reverse(nums, i);
				return nums;
			}
		}
		reverse(nums, 0);
		return nums;
	}
	
	private void reverse(int[] nums, int start) {
		int end = nums.length - 1;
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}