/**
 *
 * 073. Set Matrix Zeroes
 *     Given a m x n matrix, if an element is 0, set its entire row and column to 0. 
 *     Do it in place.
 *     
 *     click to show follow up.
 *     
 *     Follow up:
 *     Did you use extra space?
 *     A straight forward solution using O(mn) space is probably a bad idea.
 *     A simple improvement uses O(m + n) space, but still not the best solution.
 *     Could you devise a constant space solution?
 *
 */
import java.util.*;

public class Solution {
	public void setZeroes(int[][] matrix) {
		boolean rowZero = false, colZero = false;
	    for (int i = 0; i < matrix.length; ++i) {
			if (matrix[i][0] == 0) {
				colZero = true;
			}
		}
	    for (int i = 0; i < matrix[0].length; ++i) {
			if (matrix[0][i] == 0) {
				rowZero = true;
			}
		}
	    
		for (int i = 1; i < matrix.length; ++i) {
			for (int j = 1; j < matrix[i].length; ++j) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int r = 1; r < matrix.length; ++r) {
			if (matrix[r][0] == 0) {
				setRowZeroes(matrix, r);
			}
		}
		for (int c = 1; c < matrix[0].length; ++c) {
			if (matrix[0][c] == 0) {
				setColZeroes(matrix, c);
			}
		}
		if (rowZero) {
			setRowZeroes(matrix, 0);
		}
		if (colZero) {
			setColZeroes(matrix, 0);
		}
		
	}
	
	public void setRowZeroes(int[][] matrix, int row) {
		for (int i = 0; i < matrix[row].length; ++i) {
			matrix[row][i] = 0;
		}
	}
	
	public void setColZeroes(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; ++i) {
			matrix[i][col] = 0;
		}
	}
}