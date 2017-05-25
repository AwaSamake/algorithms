/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/partition-array
@Language: Java
@Datetime: 17-05-24 21:57
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    int i = 0;
	    int j = nums.length - 1;
	    while (i <= j) {
	        // check if the index is out of bound
	        while (i < nums.length && nums[i] < k) {
	            ++i;
	        }
	        // check if the index is out of bound
	        while (j >= 0 && nums[j] >= k) {
	            --j;
	        }
	        if (i > j) {
	            return i;
	        }
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	    return i;
    }
}