/**
 *
 * 060. Permutation Sequence
 *    The set [1,2,3,…,n] contains a total of n! unique permutations.
 *
 *    By listing and labeling all of the permutations in order,
 *    We get the following sequence (ie, for n = 3):
 *
 *    "123"
 *    "132"
 *    "213"
 *    "231"
 *    "312"
 *    "321"
 *    Given n and k, return the kth permutation sequence.
 *
 *    Note: Given n will be between 1 and 9 inclusive.
 *
 */

import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        int[] factorials = new int[n + 1];
        factorials[0] = 1;
        for (int i = 1; i <= n; ++i) {
            factorials[i] = factorials[i - 1] * i;
        }

        List<Character> chars = new LinkedList<Character>();
        for (int i = 1; i < 10; ++i) {
            chars.add((char)(i + '0'));
        }
        k--;
        StringBuilder sb = new StringBuilder(k);
        for (int i = 0; i < n; ++i) {
            int index = k / factorials[n - i - 1];
            k %= factorials[n - i - 1];
            char digit = chars.remove(index);
            sb.append(digit);
        }
        return sb.toString();
    }
}