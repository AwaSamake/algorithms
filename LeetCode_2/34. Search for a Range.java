import java.util.*;

class Solution {
	public int[] searchRange(int[] nums, int target) {
		int left = -1;
		int right = -1;
		
		int lower = 0;
		int upper = nums.length - 1;
		int mid;
		while (lower <= upper) {
			mid = lower + ((upper - lower) >> 1);
			if (nums[mid] == target) {
				upper = mid - 1;
				left = mid;
			} else if (nums[mid] > target) {
				upper = mid - 1;
			} else {
				lower = mid + 1;
			}
		}
		
		lower = 0;
		upper = nums.length - 1;
		while (lower <= upper) {
			mid = lower + ((upper - lower) >> 1);
			if (nums[mid] == target) {
				lower = mid + 1;
				right = mid;
			} else if (nums[mid] > target) {
				upper = mid - 1;
			} else {
				lower = mid + 1;
			}
		}
		return new int[] { left, right };
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(Arrays.toString(s.searchRange(new int[] {}, 9)));
	}
}