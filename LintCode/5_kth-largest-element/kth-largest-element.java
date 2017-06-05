/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/kth-largest-element
@Language: Java
@Datetime: 17-06-05 05:01
*/

class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
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
};