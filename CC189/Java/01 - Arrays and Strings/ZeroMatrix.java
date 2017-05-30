/**
 *
 * 1.8 Zero Matrix
 *     Write an algorithm such that if an element in an MxN matrix is 0, its entire row
 *     and column are set to 0.
 *
 */
class ZeroMatrix {
    int[][] zeroMatrix(int[][] matrix) {
        boolean[] rowZero = new boolean[matrix.length];
        boolean[] colZero = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            if (rowZero[i]) {
                for (int c = 0; c < matrix[0].length; ++c) {
                    matrix[i][c] = 0;
                }
            }
        }

        for (int j = 0; j < matrix[0].length; ++j) {
            if (colZero[j]) {
                for (int r = 0; r < matrix.length; ++r) {
                    matrix[r][j] = 0;
                }
            }
        }
        return matrix;
    }
    
	public static void main(String[] args) {
		
	}
}