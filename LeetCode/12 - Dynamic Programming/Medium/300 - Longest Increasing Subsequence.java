/**
 *
 * 300. Longest Increasing Subsequence
 *    Given an unsorted array of integers, find the length of longest increasing
 *    subsequence.
 *
 *    For example,
 *    Given [10, 9, 2, 5, 3, 7, 101, 18],
 *    The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 *    Note that there may be more than one LIS combination, it is only necessary for you
 *    to return the length.
 *
 *    Your algorithm should run in O(n2) complexity.
 *
 *    Follow up: Could you improve it to O(n log n) time complexity?
 *
 */

import java.util.*;

public class Solution {
    public int lengthOfLIS(int[] A) {
        if (A.length < 1) {
            return 0;
        }
        int[] counts = new int[A.length];
        int max = 1;
        counts[0] = 1;
        for (int i = 1; i < A.length; ++i) {
            counts[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (A[i] > A[j]) {
                    if (counts[j] + 1 > counts[i]) {
                        counts[i] = counts[j] + 1;
                        if (counts[i] > max) {
                            max = counts[i];
                        }
                    }
                }
            }
        }
        return max;
    }
}