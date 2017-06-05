/**
 *
 * 215. Kth Largest Element in an Array
 *    Find the kth largest element in an unsorted array. Note that it is the kth largest 
 *    element in the sorted order, not the kth distinct element.
 *    
 *    For example,
 *    Given [3,2,1,5,6,4] and k = 2, return 5.
 *    
 *    Note: 
 *    You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 */
import java.util.*;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return kthLargestElement(k, nums, 0, nums.length - 1);
    }
	
	public int kthLargestElement(int k, int[] nums, int i, int j) {
		if (i > j) {
			return -1;
		}
		int pivot = partition(nums, i, j);
		if (pivot + 1 == k) {
			return nums[pivot];
		} else if (pivot + 1 < k) {
			return kthLargestElement(k, nums, pivot + 1, j);
		} else {
			return kthLargestElement(k, nums, i, pivot - 1);
		}
	}
	
	public int partition(int[] nums, int l, int r) {
		int left = l, right = r;
		int pivot = nums[left];
		
		while (left < right) {
			while (left < right && nums[right] <= pivot) {
				right--;
			}
			nums[left] = nums[right];
			while (left < right && nums[left] >= pivot) {
				left++;
			}
			nums[right] = nums[left];
		}
		
		nums[left] = pivot;
		return left;         
	}
}