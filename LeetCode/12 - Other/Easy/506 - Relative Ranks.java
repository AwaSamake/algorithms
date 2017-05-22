/**
 *
 *  506. Relative Ranks
 *    Given scores of N athletes, find their relative ranks and the people with the top 
 *    three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and 
 *    "Bronze Medal".
 *    
 *    Example 1:
 *    Input: [5, 4, 3, 2, 1]
 *    Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 *    Explanation: The first three athletes got the top three highest scores, so they 
 *    got "Gold Medal", "Silver Medal" and "Bronze Medal". 
 *    For the left two athletes, you just need to output their relative ranks according 
 *    to their scores.
 *    Note:
 *    N is a positive integer and won't exceed 10,000.
 *    All the scores of athletes are guaranteed to be unique.
 *
 */
import java.util.*;

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        Arrays.sort(nums);
        String[] awardeds = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
        result[map.get(nums[nums.length - 1])] = "Gold Medal";
        if (nums.length == 1) {
            return result;
        }
        result[map.get(nums[nums.length - 2])] = "Silver Medal";
        if (nums.length == 2) {
            return result;
        }
        result[map.get(nums[nums.length - 3])] = "Bronze Medal";
        if (nums.length == 3) {
            return result;
        }
        int rank = 4;
        for(int i = nums.length - 4; i >= 0; --i) {
            result[map.get(nums[i])] = String.valueOf(rank++);
        }
        return result;
    }
}