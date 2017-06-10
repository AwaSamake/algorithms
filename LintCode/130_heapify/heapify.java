/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/heapify
@Language: Java
@Datetime: 17-06-09 23:37
*/

public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            heapifyUp(nums, i);
        }
    }
    
    private void heapifyUp(int[] nums, int index) {
        int parent = parentOf(index);
        while (parent > -1 && nums[parent] > nums[index]) {
            int temp = nums[index];
            nums[index] = nums[parent];
            nums[parent] = temp;
            index = parent;
            parent = parentOf(index);
        }
    }
    
    private int parentOf(int index) {
        return (index - 1) >> 1;
    }
}