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

class Solution {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		for (int i = 0; i < k; ++i) {
			minHeap.add(nums[i]);
		}
		for (int i = k; i < nums.length; ++i) {
			if (nums[i] > minHeap.peek()) {
				minHeap.add(nums[i]);
				minHeap.poll();
			}
		}
		return minHeap.poll();
	}
}