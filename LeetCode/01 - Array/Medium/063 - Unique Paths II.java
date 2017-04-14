/**
 *
 * 063. Unique Paths II
 *     Follow up for "Unique Paths":
 *     
 *     Now consider if some obstacles are added to the grids. How many unique paths would 
 *     there be?
 *     
 *     An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *     
 *     For example,
 *     There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *     
 *     [
 *       [0,0,0],
 *       [0,1,0],
 *       [0,0,0]
 *     ]
 *     The total number of unique paths is 2.
 *     
 *     Note: m and n will be at most 100.
 *
 */
import java.util.*;

public class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
			return 0;
		}
		for (int i = 0; i < obstacleGrid.length; ++i) {
			for (int j = 0; j < obstacleGrid[0].length; ++j) {
				if (i == 0 && j == 0) {
					obstacleGrid[i][j] = 1;
				} else if (obstacleGrid[i][j] == 1) {
					obstacleGrid[i][j] = 0;
				} else {
					obstacleGrid[i][j] += (i > 0 && i < obstacleGrid.length) ? obstacleGrid[i - 1][j] : 0;
					obstacleGrid[i][j] += (j > 0 && j < obstacleGrid[0].length) ? obstacleGrid[i][j-1] : 0;
				}
			}
		}
		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
}