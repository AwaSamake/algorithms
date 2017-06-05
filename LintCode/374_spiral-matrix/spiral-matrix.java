/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/spiral-matrix
@Language: Java
@Datetime: 17-06-04 22:01
*/

public class Solution {
    /**
     * @param matrix a matrix of m x n elements
     * @return an integer list
     */
    public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		if (m < 1) {
			return new ArrayList<Integer>();
		}
		int n = matrix[0].length;
		if (n < 1) {
			return new ArrayList<Integer>();
		}
		List<Integer> list = new ArrayList<Integer>(m * n);
		int depth = (Math.min(m, n) + 1) / 2;
		
		for (int layer = 0; layer < depth; ++layer) {
			// left to right
			for (int i = layer; i < n - layer; ++i) {
				list.add(matrix[layer][i]);
			}
			
			// up to down
			for (int i = layer + 1; i < m - layer; ++i) {
				list.add(matrix[i][n - layer - 1]);
			}
			if ((m - layer - 1) == layer ||  layer == (n - layer - 1)) {
				break;
			}
			// left <- right
			for (int i = n - layer - 2; i >= layer; --i) {
				list.add(matrix[m - layer - 1][i]);
			}
			
			// down -> up
			for (int i = m - layer - 2; i > layer; --i) {
				list.add(matrix[i][layer]);
			}
		}
		return list;
	}
}