/**
 *
 * 8.1 Triple Step
 *     A child is running up a staircase with n steps and can hop either 1 step, 2 steps,
 *     or 3 steps at a time. Implement a method to count how many method to count how many 
 *     possible ways the child can run up the stairs.
 *
 */
import java.util.*;

class TripleStep {
	/**
	 * Recursion, Brute Force
	 */
	static int counter1 = 0;
	public static int countWays(int steps) {
		counter1++;
		if (steps < 0) {
			return 0;
		}
		if (steps == 0) {
			return 1;
		}

		return countWays(steps - 1) + countWays(steps - 2) + countWays(steps - 3);
	}
	
	/**
	 * Memoization
	 */
	static int counter2 = 0;
	public static int countWays(int steps, int[] counts) {
		counter2++;
		if (steps < 0) {
			return 0;
		} else if (steps == 0) {
			return 1;
		} else if (counts[steps] > -1) {
			return counts[steps];
		} else {
			counts[steps] = countWays(steps - 1, counts) 
							+ countWays(steps - 2, counts) 
							+ countWays(steps - 3, counts);
			return counts[steps];
		}
	}
	
	public static void main(String[] args) {
		System.out.println(countWays(6));
		System.out.println(counter1);
		
		int[] counts = new int[7];
		Arrays.fill(counts, -1);
		System.out.println(countWays(6, counts));
		System.out.println(counter2);
	}
}