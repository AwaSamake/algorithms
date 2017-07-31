public class Solution {
	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		
		int[] amount = new int[nums.length];
		amount[0] = nums[0];
		amount[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; ++i) {
			amount[i] = Math.max(amount[i - 1], amount[i - 2] + nums[i]);
		}
		return Math.max(amount[amount.length - 1], amount[amount.length - 2]);
	}
}