/**
 *
 *  048. Rotate Image
 *    You are given an n x n 2D matrix representing an image.
 *    
 *    Rotate the image by 90 degrees (clockwise).
 *    
 *    Follow up:
 *    Could you do this in-place?
 *
 */
import java.util.*;

public class Solution {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n < 1) {
			return;
		}
		for (int i = 0; i <= n / 2 ; ++i) {
			for (int j = i; j < n - i - 1; ++j) {
				transform(matrix, i, j);
			}
		}
	}
	
	public void transform(int[][] matrix, int r, int c) {
		int n = matrix.length - 1;
		int temp = matrix[r][c];
		matrix[r][c] = matrix[n - c][r];
		matrix[n - c][r] = matrix[n - r][n - c];
		matrix[n - r][n - c] = matrix[c][n - r];
		matrix[c][n - r] = temp;
	}
}