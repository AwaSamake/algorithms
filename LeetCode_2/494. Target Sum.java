public class Solution {
	public int findTargetSumWays(int[] nums, int S) {
		return findTargetSumWays(nums, S, 0, 0);
	}
	
	public int findTargetSumWays(int[] nums, int S, int sum, int index) {
		if (index == nums.length) {
			return sum == S ? 1 : 0;
		}
		
		int ways = 0;
		ways += findTargetSumWays(nums, S, sum + nums[index], index + 1);
		ways += findTargetSumWays(nums, S, sum - nums[index], index + 1);
		return ways;
	}
}