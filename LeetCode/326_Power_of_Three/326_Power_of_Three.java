/**
 *
 *  326. Power of Three
 *    Given an integer, write a function to determine if it is a power of three.
 *    
 *    Follow up:
 *    Could you do it without using any loop / recursion?
 *
 */
import java.util.*;

public class Solution {
	public boolean isPowerOfThree(int n) {
		return (n > 0 && Math.pow(3, 19) % n == 0);
	}
}