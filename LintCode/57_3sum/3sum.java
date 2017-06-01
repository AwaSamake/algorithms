/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Java
@Datetime: 17-05-31 21:25
*/

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
        int i = 0;
        while (i < nums.length - 2 && nums[i] <= 0) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k && nums[k] >= 0) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ArrayList<Integer> combination = new ArrayList<>();
                    combination.add(nums[i]);
                    combination.add(nums[j]);
                    combination.add(nums[k]);
                    combinations.add(combination);
                    j = increment(nums, j);
                    k = decrement(nums, k);
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j = increment(nums, j);
                } else {
                    k = decrement(nums, k);
                }
            }
            i = increment(nums, i);
        }
        return combinations;
    }
    
    private int increment(int[] nums, int index) {
        while (index < nums.length - 1 && nums[index] == nums[index+1]) {
            index++;
        }
        return ++index;
    }
    
    private int decrement(int[] nums, int index) {
        while (index > 0 && nums[index] == nums[index-1]) {
            index--;
        }
        return --index;
    }
}