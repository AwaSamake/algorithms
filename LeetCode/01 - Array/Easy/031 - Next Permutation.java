/**
 *
 * 031. Next Permutation
 *     Implement next permutation, which rearranges numbers into the lexicographically 
 *     next greater permutation of numbers.
 *     
 *     If such arrangement is not possible, it must rearrange it as the lowest possible 
 *     order (ie, sorted in ascending order).
 *     
 *     The replacement must be in-place, do not allocate extra memory.
 *     
 *     Here are some examples. Inputs are in the left-hand column and its corresponding 
 *     outputs are in the right-hand column.
 *     1,2,3 → 1,3,2
 *     3,2,1 → 1,2,3
 *     1,1,5 → 1,5,1
 *
 */
import java.util.*;

public class Solution {
	public void nextPermutation(int[] nums) {
		for (int i = nums.length - 1; i > -1; --i) {
			System.out.println("i:" + i + " val:" + nums[i]);
			int smaller = findClosestSmaller(nums, i, nums[i]);
			System.out.println("smaller:" + smaller + " val:" + nums[smaller]);
			if (smaller != -1) {
				int temp = nums[i];
				nums[i] = nums[smaller];
				nums[smaller] = temp;
				return;
			}
		}
		Arrays.sort(nums);
	}
	
	public int findClosestSmaller(int nums[], int at, int val) {
		while (at > -1 && nums[at] > val) {
			--at;
		}
		return at;
	}
}