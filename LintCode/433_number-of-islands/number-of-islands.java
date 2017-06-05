/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/number-of-islands
@Language: Java
@Datetime: 17-06-05 05:19
*/

public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int numIslands(boolean[][] grid) {
		int m = grid.length;
		if (m < 1) {
		    return 0;
		}
		int n = grid[0].length;
		if (n < 1) {
		    return 0;
		}
		boolean[][] visited = new boolean[m][n];
		int islands = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (grid[i][j] && !visited[i][j]) {
					islands++;
					visitIsland(grid, visited, i, j);
				}
			}
		}
		return islands;
	}
	
	public void visitIsland(boolean[][] grid, boolean[][] visited, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || !grid[i][j] || visited[i][j]) {
			return;
		}
		visited[i][j] = true;
		visitIsland(grid, visited, i + 1, j    );
		visitIsland(grid, visited, i - 1, j    );
		visitIsland(grid, visited, i    , j + 1);
		visitIsland(grid, visited, i    , j - 1);
	}
}