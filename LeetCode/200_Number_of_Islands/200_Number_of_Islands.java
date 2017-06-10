/**
 *
 *  200. Number of Islands
 *    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 *    An island is surrounded by water and is formed by connecting adjacent lands 
 *    horizontally or vertically. You may assume all four edges of the grid are all 
 *    surrounded by water.
 *    
 *    Example 1:
 *    
 *    11110
 *    11010
 *    11000
 *    00000
 *    Answer: 1
 *    
 *    Example 2:
 *    
 *    11000
 *    11000
 *    00100
 *    00011
 *    Answer: 3
 *
 */
import java.util.*;

public class Solution {
	public int numIslands(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int islands = 0;
		for (int r = 0; r < grid.length; ++r) {
			for (int c = 0; c < grid[0].length; ++c) {
				if (grid[r][c] == '1' && !visited[r][c]) {
					islands++;
					check(grid, visited, r, c);
				}
			}
		}
		return islands;
	}
	
	public void check(char[][] grid, boolean[][] visited, int r, int c) {
		if (r < 0 || c < 0 
			|| r >= grid.length || c >= grid[r].length 
			|| grid[r][c] == '0' || visited[r][c]) {
			return;
		}
		visited[r][c] = true;
		check(grid, visited, r + 1, c);
		check(grid, visited, r, c + 1);
		check(grid, visited, r - 1, c);
		check(grid, visited, r, c - 1);
	}
}