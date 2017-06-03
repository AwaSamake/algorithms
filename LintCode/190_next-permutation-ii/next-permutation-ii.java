/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/next-permutation-ii
@Language: Java
@Datetime: 17-06-03 01:11
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
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
				return;
			}
		}
		reverse(nums, 0);
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