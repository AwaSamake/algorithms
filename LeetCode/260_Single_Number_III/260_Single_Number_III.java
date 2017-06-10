/**
 *
 * 260. Single Number III
 *     Given an array of numbers nums, in which exactly two elements appear only once and 
 *     all the other elements appear exactly twice. Find the two elements that appear 
 *     only once.
 *     
 *     For example:
 *     
 *     Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 *     
 *     Note:
 *     The order of the result is not important. So in the above example, [5, 3] is also 
 *     correct.
 *     Your algorithm should run in linear runtime complexity. Could you implement it 
 *     using only constant space complexity?
 *     
 *
 */
import java.util.*;

public class Solution {
    public int[] singleNumber(int[] nums) {
		int xor = 0;
		for (int a : nums) {
			xor ^= a;
		}
		int lastBit = xor - (xor & (xor - 1));
		int one = 0;
		int two = 0;
		for (int a : nums) {
			if ((a & lastBit) == 0) {
				one ^= a;
			} else {
				two ^= a;
			}
		}
		return new int[] { one, two };
	}
}