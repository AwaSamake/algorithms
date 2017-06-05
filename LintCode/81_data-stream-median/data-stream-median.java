/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/data-stream-median
@Language: Java
@Datetime: 17-06-05 00:10
*/

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
		if (nums.length < 1) {
			return new int[0];
		}
		int[] medians = new int[nums.length];
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		left.add(nums[0]);
		medians[0] = nums[0];
		for (int i = 1; i < nums.length; ++i) {
			if (nums[i] > left.peek()) {
				right.add(nums[i]);
			} else {
				left.add(nums[i]);
			}
			while (left.size() < right.size()) {
				left.add(right.remove());
			}
			while (left.size() - 1 > right.size()) {
				right.add(left.remove());
			}
			medians[i] = left.peek();
		}
		return medians;
	}
}