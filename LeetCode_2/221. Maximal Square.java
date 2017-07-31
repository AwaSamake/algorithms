public class Solution {
	public int maximalSquare(char[][] matrix) {
		int max = 0;
		int rows = matrix.length;
		if (rows < 1) {
			return max;
		}
		int cols = matrix[0].length;
		if (cols < 1) {
			return max;
		}
		int[][] area = new int[rows][cols];
		for (int i = 0; i < rows; ++i) {
			if (matrix[i][0] == '1') {
				area[i][0] = 1;
				max = 1;
			}
		}
		for (int i = 0; i < cols; ++i) {
			if (matrix[0][i] == '1') {
				area[0][i] = 1;
				max = 1;
			}
		}
		for (int i = 1; i < rows; ++i) {
			for (int j = 1; j < cols; ++j) {
				if (matrix[i][j] == '1') {
					area[i][j] = 1 + Math.min(Math.min(area[i - 1][j], area[i][j - 1]), area[i - 1][j - 1]);
					if (area[i][j] > max) {
						max = area[i][j];
					}
				}
			}
		}
		return max * max;
	}
}