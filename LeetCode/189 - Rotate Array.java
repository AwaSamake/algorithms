/**
 *
 * 189 Rotate Array
 * Rotate an array of n elements to the right by k steps. For example, with n = 7 and 
 * k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]. 
 * Note: 
 *     Try to come up as many solutions as you can, there are at least 3 different ways 
 *     to solve this problem.
 *
 */ 
import java.util.*;

public class Solution {
	public void rotate(int[] nums, int k) {
		int length = nums.length;
		int[] copy = Arrays.copyOf(nums, length);
		for (int i = 0; i < length; ++i) {
			nums[i] = copy[(i + k) % length];
		}
	}
}

public class Solution {
	public void rotate(int[] nums, int k) {
		int length = nums.length;
		k = k % length;
		
		reverse(nums, 0, length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, length - 1);
		
	}
	
	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start++, end--);
		}
	}
	
	public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}