/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/3sum-closest
@Language: Java
@Datetime: 17-06-10 01:10
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
		int min = Integer.MAX_VALUE;
		int minSum = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; ++i) {
		    int j = i + 1;
		    int k = nums.length - 1;
		    while (j < k) {
		        int sum = nums[i] + nums[j] + nums[k];
		        int abs = Math.abs(sum - target);
		        if (min > abs) {
		            minSum = sum;
		            min = abs;
		        }
		        
		        if (sum < target) {
		            j++;
		        } else {
		            k--;
		        }
		    }
		}
		return minSum;
	}
}
