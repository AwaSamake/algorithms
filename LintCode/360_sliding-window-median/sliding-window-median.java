/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/sliding-window-median
@Language: Java
@Datetime: 17-05-25 06:42
*/

import java.util.*;

class Solution {
	/**
	 * @param nums: A list of integers.
	 * @return: The median of the element inside the window at each moving.
	 */
	public ArrayList <Integer> medianSlidingWindow(int[] nums, int k) {
		ArrayList <Integer> result = new ArrayList <> ();
		if (k == 0 || nums.length < k) {
			return result;
		}
		PriorityQueue<Integer> right = new PriorityQueue<Integer> (k);
		PriorityQueue<Integer> left = new PriorityQueue<Integer> (k, Collections.reverseOrder());

		for (int i = 0; i < k - 1; ++i) {
			add(right, left, nums[i]);
		}

		for (int i = k - 1; i < nums.length; ++i) {
			add(right, left, nums[i]);
			int median = getMedian(right, left);
			result.add(median);
			remove(right, left, nums[i - k + 1]);
		}
		return result;
	}

	private int getMedian(PriorityQueue<Integer> right, PriorityQueue<Integer> left) {
		if (left.isEmpty() && right.isEmpty()) {
			return 0;
		}
		while (left.size() < right.size()) {
			left.add(right.poll());
		}

		while (left.size() - right.size() > 1) {
			right.add(left.poll());
		}
		return left.peek();
	}

	private void add(PriorityQueue<Integer> right, PriorityQueue<Integer> left, int num) {
		if (left.isEmpty() && right.isEmpty()) {
			left.add(num);
			return;
		} else {
			if (num <= getMedian(right, left)) {
				left.add(num);
			} else {
				right.add(num);
			}
		}
	}

	private void remove(PriorityQueue<Integer> right, PriorityQueue<Integer> left, int num) {
		if (num <= getMedian(right, left)) {
			left.remove(num);
		} else {
			right.remove(num);
		}
	}
}