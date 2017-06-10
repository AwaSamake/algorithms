/**
 *
 * 046. Permutations
 *    Given a collection of distinct numbers, return all possible permutations.
 *
 *    For example,
 *    [1,2,3] have the following permutations:
 *    [
 *      [1,2,3],
 *      [1,3,2],
 *      [2,1,3],
 *      [2,3,1],
 *      [3,1,2],
 *      [3,2,1]
 *    ]
 *
 */

import java.util.*;

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