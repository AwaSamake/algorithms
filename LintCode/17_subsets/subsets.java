/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Java
@Datetime: 17-06-02 21:02
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> combination = new ArrayList<Integer>();
        subsets(nums, 0, combinations, combination);
        return combinations;
    }
    
    private void subsets(int[] nums, int index, ArrayList<ArrayList<Integer>> combinations, ArrayList<Integer> combination) {
        combinations.add(new ArrayList<Integer>(combination));
        for (int i = index; i < nums.length; ++i) {
            combination.add(nums[i]);
            subsets(nums, i + 1, combinations, combination);
            combination.remove(combination.size() - 1);
        }
    }
}