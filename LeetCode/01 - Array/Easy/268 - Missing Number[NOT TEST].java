/**
 *
 * 268 Missing Number
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one 
 * that is missing from the array. 
 * For example, 
 *     Given nums = [0, 1, 3] return 2. 
 *     Note: 
 *     Your algorithm should run in linear runtime complexity. 
 *     Could you implement it using only constant extra space complexity?
 *
 */ 

import java.util.*;

public class Solution {
	public int missingNumber(int[] nums) {
	    if (nums.length < 1) {
	        return 0;
	    }
		int lower = 0, upper = nums.length - 1;
		int mid = 0;
		int expect = 0;
		while (lower <= upper) {
			mid = (lower + upper) >> 1;
			expect = nums[0] + mid;
			
			if (nums[mid] == expect) {
				lower = mid + 1;
			} else if (nums[mid] < expect){
				upper = mid - 1;
			} else {
				return expect;
			}
		}
		return expect + 1;
	}
}