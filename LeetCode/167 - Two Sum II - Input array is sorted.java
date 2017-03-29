/**
 *
 * 167 Two Sum II - Input array is sorted
 * Given an array of integers that is already sorted in ascending order, find two numbers 
 * such that they add up to a specific target number. The function twoSum should return 
 * indices of the two numbers such that they add up to the target, where index1 must be 
 * less than index2. Please note that your returned answers (both index1 and index2) are 
 * not zero-based. You may assume that each input would have exactly one solution and you 
 * may not use the same element twice. 
 * Input: numbers={2, 7, 11, 15}, target=9 
 * Output: index1=1, index2=2
 *
 */ 

import java.util.*;

public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; ++i) {
			int wanted = target - numbers[i];
			int lower = i + 1, upper = numbers.length - 1;
			int mid = 0;
			
			while (lower <= upper) {
				mid = (lower + upper) >> 1;
				if (numbers[mid] == wanted) {
					result[0] = i + 1;
					result[1] = mid + 1;
					return result;
				} else if (numbers[mid] < wanted) {
					lower = mid + 1;
				} else {
					upper = mid - 1;
				}
			}
		}
		return result;
	}
}