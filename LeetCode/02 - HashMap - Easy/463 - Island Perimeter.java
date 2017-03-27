/**
 *
 * 463. Island Perimeter
 * You are given a map in form of a two-dimensional integer grid where 1 represents land 
 * and 0 represents water. Grid cells are connected horizontally/vertically (not 
 * diagonally). The grid is completely surrounded by water, and there is exactly one 
 * island (i.e., one or more connected land cells). The island doesn't have "lakes" (
 * water inside that isn't connected to the water around the island). One cell is a 
 * square with side length 1. The grid is rectangular, width and height don't exceed 100. 
 * Determine the perimeter of the island.
 * Example:
 *     [[0,1,0,0],
 *     [1,1,1,0],
 *     [0,1,0,0],
 *     [1,1,0,0]]
 * Answer: 
 *     16
 * Explanation:
 *     The perimeter is the 16 yellow stripes in the image below:
 *
 */
import java.util.*;

public class Solution {
	public int islandPerimeter(int[][] grid) {
		int land = 0;
		int neighbors = 0;
		for (int i = 0; i < grid.length; ++i) {
			for (int j = 0; j < grid[i].length; ++j) {
				if (grid[i][j] == 1) {
					land++;
					if (i + 1 < grid.length && grid[i + 1][j] == 1) {
						neighbors++;
					}
					if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
						neighbors++;
					}
				}
			}
		}
		return land * 4 - neighbors * 2;
	}
}