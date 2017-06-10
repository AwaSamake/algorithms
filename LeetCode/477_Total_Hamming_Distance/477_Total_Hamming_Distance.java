/**
 *
 *  477. Total Hamming Distance
 *    The Hamming distance between two integers is the number of positions at which the 
 *    corresponding bits are different.
 *    
 *    Now your job is to find the total Hamming distance between all pairs of the given 
 *    numbers.
 *    
 *    Example:
 *    Input: 4, 14, 2
 *    
 *    Output: 6
 *    
 *    Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 
 *    (just showing the four bits relevant in this case). So the answer will be:
 *    HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 
 *    2 = 6.
 *    Note:
 *    Elements of the given array are in the range of 0 to 10^9
 *    Length of the array will not exceed 10^4.
 *    
 */
import java.util.*;

public class Solution {
	public int totalHammingDistance(int[] nums) {
		int totalDistance = 0;
		for (int i = 0; i < Integer.BYTES * 8; ++i) {
			int ones = countOnes(nums, i);
			totalDistance += ones * (nums.length - ones);
		}
		return totalDistance;
	}
	
	public int countOnes(int[] nums, int index) {
		int count = 0;
		for (int num: nums) {
			count += (num >> index) & 1;
		}
		return count;
	}
}

public class NaiveSolution {
	public int totalHammingDistance(int[] nums) {
		int totalDistance = 0;
		for (int i = 0; i < nums.length - 1; ++i) {
			for (int j = i + 1; j < nums.length; ++j) {
				totalDistance += hummingDistance(nums[i], nums[j]);
			}
		}
		return totalDistance;
	}
	
	public int hummingDistance(int x, int y) {
		int diff = x ^ y;
		int count = 0;
		while (diff != 0) {
			if ((diff & 1) == 1) {
				count++;
			}
			diff >>= 1;
		}
		return count;
	}
}