/**
 *
 * 414 Third Maximum Number
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 */ 

import java.util.*;

class Solution {
	public int thirdMax(int[] nums) {
		HashSet<Integer> max = new HashSet<Integer>();
		int bottomLine = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] >= bottomLine) {
				bottomLine = addMax(max, nums[i], bottomLine);
			}
		}
		
		if (max.size() == 3) {
			return bottomLine;
		} else {
			Integer[] max2 = max.toArray(new Integer[max.size()]);
			return Math.max(max2[0], max2[max2.length-1]);
		}
	}
	
	public int addMax(HashSet<Integer> max, int val, int bottomLine) {
		max.add(val);
		if (max.size() < 3) {
			return Integer.MIN_VALUE;
		} else if (max.size() > 3) {
			max.remove(bottomLine);
		}
		bottomLine = Integer.MAX_VALUE;
		for (int i : max) {
			if (i < bottomLine) {
				bottomLine = i;
			}
		}
		return bottomLine;
	}
}