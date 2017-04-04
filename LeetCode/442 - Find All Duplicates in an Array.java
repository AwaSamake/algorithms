/**
 *
 * 442. Find All Duplicates in an Array
 *     Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements 
 *     appear twice and others appear once.
 *     
 *     Find all the elements that appear twice in this array.
 *     
 *     Could you do it without extra space and in O(n) runtime?
 *     
 *     Example:
 *     Input:
 *     [4,3,2,7,8,2,3,1]
 *     
 *     Output:
 *     [2,3]
 *     
 *
 */
import java.util.*;

public class Solution {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> dups = new ArrayList<Integer>();
		int length = nums.length;
		for (int i = 0; i < nums.length; ++i) {
			int pos = (nums[i] + 1) % length;
			nums[pos] += nums.length;
		}
		
		int doubleLength = length * 2;
		int tripleLength = length * 3;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] >= doubleLength && nums[i] < tripleLength) {
				dups.add(i + 1);
			}
		}
		return dups;
	}
}