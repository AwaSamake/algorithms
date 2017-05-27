/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/partition-equal-subset-sum
@Language: Java
@Datetime: 17-05-27 00:13
*/

public class Solution {
    /**
     * @param nums a non-empty array only positive integers
     * @return return true if can partition or false
     */
    public boolean canPartition(int[] nums) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        return canPartition(nums, 0, 0, 0, sum / 2);
    }
    
    public boolean canPartition(int[] nums, int index, int group1, int group2, long max) {
        if (group1 > max || group2 > max) {
            return false;
        }
        if (index >= nums.length) {
            return group1 == group2;
        }
        
        return canPartition(nums, index + 1, group1 + nums[index], group2, max) 
            || canPartition(nums, index + 1, group1, group2 + nums[index], max);
    }
}