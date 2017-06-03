/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 17-06-02 21:26
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        permute(nums, permutations, permutation, used);
        return permutations;
    }
    
    private void permute(int[] nums, List<List<Integer>> permutations, List<Integer> permutation, boolean[] used) {
        if (permutation.size() == nums.length) {
            permutations.add(new ArrayList<Integer>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!used[i]) {
                used[i] = true;
                permutation.add(nums[i]);
                permute(nums, permutations, permutation, used);
                permutation.remove(permutation.size() - 1);
                used[i] = false;
            }
        }
        
    }
}
