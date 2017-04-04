/**
 *
 * 064. Minimum Path Sum
 *     Given a m x n grid filled with non-negative numbers, find a path from top left to 
 *     bottom right which minimizes the sum of all numbers along its path.
 *     
 *     Note: You can only move either down or right at any point in time.
 *     
 *
 */
import java.util.*;

public class Solution {
	public int minPathSum(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int[][] min = new int[grid.length][grid[0].length];
		return minPathSum(grid, min, 0, 0, grid.length, grid[0].length);
	}
	
	public int minPathSum(int[][] grid, int[][] min, int i, int j, int m, int n) {
		if (i == m || j == n) {
			return Integer.MAX_VALUE;
		} else if (i == m - 1 && j == n - 1) {
			return grid[i][j];
		} else if (min[i][j] != 0) {
		    return min[i][j];
		}
		int path1 = minPathSum(grid, min, i + 1, j, m, n);
		int path2 = minPathSum(grid, min, i, j + 1, m, n);
		if (path1 == path2 && path2 == Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		int val = path1 <= path2 ? path1 : path2;
		val += grid[i][j];
		min[i][j] = val;
		return val;
	}
}