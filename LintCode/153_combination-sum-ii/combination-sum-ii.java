/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 17-06-02 22:33
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> combinations = new ArrayList<>();
        combinationSum2(nums, 0, target, combinations, new ArrayList<Integer>());
        return combinations;
    }
    
    public void combinationSum2(int[] nums, int index, int target, List<List<Integer>> combinations, List<Integer> combination) {
        Arrays.sort(nums);
        if (target < 0) {
            return;
        }
        if (target == 0) {
            combinations.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = index; i < nums.length; ++i) {
            combination.add(nums[i]);
            combinationSum2(nums, i + 1, target - nums[i], combinations, combination);
            combination.remove(combination.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
    }
}