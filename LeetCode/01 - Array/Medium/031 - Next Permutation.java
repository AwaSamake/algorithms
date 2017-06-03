/**
 *
 * 031. Next Permutation
 *    Implement next permutation, which rearranges numbers into the lexicographically
 *    next greater permutation of numbers.
 *
 *    If such arrangement is not possible, it must rearrange it as the lowest possible
 *    order (ie, sorted in ascending order).
 *
 *    The replacement must be in-place, do not allocate extra memory.
 *
 *    Here are some examples. Inputs are in the left-hand column and its corresponding
 *    outputs are in the right-hand column.
 *    1,2,3 → 1,3,2
 *    3,2,1 → 1,2,3
 *    1,1,5 → 1,5,1
 *
 */

import java.util.*;

public class Solution {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i - 1] < nums[i]) {
                int min = nums[i];
                int pos = i;
                for (int j = i + 1; j < nums.length; ++j) {
                    if (nums[j] > nums[i - 1] && nums[j] <= min) {
                        min = nums[j];
                        pos = j;
                    }
                }
                swap(nums, pos, i - 1);
                reverse(nums, i);
                return;
            }
        }
        reverse(nums, 0);
    }

    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}