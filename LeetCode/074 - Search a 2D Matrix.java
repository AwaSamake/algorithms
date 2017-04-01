/**
 *
 * 074. Search a 2D Matrix
 *    Write an efficient algorithm that searches for a value in an m x n matrix. This 
 *    matrix has the following properties:
 *    
 *    Integers in each row are sorted from left to right.
 *    The first integer of each row is greater than the last integer of the previous row.
 *    For example,
 *    
 *    Consider the following matrix:
 *    
 *    [
 *      [1,   3,  5,  7],
 *      [10, 11, 16, 20],
 *      [23, 30, 34, 50]
 *    ]
 *    Given target = 3, return true.
 *
 */
import java.util.*;

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length < 1 || matrix[0].length < 1) {
			return false;
		}
		
		int numPerRow = matrix.length, numPerCol = matrix[0].length;
		int low = 0, high = numPerRow * numPerCol - 1;
		
		while (low <= high) {
			int mid = (low + high) / 2;
			int row = mid / numPerCol;
			int col = mid % numPerCol;
			if (matrix[row][col] == target) {
				return true;
			} else if (matrix[row][col] < target) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return false;
	}
}

public class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length < 1) {
			return false;
		}
		for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0;) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] < target) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}