/**
 *
 * 525. Contiguous Array
 *    Given a binary array, find the maximum length of a contiguous subarray with equal 
 *    number of 0 and 1.
 *    
 *    Example 1:
 *    Input: [0,1]
 *    Output: 2
 *    Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *    Example 2:
 *    Input: [0,1,0]
 *    Output: 2
 *    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number 
 *    of 0 and 1.
 *    Note: The length of the given binary array will not exceed 50,000.
 *
 */
import java.util.*;

public class Solution {
	public int findMaxLength(int[] nums) {
		int[] counts = new int[nums.length + 1];
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] == 1) {
				counts[i + 1] = counts[i] + 1;
			} else {
				counts[i + 1] = counts[i] - 1;
			}
		}
		
		HashMap<Integer, Integer> posMap = new HashMap<Integer, Integer>();
		int length = 0;
		for (int i = 0; i < counts.length; ++i) {
			if (posMap.containsKey(counts[i])) {
				int pos = posMap.get(counts[i]);
				length = Math.max(length, i - pos);
			} else {
				posMap.put(counts[i], i);
			}
		}
		return length;
	}
}