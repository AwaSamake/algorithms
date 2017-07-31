import java.util.*;

class Solution {
	public int subarraySum(int[] nums, int k) {
		int n = nums.length;
		int count = 0;
		int[] dp = new int[n];
		for (int i = 0; i < n; ++i) {
			dp[i] = nums[i];
			if (dp[i] == k) {
				count++;
			}
		}
		
		for (int i = 1; i < n; ++i) {
			dp[0][i] = dp[0][i - 1] + nums[i];
			if (dp[0][i] == k) {
				count++;
			}
		}
		
		for (int i = 1; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				dp[i][j] = dp[i][j - 1] + nums[j];
				if (dp[i][j] == k) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.subarraySum(new int[] {0,0,0,0,0,0,0,0,0,0}, 0));
	}
}