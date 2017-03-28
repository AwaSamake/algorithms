/**
 *
 * 070. Climbing Stairs
 *     You are climbing a stair case. It takes n steps to reach to the top. 
 *     Each time you can either climb 1 or 2 steps. In how many distinct ways can you 
 *     climb to the top? 
 *     Note: 
 *         Given n will be a positive integer.
 *
 */
import java.util.*;

public class Solution {
	public int climbStairs(int n) {
		int[] steps = new int[n+1];
		return climbStairs(steps, n);
	}
	
	public int climbStairs(int[] steps, int n) {
	    if (n > -1 && steps[n] > 0) {
	        return steps[n];
	    }
		if (n < 0) {
			return 0;
		} else if (n == 0) {
		    return 1;
		} else {
		    steps[n] = climbStairs(steps, n - 1) + climbStairs(steps, n - 2);
		    return steps[n];
		}
	}
}