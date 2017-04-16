/**
 *
 * 442. Find All Duplicates in an Array
 *    Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *    
 *    Find all the elements that appear twice in this array.
 *    
 *    Could you do it without extra space and in O(n) runtime?
 *    
 *    Example:
 *    Input:
 *    [4,3,2,7,8,2,3,1]
 *    
 *    Output:
 *    [2,3]
 *
 */
import java.util.*;

public class Solution {
	public List<Integer> findDuplicates(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < nums.length; ++i) {
			int val = (nums[i] - 1) % n;
			nums[val] += n;
		}
		
		List<Integer> dups = new ArrayList<Integer>();
		int twoN = n * 2, threeN = n * 3;
		for (int i = 0; i < nums.length; ++i) {
			if (nums[i] > twoN && nums[i] <= threeN) {
				dups.add(i + 1);
			}
		}
		return dups;
	}
}