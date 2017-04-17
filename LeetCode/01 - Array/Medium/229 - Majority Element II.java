/**
 *
 * 229. Majority Element II
 *    Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ 
 *    times. The algorithm should run in linear time and in O(1) space.
 *    
 */
import java.util.*;

public class Solution {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		if (nums.length <= 0) {
			return result;
		}
		int candidate1 = -1, candidate2 = -1, count1 = 0, count2 = 0;
		
		for (int num : nums) {
			if (num == candidate1) {
				count1++;
			} else if (num == candidate2) {
				count2++;
			} else if (count1 == 0) {
				count1 = 1;
				candidate1 = num;
			} else if (count2 == 0) {
				count2 = 1;
				candidate2 = num;
			} else {
				count1--;
				count2--;
			}
		}
		
		count1 = 0;
		count2 = 0;
		
		for (int num : nums) {
			if (num == candidate1) {
				count1++;
			} else if (num == candidate2) {
				count2++;
			}
		}
		
		if (count1 > nums.length / 3) {
			result.add(candidate1);
		}
		
		if (count2 > nums.length / 3) {
			result.add(candidate2);
		}
		
		return result;
	}
}