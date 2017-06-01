import java.util.*;

class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI2(int[] nums, int target) {
        int[] bestCases = new int[target + 1];
        bestCases[0] = 1;
        // for all possible bag sizes
        for (int bagSize = 1; bagSize <= target; ++bagSize) {
            for (int num: nums) {
                // if item size is smaller than current bag size
                // that means we have more ways to fill backpack
                if (num <= bagSize) {
                    // new number of ways = 0 + all possible one item less combinations
                    // bestCase[bagSize - size[0]] + bestCase[bagSize - size[1]] + bestCase[bagSize - size[i]]
                    bestCases[bagSize] += bestCases[bagSize - num];
                }
            }
        }
        return bestCases[target];
    }
}