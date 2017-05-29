/*
@Copyright:LintCode
@Author:   LLihao
@Problem:  http://www.lintcode.com/problem/search-a-2d-matrix-ii
@Language: Java
@Datetime: 17-05-29 21:21
*/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        int count = 0;
        int r = 0, c = matrix[0].length - 1;
        while (r < matrix.length && c > -1) {
            if (matrix[r][c] == target) {
                count++;
            }
            if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return count;
    }
}
