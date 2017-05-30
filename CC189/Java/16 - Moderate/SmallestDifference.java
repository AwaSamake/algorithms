/**
 *
 * 16.6 Smallest Difference
 *     Given two arrays of integers, compute the pair of values (one value in each array)
 *     with the smallest (non-negative) difference. Return the difference.
 *
 */
import java.util.*;

class SmallestDifference {
	public static int findSmallestDifference(int[] array1, int[] array2) {
		Arrays.sort(array1);
		Arrays.sort(array2);
		
		int index1 = 0, index2 = 0, diff = Integer.MAX_VALUE;
		while (index1 < array1.length && index2 < array2.length) {
			diff = Math.min(diff, Math.abs(array2[index2] - array1[index1]));
			if (array1[index1] > array2[index2]) {
				index2++;
			} else {
				index1++;
			}
		}
		return diff;
	}
	
	public static void main(String[] args) {
		int[] array1 = new int[] {1, 2, 11, 15};
		int[] array2 = new int[] {4, 12, 19, 127, 235};
		
		System.out.println(findSmallestDifference(array1, array2));
		
	}
}