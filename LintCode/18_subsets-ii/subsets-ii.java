/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 17-06-02 21:13
*/

class Solution {
    /**
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> combination = new ArrayList<Integer>();
        subsetsWithDup(nums, 0, combinations, combination);
        return combinations;
    }
    
    private void subsetsWithDup(int[] nums, int index, ArrayList<ArrayList<Integer>> combinations, ArrayList<Integer> combination) {
        combinations.add(new ArrayList<Integer>(combination));
        for (int i = index; i < nums.length; i = increment(nums, i)) {
            combination.add(nums[i]);
            subsetsWithDup(nums, i + 1, combinations, combination);
            combination.remove(combination.size() - 1);
        }
        
    }
    
    private int increment(int[] nums, int i) {
        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            ++i;
        }
        return i + 1;
    }
}
