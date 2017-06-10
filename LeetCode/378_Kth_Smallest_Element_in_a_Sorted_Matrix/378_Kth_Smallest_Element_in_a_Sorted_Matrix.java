/**
 *
 * 378. Kth Smallest Element in a Sorted Matrix
 *     Given a n x n matrix where each of the rows and columns are sorted in ascending 
 *     order, find the kth smallest element in the matrix.
 *     
 *     Note that it is the kth smallest element in the sorted order, not the kth distinct 
 *     element.
 *     
 *     Example:
 *     
 *     matrix = [
 *        [ 1,  5,  9],
 *        [10, 11, 13],
 *        [12, 13, 15]
 *     ],
 *     k = 8,
 *     
 *     return 13.
 *     Note: 
 *     You may assume k is always valid, 1 ≤ k ≤ n2.
 *
 */
import java.util.*;

class Solution {
	public int kthSmallest(int[][] matrix, int k) {
		if (matrix.length < 1) {
			return -1;
		}
		
		int[] indexs = new int[matrix.length];
		while (k-- > 1) {
			nextMin(matrix, indexs);
		}
		return nextMin(matrix, indexs);
	}
	
	private int nextMin(int[][] matrix, int[] indexs) {
		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		int length = matrix[0].length;
		for (int i = 0; i < matrix.length; ++i) {
			if (indexs[i] < length && matrix[i][indexs[i]] < min) {
				minIndex = i;
				min = matrix[i][indexs[i]];
			}
		}
		System.out.println(matrix[minIndex][indexs[minIndex]] + " is smallest.");
		indexs[minIndex]++;
		return matrix[minIndex][indexs[minIndex] - 1];
	}
}