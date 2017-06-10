/**
 *
 *  384. Shuffle an Array
 *    Shuffle a set of numbers without duplicates.
 *    
 *    Example:
 *    
 *    // Init an array with set 1, 2, and 3.
 *    int[] nums = {1,2,3};
 *    Solution solution = new Solution(nums);
 *    
 *    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must 
 *    equally likely to be returned.
 *    solution.shuffle();
 *    
 *    // Resets the array back to its original configuration [1,2,3].
 *    solution.reset();
 *    
 *    // Returns the random shuffling of array [1,2,3].
 *    solution.shuffle();
 *
 */
import java.util.*;

public class Solution {
	int length;
	int[] original, shuffled;
	Random rand = new Random();
	public Solution(int[] nums) {
		length = nums.length;
		original = nums;
		shuffled = Arrays.copyOf(original, length);
	}
	
	/** Resets the array to its original configuration and return it. */
	public int[] reset() {
		return original;
	}
	
	/** Returns a random shuffling of the array. */
	public int[] shuffle() {
		for (int i = 0; i < length - 1; ++i) {
			randomSwap(shuffled, i);
		}
		return shuffled;
	}
	
	private void randomSwap(int[] shuffled, int index) {
		int index2 = rand.nextInt(length - index) + index;
		int temp = shuffled[index];
		shuffled[index] = shuffled[index2];
		shuffled[index2] = temp;
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */