/**
 *
 * 8.3 Magic Index
 *     A magic index in an array A[1...n-1] is defined to be an index such that A[i] = i.
 *     Given a sorted array of distinct integers, write a method to find a magic index,
 *     if one exits, in array A.
 *     FOLLOW UP
 *     What if the values are not distinct?
 *
 */
import java.util.*;

class MagicIndex {
	/**
	 * Slow solution
	 */
	public static int findMagicIndex1(int[] numbers) {
		int index = 0;
		while (index < numbers.length && numbers[index] != index) {
			index = Math.max(index, numbers[index]) + 1;
		}
		if (index < numbers.length) {
			return index;
		}
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] numbers = new int[] {-40, -20, 1, 1, 2, 3, 5, 7, 9, 12, 13};
		
		System.out.println(findMagicIndex(numbers));
	}
}