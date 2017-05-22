/**
 *
 *  498. Diagonal Traverse
 *    Given a matrix of M x N elements (M rows, N columns), return all elements of the 
 *    matrix in diagonal order as shown in the below image.
 *    
 *    Example:
 *    Input:
 *    [
 *     [ 1, 2, 3 ],
 *     [ 4, 5, 6 ],
 *     [ 7, 8, 9 ]
 *    ]
 *    Output:  [1,2,4,7,5,3,6,8,9]
 *    Explanation:
 *    
 *    Note:
 *    The total number of elements of the given matrix will not exceed 10,000.
 *
 */
import java.util.*;

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {};
        }
        int h = matrix.length, w = matrix[0].length;
        int[] result = new int[h * w];
        int r = 0, c = 0, i = 0, x = -1, y = 1;
        while (i < result.length) {
            boolean changeDirection = false;
            if (r >= h) { // hit bottom
                r--;
                c += 2;
                changeDirection = true;
            }
            if (c >= w) { // hit right
                r += 2;
                c --;
                changeDirection = true;
            }

            if (r < 0) { // hit top
                r ++;
                changeDirection = true;
            }
            if (c < 0) {
                c++;
                changeDirection = true;
            }
            result[i++] = matrix[r][c];
            if (changeDirection) {
                x = -x;
                y = -y;
            }
            r += x;
            c += y;
        }
        return result;
    }
}