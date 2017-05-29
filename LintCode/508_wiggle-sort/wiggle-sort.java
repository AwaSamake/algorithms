/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/wiggle-sort
@Language: Java
@Datetime: 17-05-29 03:35
*/

public class Solution {
    /**
     * @param nums a list of integer
     * @return void
     */
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int i = 1, j = 2;
        
        while (j < nums.length) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i += 2;
            j += 2;
        }
    }
}