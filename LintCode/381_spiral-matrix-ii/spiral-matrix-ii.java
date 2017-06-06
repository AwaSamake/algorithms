/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/spiral-matrix-ii
@Language: Java
@Datetime: 17-06-06 23:48
*/

public class Solution {
    /**
     * @param n an integer
     * @return a square matrix
     */
    public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int index = 1;
		int depth = (n + 1) / 2;
		
		for (int layer = 0; layer < depth; ++layer) {
			// left to right
			for (int i = layer; i < n - layer; ++i) {
				matrix[layer][i] = index++;
			}
			
			// up to down
			for (int i = layer + 1; i < n - layer; ++i) {
				matrix[i][n - layer - 1] = index++;
			}
			if ((n - layer - 1) == layer ||  layer == (n - layer - 1)) {
				break;
			}
			// left <- right
			for (int i = n - layer - 2; i >= layer; --i) {
				matrix[n - layer - 1][i] = index++;
			}
			
			// down -> up
			for (int i = n - layer - 2; i > layer; --i) {
				matrix[i][layer] = index++;
			}
		}
		return matrix;
	}
}