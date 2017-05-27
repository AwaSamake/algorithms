/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/rotate-image
@Language: Java
@Datetime: 17-05-27 04:22
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        int width = matrix.length;
        if (width < 2) {
            return;
        }
        for (int r = 0; r < width / 2; ++r) {
            for (int c = r; c < width - r - 1; ++c) {
                rotate(matrix, r, c, width - 1);
            }
        }
    }
    
    private void rotate(int[][] matrix, int r, int c, int w) {
        int temp = matrix[r][c];
        matrix[r][c] = matrix[w - c][r];
        matrix[w- c][r] = matrix[w - r][w - c];
        matrix[w - r][w - c] = matrix[c][w - r];
        matrix[c][w - r] = temp;
    }
}