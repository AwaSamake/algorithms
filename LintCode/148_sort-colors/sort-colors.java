/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/sort-colors
@Language: Java
@Datetime: 17-06-09 22:51
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        int[] counts = new int[3];
        for (int num : nums) {
            counts[num]++;
        }
        int index = 0;
        int color = 0;
        for (int count: counts) {
            while (count != 0) {
                nums[index++] = color;
                count--;
            }
            color++;
        }
    }
}