/**
 *
 * 062. Unique Paths
 *     A robot is located at the top-left corner of a m x n grid (marked 'Start' in the 
 *     diagram below).
 *     
 *     The robot can only move either down or right at any point in time. The robot is 
 *     trying to reach the bottom-right corner of the grid.
 *     
 *     How many possible unique paths are there?
 *     
 *     Above is a 3 x 7 grid. How many possible unique paths are there?
 *     
 *     Note: m and n will be at most 100.
 *
 */
import java.util.*;

public class Solution {
	public int uniquePaths(int m, int n) {		
		int[][] paths = new int[m+1][n+1];
		uniquePaths(paths, m, n);
		return paths[m][n];
	}
	
	public int uniquePaths(int[][] paths, int m, int n) {
		if (m < 1 || n < 1) {
			return 0;
		} else if (m == 1 || n == 1) {
		    paths[m][n] = 1;
			return 1;
		}
		if (paths[m][n] == 0) {
			paths[m][n] = uniquePaths(paths, m - 1, n) + uniquePaths(paths, m, n - 1);
		}
		return paths[m][n];
	}
}