/**
 *
 * 059. Spiral Matrix II 
 *     Given an integer n, generate a square matrix filled with elements from 1 to n2 in 
 *     spiral order.
 *     
 *     For example,
 *     Given n = 3,
 *     
 *     You should return the following matrix:
 *     [
 *      [ 1, 2, 3 ],
 *      [ 8, 9, 4 ],
 *      [ 7, 6, 5 ]
 *     ]
 *
 */
import java.util.*;

public class Solution {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		if (n <= 0) {
			return matrix;
		}
		int counter = 1;
		int round = 0, left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
		while (up <= down || left <= right) {
			// from left to right of top
			for (int i = left; i <= right; ++i) {
				matrix[up][i] = counter++;
			}
			++up;
			if (up > down) {
				break;
			}
			// from up to down of right
			for (int i = up; i <= down; ++i) {
				matrix[i][right] = counter++;
			}
			--right;
			if (right < left) {
				break;
			}
			// from right to left of down
			for (int i = right; i >= left; --i) {
				matrix[down][i] = counter++;
			}
			--down;
			if (down < up) {
				break;
			}
			// from down to up of left
			for (int i = down; i >= up; --i) {
				matrix[i][left] = counter++;
			}
			++left;
			if (left > right) {
				break;
			}
		}
		return matrix;
	}
}