/**
 *
 *  137. Single Number II
 *    Given an array of integers, every element appears three times except 
 *    for one, which appears exactly once. Find that single one.
 *
 */
import java.util.*;

public class Solution {
	public int singleNumber(int[] nums) {
		int bit1 = 0, bit2 = 0;
		for (int num : nums) {
			bit1 = (num ^ bit1) & ~bit2;
			bit2 = (num ^ bit2) & ~bit1;
		}
		return bit1;
	}
}