/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/recover-rotated-sorted-array
@Language: Java
@Datetime: 17-05-31 05:25
*/

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if (nums.size() < 2 || nums.get(0) < nums.get(nums.size() - 1)) {
            return;
        }
        
        for (int i = 1; i < nums.size(); ++i) {
            if (nums.get(i - 1) > nums.get(i)) {
                reverse(nums, 0, i - 1);
                reverse(nums, i, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                return;
            }
        }
    }
    
    private void reverse(ArrayList<Integer> nums, int begin, int end) {
        while (begin < end) {
            swap(nums, begin++, end--);
        }
    }
    
    private void swap(ArrayList<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}