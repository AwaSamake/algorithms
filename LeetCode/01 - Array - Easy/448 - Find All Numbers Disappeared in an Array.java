/**
 *
 * 448 Find All Numbers Disappeared in an Array
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements 
 * appear twice and others appear once. 
 * Find all the elements of [1, n] inclusive that do not appear in this array. 
 * Could you do it without extra space and in O(n) runtime? You may assume the returned 
 * list does not count as extra space.
 *
 */

import java.util.*;

public class Solution {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> missingNums = new ArrayList<Integer>();
		int length = nums.length;
		for (int i = 0; i < length; ++i) {
			int index = (nums[i] - 1) % length;
			nums[index] += length;
		}
		
		for (int i = 0; i < length; ++i) {
			if (nums[i] <= length) {
				missingNums.add(i + 1);
			}
		}
		
		return missingNums;
	}
}