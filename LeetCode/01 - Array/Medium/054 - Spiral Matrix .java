/**
 *
 * 054. Spiral Matrix 
 *     Given a matrix of m x n elements (m rows, n columns), return all elements of the 
 *     matrix in spiral order.
 *     
 *     For example,
 *     Given the following matrix:
 *     
 *     [
 *      [ 1, 2, 3 ],
 *      [ 4, 5, 6 ],
 *      [ 7, 8, 9 ]
 *     ]
 *     You should return [1,2,3,6,9,8,7,4,5].
 *
 */
import java.util.*;

class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix.length < 1 || matrix[0].length < 1) {
			return result;
		}
		int round = 0, left = 0, right = matrix[0].length - 1, up = 0, down = matrix.length - 1;
		while (up <= down || left <= right) {
			// from left to right of top
			for (int i = left; i <= right; ++i) {
				result.add(matrix[up][i]);
			}
			++up;
			if (up > down) {
				break;
			}
			// from up to down of right
			for (int i = up; i <= down; ++i) {
				result.add(matrix[i][right]);
			}
			--right;
			if (right < left) {
				break;
			}
			// from right to left of down
			for (int i = right; i >= left; --i) {
				result.add(matrix[down][i]);
			}
			--down;
			if (down < up) {
				break;
			}
			// from down to up of left
			for (int i = down; i >= up; --i) {
				result.add(matrix[i][left]);
			}
			++left;
			if (left > right) {
				break;
			}
		}
		return result;
	}
}