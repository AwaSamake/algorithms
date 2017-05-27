/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/two-sum-input-array-is-sorted
@Language: Java
@Datetime: 17-05-27 05:20
*/

public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[j] + nums[i] == target) {
                return new int[] {i + 1, j + 1};
            } else if (nums[j] + nums[i] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[] {0, 0};
    }
}