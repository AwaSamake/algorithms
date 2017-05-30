import java.util.*;

/**
 *
 * 16.21 Sum Swap
 *     Given two arrays of integers, find a pair of values (one value from each array) 
 *     that you can swap to give the two arrays the same sum.
 *
 */

class SumSwap {
	public static void findSwapValue(int[] array1, int[] array2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		int sum1 = 0;
		int sum2 = 0;
		
		for (int i : array1) {
			set1.add(i);
			sum1 += i;
		}
		for (int i : array2) {
			set2.add(i);
			sum2 += i;
		}
		
		int target = (sum1 - sum2) / 2;
		
		for (int i : set1) {
			if (set2.contains(i - target)) {
				System.out.println(i + " swap " + (i - target));
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array1 = new int[] {4, 1, 2, 1, 1, 2};
		int[] array2 = new int[] {3, 6, 3, 3};
		
		findSwapValue(array1, array2);
	}
}