/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/set-matrix-zeroes
@Language: Java
@Datetime: 17-05-27 23:56
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return;
        }
        
        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];
        
        for (int r = 0; r < rows.length; ++r) {
            for (int c = 0; c < cols.length; ++c) {
                if (matrix[r][c] == 0) {
                    rows[r] = 1;
                    cols[c] = 1;
                }
            }
        }
        
        for (int i = 0; i < rows.length; ++i) {
            if (rows[i] == 1) {
                for (int col = 0; col < matrix[0].length; ++col) {
                    matrix[i][col] = 0;
                }
            }
        }
        
        for (int i = 0; i < cols.length; ++i) {
            if (cols[i] == 1) {
                for (int row = 0; row < matrix.length; ++row) {
                    matrix[row][i] = 0;
                }
            }
        }
    }
}