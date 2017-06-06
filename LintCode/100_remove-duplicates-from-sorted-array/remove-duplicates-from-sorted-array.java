/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array
@Language: Java
@Datetime: 17-06-06 22:06
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] > nums[i]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}