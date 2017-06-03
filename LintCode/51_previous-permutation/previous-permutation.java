/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/previous-permutation
@Language: Java
@Datetime: 17-06-03 01:22
*/

public class Solution {
	/**
	 * @param nums: A list of integers
	 * @return: A list of integers that's previous permuation
	 */
	public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		for (int i = nums.size() - 1; i > 0; --i) {
			if (nums.get(i - 1) > nums.get(i)) {
				int max = nums.get(i);
				int pos = i;
				for (int j = i + 1; j < nums.size(); ++j) {
					if (nums.get(j) < nums.get(i - 1) && nums.get(j) >= max) {
						max = nums.get(j);
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
	
	private void reverse(ArrayList<Integer> nums, int start) {
		int end = nums.size() - 1;
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
	
	private void swap(ArrayList<Integer> nums, int i, int j) {
		int temp = nums.get(i);
		nums.set(i, nums.get(j));
		nums.set(j, temp);
	}
}