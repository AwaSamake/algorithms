/**
 *
 * 231. Power of Two
 *     Given an integer, write a function to determine if it is a power of two.
 *
 */
import java.util.*;

public class Solution {
	public boolean isPowerOfTwo(int n) {
		if (n <= 0) {
			return false;
		}
		return (n & (n -1)) == 0;
	}
}