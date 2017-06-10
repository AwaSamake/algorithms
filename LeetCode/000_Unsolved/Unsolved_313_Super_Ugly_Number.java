/**
 *
 * 313. Super Ugly Number
 *    Write a program to find the nth super ugly number.
 *    
 *    Super ugly numbers are positive numbers whose all prime factors are in the given 
 *    prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 
 *    32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 
 *    19] of size 4.
 *    
 *    Note:
 *    (1) 1 is a super ugly number for any given primes.
 *    (2) The given numbers in primes are in ascending order.
 *    (3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 *    (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 *
 */
import java.util.*;

public class Solution {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int[] nums = new int[primes.length];
		int min = 1;
		while (n-- > 1) {
			multiply(min, primes, nums);
			min = getMin(nums);
		}
		return min;
	}
	
	private void multiply(int min, int[] primes, int[] nums) {
		for (int i = 0; i < primes.length; ++i) {
			nums[i] = Math.min(min * primes[i], nums[i]);
		}
	}
	
	private int getMin(int[] nums) {
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			if (num > 1 && num < min) {
				min = num;
			}
		}
		return min;
	}

}